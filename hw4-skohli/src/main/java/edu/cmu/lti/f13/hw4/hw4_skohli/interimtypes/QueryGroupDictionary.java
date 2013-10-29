package edu.cmu.lti.f13.hw4.hw4_skohli.interimtypes;

import java.util.HashMap;
import java.util.Map;

import edu.cmu.lti.f13.hw4.hw4_skohli.typesystems.Document;
import edu.cmu.lti.f13.hw4.hw4_skohli.utils.NLP;

public class QueryGroupDictionary {
	static Map<Integer, QueryGroup> queryTuples =null;
	static QueryGroupDictionary queryDirectory=null;
	
	static
	{
		
	}
	
	private QueryGroupDictionary()
	{queryTuples = new HashMap<Integer, QueryGroup>();
	this.setQueryTuples(queryTuples);
	}	
	
	
	public  Map<Integer, QueryGroup> getQueryTuples() {
		return queryTuples;
	}



	public void setQueryTuples(Map<Integer, QueryGroup> queryTuples) {
		QueryGroupDictionary.queryTuples = queryTuples;
	}

	

	
	
	
	public static QueryGroupDictionary getInstance()
	{
		if(queryDirectory==null)
			queryDirectory=new QueryGroupDictionary();
		
		return queryDirectory;
	}
		
	
	public static Map<Integer, QueryGroup> getMap()
	{
		return getInstance().getQueryTuples();
	}
	
	
	
	public  void put(Document doc) {
		FrequencyVector frequencyVector		=new FrequencyVector(NLP.getLemmaTizedString(doc.getText()).split(" "));
		if (doc.getRelevanceValue() == 99) {
			//System.out.println("Add quesstion");
			QueryGroup queryGroup = new QueryGroup();
			
			queryGroup.setQueryId(doc.getQueryID());
			queryGroup.setQuery(doc.getText());
			queryGroup.setFrequencyVector(frequencyVector);
			queryTuples.put(queryGroup.getQueryId(), queryGroup);
		}

		else {
			//System.out.println(this.getClass()+"----inserted-----"+doc.getText());
			
			QueryGroup queryGroup = queryTuples.get(doc.getQueryID());
			queryGroup.add(doc,frequencyVector);
		
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