package hr.fer.zemris.java.custom.scripting.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import hr.fer.zemris.java.custom.collections.ArrayBackedIndexedCollection;
import hr.fer.zemris.java.custom.collections.ObjectStack;
import hr.fer.zemris.java.custom.scripting.nodes.*;
import hr.fer.zemris.java.custom.scripting.tokens.*;

public class TreeBuilder {

	private ObjectStack stack;
	private Pattern pattern = Pattern.compile("");
	private Matcher matcher = pattern.matcher("");
	private String currentTag;

	public TreeBuilder(ObjectStack stack) {
		this.stack = stack;
	}

	/**
	 * Parses tag content and adds appropriate node to document tree structure.
	 * 
	 * @param text
	 *            Tag text content.
	 */
	public void parseTagNode(String text) {
		// loose opening and closing tags
		currentTag = text.substring(2, text.length() - 2);
		switch (determineNodeType()) {
		case ("FOR"):
			parseForNode();
			// System.out.println("parsed FOR NODE");
			break;
		case ("ECHO"):
			parseEchoNode();
			//System.out.println("parsed ECHO NODE");
			break;
		case ("END"):
			stack.pop();
			//System.out.println("parsed END NODE");
			break;
		}
	}

	private void parseForNode() {
		TokenVariable variable = getTokenVariable();
		Token startExpression = getTokenIntegerOrDouble();
		Token endExpression = getTokenIntegerOrDouble();
		Token stepExpression = getStepExpression();
		
		ForLoopNode newForNode = new ForLoopNode(variable, startExpression, endExpression,
				stepExpression);
		addNodeToStructure(newForNode);
		stack.push(newForNode);
	}

	private void parseEchoNode() {
		ArrayBackedIndexedCollection tokens = new ArrayBackedIndexedCollection();
		while (!currentTag.isEmpty()) {
			pattern = Pattern.compile("\\S*");
			matcher = pattern.matcher(currentTag);
			matcher.find();
			switch (determineTokenType(matcher.group(0))) {
			case ("VARIABLE"):
				tokens.add(getTokenVariable());
				currentTag = matcher.replaceFirst("");
				removeBeginningWhitespaces();
				break;
			case ("INTEGER"):
				tokens.add(getTokenIntegerOrDouble());
				currentTag = matcher.replaceFirst("");
				removeBeginningWhitespaces();
				break;
			case ("DOUBLE"):
				tokens.add(getTokenIntegerOrDouble());
				currentTag = matcher.replaceFirst("");
				removeBeginningWhitespaces();
				break;
			case ("STRING"):
				tokens.add(new TokenString(matcher.group(0)));
				currentTag = matcher.replaceFirst("");
				removeBeginningWhitespaces();
				break;
			case ("FUNCTION"):
				tokens.add(new TokenFunction(matcher.group(0)));
				currentTag = matcher.replaceFirst("");
				removeBeginningWhitespaces();
				break;
			case ("OPERATOR"):
				tokens.add(new TokenOperator(matcher.group(0)));
				currentTag = matcher.replaceFirst("");
				removeBeginningWhitespaces();
				break;
			}
		}
		Token[] t = new Token[tokens.size()];
		for (int i = 0; i < tokens.size(); i++) {
			t[i] = (Token) tokens.get(i);
		}
		// Add elemet to tree structure
		addNodeToStructure(new EchoNode(t));
	}

	private TokenVariable getTokenVariable() {
		pattern = Pattern.compile("\\S*");
		matcher = pattern.matcher(currentTag);
		matcher.find();
		TokenVariable variable = new TokenVariable(matcher.group(0));
		currentTag = matcher.replaceFirst("");
		removeBeginningWhitespaces();
		return variable;
	}

	private Token getTokenIntegerOrDouble() {
		removeBeginningWhitespaces();
		Token variable;
		pattern = Pattern.compile("\\S*");
		matcher = pattern.matcher(currentTag);
		matcher.find();
		if (matcher.group(0).contains(".")) {
			variable = new TokenConstantDouble(matcher.group(0));
		} else {
			variable = new TokenConstantInteger(matcher.group(0));
		}
		currentTag = matcher.replaceFirst("");
		removeBeginningWhitespaces();
		return variable;
	}

	private Token getStepExpression() {
		//removeBeginningWhitespaces();
		if (currentTag.length() == 0)
			return null;
		Token variable;
		pattern = Pattern.compile("\\S*");
		matcher = pattern.matcher(currentTag);
		matcher.find();
		variable = new TokenConstantInteger(matcher.group(0));
		return variable;
	}

	private String determineTokenType(String token) {
		if (token.matches("\\+-\\*/")) {
			return "OPERATOR";
		} else if (token.startsWith("@")) {
			return "FUNCTION";
		} else if (token.matches("\\d*")) {
			return "INTEGER";
		} else if (token.startsWith("\\\"")) {
			return "STRING";
		} else if (token.matches("\\d+.\\d*")) {
			return "DOUBLE";
		} else
			return "VARIABLE";
	}

	/**
	 * Method removes whitespace characters from the beginning of the
	 * currentTag.
	 */
	private void removeBeginningWhitespaces() {
		pattern = Pattern.compile("\\s*");
		matcher = pattern.matcher(currentTag);
		matcher.find();
		if (matcher.find()) {
			currentTag = matcher.replaceFirst("");
		}
	}

	/**
	 * Method determines tag type by parsing currentTag content.
	 * <p>
	 * If a tag type has been determined this method removes tag type prefix
	 * from tag type content.
	 * 
	 * @return Returns Strings FOR, ECHO or END depending of tag type.
	 * @throws SmartScriptParserException
	 *             If tag type cannot be determined.
	 */
	private String determineNodeType() {
		// Check is it FOR tag
		pattern = Pattern.compile("(?i)\\s*FOR\\s*");
		matcher = pattern.matcher(currentTag);
		if (matcher.find()) {
			// System.out.println("for petlja je");
			currentTag = matcher.replaceFirst("");
			return "FOR";
		}
		// Check is it ECHO tag
		pattern = Pattern.compile("\\s*=\\s*");
		matcher = pattern.matcher(currentTag);
		if (matcher.find()) {
			// System.out.println("echo petlja je");
			currentTag = matcher.replaceFirst("");
			return "ECHO";
		}
		// Check is it END tag
		pattern = Pattern.compile("(?i)\\s*END\\s*");
		matcher = pattern.matcher(currentTag);
		if (matcher.find()) {
			// System.out.println("end petlja je");
			currentTag = matcher.replaceFirst("");
			return "END";
		}
		// If it comes to this point in code tag content is invalid
		throw new SmartScriptParserException(
				"Invalid tag content! Tag content: " + currentTag);
	}

	/**
	 * Creates new TextNode and adds it to document tree structure.
	 * 
	 * @param text
	 *            Text to create TextNode with.
	 */
	public void addTextNode(String text) {
		TextNode textNode = new TextNode(text);
		addNodeToStructure(textNode);
	}
	
	/**
	 * Method adds submitted Node type object as a child element to Node at the
	 * top of the stack.
	 * 
	 * @param node
	 *            Node to be added as a child element.
	 */
	private void addNodeToStructure(Node node) {
		Node rootNode = (Node) stack.peek();
		rootNode.addChildNode(node);
	}

	public DocumentNode getStackPeek() {
		return (DocumentNode)stack.peek();
	}
}
