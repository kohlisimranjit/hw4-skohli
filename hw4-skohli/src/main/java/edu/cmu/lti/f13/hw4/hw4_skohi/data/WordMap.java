package edu.cmu.lti.f13.hw4.hw4_skohi.data;

import java.util.HashMap;

public class WordMap {
	HashMap<String, Integer> map = new HashMap<String, Integer>();

	WordMap() {
	}

	void add(String word) {

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

	void addFiltered(String word) {
		if (StopWordOntology.isStopWord(word))
			return;

		else
			add(word);

	}
}