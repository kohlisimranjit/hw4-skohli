package edu.cmu.lti.f13.hw4.hw4_skohli.interimtypes;

import java.util.HashMap;
import java.util.Map;

import edu.cmu.lti.f13.hw4.hw4_skohli.typesystems.Document;

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
			QueryGroup queryData = new QueryGroup();
			queryData.setQueryId(doc.getQueryID());
			queryData.setQuery(doc.getText());
			queryTuples.put(queryData.getQueryId(), queryData);
		}

		else {
			//System.out.println(this.getClass()+"----inserted-----"+doc.getText());
			
			QueryGroup queryData = queryTuples.get(doc.getQueryID());
			queryData.add(doc);
		
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
