package edu.cmu.lti.f13.hw4.hw4_skohli.interimtypes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class StopWordOntology {

	private static Set<String> stopWords;

	private static void initialize() {
		stopWords = new HashSet<String>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(""));
		} catch (Exception ex) {

		}

	}

	private static Set getInstance() {
		if (stopWords == null)
			initialize();

		return stopWords;
	}

	public static boolean isStopWord(String word) {

		return getInstance().contains(word);
		// return false;
	}

}
