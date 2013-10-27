package edu.cmu.lti.f13.hw4.hw4_skohli.interimtypes;

import java.util.HashMap;
import java.util.Map;

public class FrequencyVector {
	HashMap<String, Integer> map =null;

	public FrequencyVector() {
		 map = new HashMap<String, Integer>();
	}

	public FrequencyVector(String words[]) {
		this();
		
		for(String word:words)
		{
			
			add(word);
		}
		
		
	}
	public void add(String word) {
word=word.toLowerCase();
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

public	void addFiltered(String word) {
		if (StopWordOntology.isStopWord(word))
			return;

		else
			add(word);

	}


public Map<String, Integer> getMap()
{return map;}
}