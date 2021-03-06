package edu.cmu.cs.sasylf.ast.grammar;

import java.util.HashMap;
import java.util.Map;

import edu.cmu.cs.sasylf.grammar.NonTerminal;

public class GrmUtil {
	private static NonTerminal startSymbol;
	private static Map<String, GrmTerminal> terminalMap = new HashMap<String, GrmTerminal>();

	public static NonTerminal getStartSymbol() {
		if (startSymbol == null)
			startSymbol = new GrmNonTerminal("__START");
		return startSymbol;
	}

	public static GrmTerminal terminalFor(String symbol) {
		GrmTerminal result = terminalMap.get(symbol);
		if (result == null) {
			result = new GrmTerminal(symbol, null);
			terminalMap.put(symbol, result);
		}
		return result;
	}

	public static GrmTerminal getLeftParen() {
		return terminalFor("'('");
	}

	public static GrmTerminal getRightParen() {
		return terminalFor("')'");
	}
}
