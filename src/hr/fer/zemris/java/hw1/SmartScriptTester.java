package hr.fer.zemris.java.hw1;

import hr.fer.zemris.java.custom.scripting.parser.*;
import hr.fer.zemris.java.custom.scripting.nodes.DocumentNode;
import hr.fer.zemris.java.custom.scripting.nodes.ForLoopNode;
import hr.fer.zemris.java.custom.scripting.nodes.Node;

public class SmartScriptTester {

	/*
	 * Dragi poštovani kolega recenzentu!
	 * 
	 * Žao mi je što ćete morati recenzirati ovako loš kod koji k tome ne radi. Parser radi samo za 
	 * defaultni primjer datoteke dan u tekstu zadatka zadaće. Ne registrira \{$ kao string, već kao
	 * normalan tag. Nemam implementirane skoro nikakve exceptione
	 *  i ne provjeravam ispravnost imena varijabli, funkcija(imam funkcije al nisam stigo ubacit u kod)...
	 * varijabli i slično.
	 */
	public static void main(String[] args) {
		String docBody = "This is sample text.\r\n{$ FOR i 1 10 1 $}\r\n\tThis is {$= i $}-th time this message is generated.\r\n{$END$}\r\n{$FOR i 0 10 2 $}\r\n\tsin({$=i$}^2) = {$= i i * @sin \"0.000\" @decfmt $}\n{$END$}";
		SmartScriptParser parser = null;
		try {
			parser = new SmartScriptParser(docBody);
		} catch (SmartScriptParserException e) {
			System.out.println("Unable to parse document!");
			System.exit(-1);
		} catch (Exception e) {
			System.out
					.println("If this line ever executes, you have failed this class!");
			System.exit(-1);
		}
		DocumentNode document = parser.getDocumentNode();
		String originalDocumentBody = createOriginalDocumentBody(document);
		System.out.println(originalDocumentBody); // should write something like
												 // original content of docBody

	}

	public static String createOriginalDocumentBody(DocumentNode document) {
		for (int i = 0; i < document.numberOfChildren(); i++) {
			displayChildNodes((Node)document.getChild(i));
			if (document.getChild(i).getClass().equals(ForLoopNode.class)) {
				System.out.print("{$ END $}");
			}
			
		}
		return "";
	}
	
	public static void displayChildNodes(Node node) {
		System.out.print(node.toString());
		for (int i = 0; i < node.numberOfChildren(); i++) {
			displayChildNodes((Node)node.getChild(i));
			if (node.getChild(i).getClass().equals(ForLoopNode.class)) {
				System.out.print("{$ END $}");
			}
		}
		
		
	}
}
