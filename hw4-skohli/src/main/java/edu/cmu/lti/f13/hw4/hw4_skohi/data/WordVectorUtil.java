package edu.cmu.lti.f13.hw4.hw4_skohi.data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class WordVectorUtil {

	public static double calculateCosineValue(Map<String,Integer> wordList1,Map<String,Integer> wordList2 )
{
	Set<String> allWords=populateWordset(wordList1, wordList2);
int sq1=0;
int sq2=0;
int product=0;

Iterator<String> wordList= allWords.iterator();
while(wordList.hasNext())
{String word=wordList.next();
	Integer freq1=wordList1.get(word);
	Integer freq2=wordList2.get(word);
	
	if(freq1==null)
		freq1=0;

	if(freq2==null)
		freq2=0;
	product+=freq1*freq2;
	sq1+=freq1*freq1;
	sq2+=freq2*freq2;}


double costheta=product/(Math.sqrt(sq1)*Math.sqrt(sq2));

return costheta; 
}

	static Set<String> populateWordset(Map<String, Integer> wordList1,
			Map<String, Integer> wordList2) {
		Set<String> allWords = new HashSet<String>();

		Set<String> wordIterator = null;
		Iterator<String> iterator = null;

		wordIterator = wordList1.keySet();
		iterator = wordIterator.iterator();

		while (iterator.hasNext()) {

			allWords.add(iterator.next());

		}
		wordIterator = wordList2.keySet();
		iterator = wordIterator.iterator();
		while (iterator.hasNext()) {

			allWords.add(iterator.next());

		}

		return allWords;
	}

}
