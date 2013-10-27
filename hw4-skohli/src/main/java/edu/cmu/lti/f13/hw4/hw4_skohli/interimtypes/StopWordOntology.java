package edu.cmu.lti.f13.hw4.hw4_skohli.interimtypes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import edu.cmu.lti.f13.hw4.hw4_skohli.VectorSpaceRetrieval;

public class StopWordOntology {

	private static Set<String> stopWords;

	private static void initialize() {
		stopWords = new HashSet<String>();
		BufferedReader br = null;
		try {

			URL docUrl = VectorSpaceRetrieval.class
					.getResource("/stopwords.txt");
			if (docUrl == null) {
				throw new IllegalArgumentException("Error opening stopwords.txt");
			}
			String line = null;
			br = new BufferedReader(new InputStreamReader(docUrl.openStream()));
			while ((line = br.readLine()) != null) {
				stopWords.add(line.trim());
			}

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
