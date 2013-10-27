package edu.cmu.lti.f13.hw4.hw4_skohli.interimtypes;

import java.util.HashMap;
import java.util.Map;

import edu.cmu.lti.f13.hw4.hw4_skohli.typesystems.Document;
import edu.cmu.lti.f13.hw4.hw4_skohli.utils.NLP;

public class QueryDictionary {
	static Map<Integer, QueryGroup> queryTuples =null;
	static QueryDictionary queryDirectory=null;
	
	static
	{
		
	}
	
	private QueryDictionary()
	{queryTuples = new HashMap<Integer, QueryGroup>();
	this.setQueryTuples(queryTuples);
	}	
	
	
	public  Map<Integer, QueryGroup> getQueryTuples() {
		return queryTuples;
	}



	public void setQueryTuples(Map<Integer, QueryGroup> queryTuples) {
		QueryDictionary.queryTuples = queryTuples;
	}

	

	
	
	
	public static QueryDictionary getInstance()
	{
		if(queryDirectory==null)
			queryDirectory=new QueryDictionary();
		
		return queryDirectory;
	}
		
	
	public static Map<Integer, QueryGroup> getMap()
	{
		return getInstance().getQueryTuples();
	}
	
	
	
	public  void put(Document doc) {

		if (doc.getRelevanceValue() == 99) {
			//System.out.println("Add quesstion");
			QueryGroup queryGroup = new QueryGroup();
			
			queryGroup.setQueryId(doc.getQueryID());
			queryGroup.setQuery(doc.getText());
			queryGroup.setFrequencyVector(new FrequencyVector(NLP.getLemmaTizedString(queryGroup.getQuery()).split(" ")));
			queryTuples.put(queryGroup.getQueryId(), queryGroup);
		}

		else {
			//System.out.println(this.getClass()+"----inserted-----"+doc.getText());
			
			QueryGroup queryGroup = queryTuples.get(doc.getQueryID());
			queryGroup.add(doc);
		
		}

	
		
		
	}
	public	static QueryGroup getQuery(int queryId)
	{return queryTuples.get(queryId);
		
	}
	
	public	static String getQueryString(int queryId)
	{//System.out.println("Getting queryString for"+queryId);
		return getQuery(queryId).getQuery();
		
	}
	
	
	
	
	
	
}
