package edu.cmu.lti.f13.hw4.hw4_skohi.data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.cmu.lti.f13.hw4.hw4_skohli.typesystems.Document;

public class WordVectorUtil {

	public static double calculateCosineValue(Map<String, Integer> wordList1,
			Map<String, Integer> wordList2) {
		Set<String> allWords = populateWordset(wordList1, wordList2);
		int sq1 = 0;
		int sq2 = 0;
		int product = 0;

		Iterator<String> wordList = allWords.iterator();
		while (wordList.hasNext()) {
			String word = wordList.next();
			Integer freq1 = wordList1.get(word);
			Integer freq2 = wordList2.get(word);

			if (freq1 == null)
				freq1 = 0;

			if (freq2 == null)
				freq2 = 0;
			product += freq1 * freq2;
			sq1 += freq1 * freq1;
			sq2 += freq2 * freq2;
		}

		double costheta = product / (Math.sqrt(sq1) * Math.sqrt(sq2));

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

	static int getRankOfRelevantResultList(List<MyDocument> docList) {
		
		MyDocument docarr[] = new MyDocument[docList.size()];
		docarr = docList.toArray(docarr);

		Arrays.sort(docarr, DocumentComparator.getInstance());
		// int rel = 0;
		int rank = docList.size() + 1;
		System.out.println("rank->" + rank);
		for (int i = 0; i < docarr.length; i++) {

			System.out.println(docarr[i].getText());
			if (docarr[i].getRelevanceValue() == 1) {
				System.out.println(docarr[i].getText() + "found!!!!!!!!");
				rank = i + 1;
				break;
			}
		}
		
		System.out.println("return rank->"+rank);
		return rank;

	}

	public static double getMRR(QueryDirectory queryDirectory) {
		System.out
				.println("<----------------------------WordVectorUtil--------------------------------->");
		System.out.println("MRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
		Map<Integer, QueryData> map = QueryDirectory.getMap();
		Set<Integer> keys = map.keySet();
		int count = 0;
		Iterator<Integer> iterator = keys.iterator();
		double recsum = 0;
		while (iterator.hasNext()) {
			count++;
			QueryData qd = map.get(iterator.next());
			System.out.println("ForId->" + qd.getQueryId());
			recsum += 1 / getRankOfRelevantResultList(qd.getResultList());
		}

		double MRR = recsum / count;

		System.out.println(MRR);
		return MRR;

	}

}
