package edu.cmu.lti.f13.hw4.hw4_skohli.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.cmu.lti.f13.hw4.hw4_skohli.interimtypes.DocumentComparator;
import edu.cmu.lti.f13.hw4.hw4_skohli.interimtypes.PersistantDocument;
import edu.cmu.lti.f13.hw4.hw4_skohli.interimtypes.QueryDictionary;
import edu.cmu.lti.f13.hw4.hw4_skohli.interimtypes.QueryGroup;
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

	static int getRankOfRelevantResultList(List<PersistantDocument> docList) {

		PersistantDocument docarr[] = new PersistantDocument[docList.size()];
		docarr = docList.toArray(docarr);

		Arrays.sort(docarr, DocumentComparator.getInstance());
		int rank = docList.size() + 1;
		for (int i = 0; i < docarr.length; i++) {

			if (docarr[i].getRelevanceValue() == 1) {

				rank = i + 1;
				System.out.println(docarr[i].getText()
						+ "relevant query found at\t" + rank);
				break;
			}
		}

		System.out.println("return rank->" + rank);
		return rank;

	}

	public static double getMRR(QueryDictionary queryDirectory) {
		System.out
				.println("<----------------------------WordVectorUtil--------------------------------->");
		System.out.println("MRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
		Map<Integer, QueryGroup> map = QueryDictionary.getMap();
		Set<Integer> keys = map.keySet();
		int count = 0;
		Iterator<Integer> iterator = keys.iterator();
		double recsum = 0;
		while (iterator.hasNext()) {
			count++;
			QueryGroup qd = map.get(iterator.next());
			System.out.println("ForId->" + qd.getQueryId());
			recsum += 1 / getRankOfRelevantResultList(qd.getResultList());
		}

		double MRR = recsum / count;

		System.out.println(MRR);
		return MRR;

	}

	public static double calculateJacardIndex(Map<String, Integer> wordList1,
			Map<String, Integer> wordList2) {
		Set<String> allWords = populateWordset(wordList1, wordList2);
		int n = allWords.size();

		double M11 = calculauteIntersection(wordList1, wordList2);

		double jaccardSimilarity = M11 / n;

		return jaccardSimilarity;
	}

	public static double calculateSorensonIndex(Map<String, Integer> wordList1,
			Map<String, Integer> wordList2) {
		Set<String> allWords = populateWordset(wordList1, wordList2);
		int n = allWords.size();

		double M11 = calculauteIntersection(wordList1, wordList2);

		double sorensonIndex = 2 * M11 / (wordList1.size() + wordList2.size());

		return sorensonIndex;
	}

	public static int calculauteIntersection(Map<String, Integer> wordList1,
			Map<String, Integer> wordList2) {
		Set<String> allWords = populateWordset(wordList1, wordList2);

		int M11 = 0;

		Iterator<String> wordList = allWords.iterator();
		while (wordList.hasNext()) {
			String word = wordList.next();
			Integer freq1 = wordList1.get(word);
			Integer freq2 = wordList2.get(word);

			if (freq1 != null && freq2 != null) {
				M11++;
			}
		}

		return M11;
	}

}
