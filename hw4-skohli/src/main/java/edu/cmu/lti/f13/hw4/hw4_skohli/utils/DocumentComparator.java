package edu.cmu.lti.f13.hw4.hw4_skohli.utils;

import java.util.Comparator;

import edu.cmu.lti.f13.hw4.hw4_skohli.interimtypes.PersistantDocument;


public class DocumentComparator implements Comparator<PersistantDocument> {

	@Override
	public int compare(PersistantDocument o1, PersistantDocument o2) {
		int diff = o1.getScore() - o2.getScore() > 0 ? 1 : -1;

		diff = diff * -1;
		return diff;
	}

	public static DocumentComparator getInstance() {

		return new DocumentComparator();
	}

}
