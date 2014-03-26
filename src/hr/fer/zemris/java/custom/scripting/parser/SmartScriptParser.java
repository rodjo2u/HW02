package hr.fer.zemris.java.custom.scripting.parser;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import hr.fer.zemris.java.custom.collections.ObjectStack;
import hr.fer.zemris.java.custom.scripting.nodes.*;
import hr.fer.zemris.java.custom.scripting.tokens.*;

/**
 * This class parses submitted text and builds appropriate DocumentNode tree.
 * 
 * @author Igor Petkovski
 * 
 */
public class SmartScriptParser {

	private DocumentNode documentNode;
	private String documentBody;
	private Pattern pattern = Pattern.compile("");
	private Matcher matcher = pattern.matcher("");
	private ObjectStack objectStack;
	private TreeBuilder treeBuilder;

	/**
	 * Constructor that executes parsing of the submitted String parameter
	 * documentBody.
	 * 
	 * @param documentBody
	 */
	public SmartScriptParser(String documentBody) {
		this.documentBody = documentBody;
		parseDocument();
	}

	/**
	 * This method parses complete string representation of the document body.
	 * Also this method builds appropriate documentNode complete tree.
	 * 
	 */
	private void parseDocument() {
		// initialize parameters
		objectStack = new ObjectStack();
		documentNode = new DocumentNode();
		objectStack.push(documentNode);
		treeBuilder = new TreeBuilder(objectStack);

		// **************** Start parsing
		// parsing loop
		while (!documentBody.isEmpty()) {
			pattern = Pattern.compile("\\{\\$");
			matcher = pattern.matcher(documentBody);
			// If documentBody starts with a tag
			if (matcher.lookingAt()) {
				// parse tag,
				parseNext("tag");
			} else {
				// else parse text
				parseNext("text");
			}
		}
	}

	private void parseNext(String textOrTag) {
		// Set appropriate pattern
		if (textOrTag.equals("text")) {
			pattern = Pattern.compile("(?s)(.*?)(?=\\{\\$)");
		} else if (textOrTag.equals("tag")) {
			pattern = Pattern.compile("(?s)(\\{\\$\\s*)(.*?)(\\s*)\\$}");
		}

		// Find match and parse
		matcher = pattern.matcher(documentBody);
		if (matcher.find()) {
			//System.out.println(textOrTag + ": " + matcher.group(0));
			if (textOrTag.equals("text")) {
				treeBuilder.addTextNode(matcher.group(0));
			} else {
				treeBuilder.parseTagNode(matcher.group(0));
			}
		} else {
			throw new SmartScriptParserException(
					"Invalid document! Could not parse document.");
		}
		documentBody = documentBody.substring(matcher.group(0).length());
	}

	/*
	 * "(?s)(.*?)(?=[^\\\\]\\{\\$)(\\n)*" text Pattern pattern =
	 * Pattern.compile("(?s)(.*?)(?=[^\\\\]\\{\\$)"); node Pattern pattern =
	 * Pattern.compile("(\\{\\$\\s*)(.*?)(\\s*)\\$}");
	 */

	public DocumentNode getDocumentNode() {
		return treeBuilder.getStackPeek();
	}
}