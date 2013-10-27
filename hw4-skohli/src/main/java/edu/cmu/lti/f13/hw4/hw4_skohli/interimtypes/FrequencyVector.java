package edu.cmu.lti.f13.hw4.hw4_skohli.interimtypes;

import java.util.HashMap;
import java.util.Map;

import edu.cmu.lti.f13.hw4.hw4_skohli.utils.StopWordOntology;

public class FrequencyVector {
	HashMap<String, Integer> map = null;

	public FrequencyVector() {
		map = new HashMap<String, Integer>();
	}

	public FrequencyVector(String line) {
		this();

		String words[] = line.split(" ");
		for (String word : words) {

			addFiltered(word);
		}

	}

	public FrequencyVector(String words[]) {
		this();

		for (String word : words) {

			addFiltered(word);
		}

	}

	private void add(String word) {
		word = word.toLowerCase();
		Integer count = map.get(word);

		if (count == null) {
			count = 0;
		}
		count = count + 1;
		map.put(word, count);

	}

	int getCount(String word) {
		Integer count = map.get(word);

		if (count == null)
			count = 0;

		return count;

	}

	public void addFiltered(String word) {
		if (StopWordOntology.isStopWord(word)) {
		//	System.out.println("stop word found " + word);
			return;
		}
		/*
		 * if ("!.,".indexOf(word) > 0) {
		 * System.out.println("Special char found "+word); return; }
		 */
		if (word.matches("[a-zA-Z0-9 ]*")) {
			
			add(word);
		return;
		}
		System.out.println("Special char found "+word); 
		  return;

	}

	public Map<String, Integer> getMap() {
		return map;
	}
}