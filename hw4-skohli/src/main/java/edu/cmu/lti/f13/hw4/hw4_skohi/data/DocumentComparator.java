package edu.cmu.lti.f13.hw4.hw4_skohi.data;

import java.util.Comparator;

import edu.cmu.lti.f13.hw4.hw4_skohli.typesystems.Document;

public class DocumentComparator implements Comparator<Document>{

	@Override
	public int compare(Document o1, Document o2) {
int diff=o1.getScore()-o2.getScore()>0?1:-1;
		
		diff=diff*-1;
		return diff;
	}

	public static DocumentComparator getInstance()
	{
		
		return new DocumentComparator();
	}
	

	
	
}
