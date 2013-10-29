package edu.cmu.lti.f13.hw4.hw4_skohli.utils;

import java.util.Comparator;

import edu.cmu.lti.f13.hw4.hw4_skohli.interimtypes.PersistantDocument;

public class DocumentComparator implements Comparator<PersistantDocument> {

	@Override
	public int compare(PersistantDocument o1, PersistantDocument o2) {

		double ddiff = (o1.getScore() - o2.getScore());

		if (ddiff == 0) {
	//	return -1*(o1.getRelevanceValue()-o2.getRelevanceValue());
		}
		int diff = ddiff > 0 ? 1 : -1;

		diff = diff * -1;
		return diff;
	}

	public static DocumentComparator getInstance() {

		return new DocumentComparator();
	}

}
