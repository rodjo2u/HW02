package hr.fer.zemris.java.custom.scripting.parser;

public class LexicalAnalysor {

	public static boolean checkVariableName(String name) {
		if (name.matches("(?i)[a-z]+(\\d|\\w)*")) {
			return true;
		}
		return false;
	}
	
	public static boolean checkFunctionName(String name) {
		if (name.matches("(?i)@[a-z]+(\\d|\\w)*")) {
			return true;
		}
		return false;
	}
}
