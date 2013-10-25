package edu.cmu.lti.f13.hw4.hw4_skohi.data;

import java.util.HashMap;
import java.util.Map;

import edu.cmu.lti.f13.hw4.hw4_skohli.typesystems.Document;

public class QueryDirectory {
	static Map<Integer, QueryData> queryTuples =null;
	static QueryDirectory queryDirectory=null;
	
	static
	{
		
	}
	
	private QueryDirectory()
	{queryTuples = new HashMap<Integer, QueryData>();
	this.setQueryTuples(queryTuples);
	}	
	
	
	public  Map<Integer, QueryData> getQueryTuples() {
		return queryTuples;
	}



	public void setQueryTuples(Map<Integer, QueryData> queryTuples) {
		QueryDirectory.queryTuples = queryTuples;
	}

	

	
	
	
	public static QueryDirectory getInstance()
	{
		if(queryDirectory==null)
			queryDirectory=new QueryDirectory();
		
		return queryDirectory;
	}
		
	
	public static Map<Integer, QueryData> getMap()
	{
		return getInstance().getQueryTuples();
	}
	
	
	
	public  void put(Document doc) {

		if (doc.getRelevanceValue() == 99) {
			//System.out.println("Add quesstion");
			QueryData queryData = new QueryData();
			queryData.setQueryId(doc.getQueryID());
			queryData.setQuery(doc.getText());
			queryTuples.put(queryData.getQueryId(), queryData);
		}

		else {
			//System.out.println(this.getClass()+"----inserted-----"+doc.getText());
			
			QueryData queryData = queryTuples.get(doc.getQueryID());
			queryData.add(doc);
		
		}

	
		
		
	}
	public	static QueryData getQuery(int queryId)
	{return queryTuples.get(queryId);
		
	}
	
	public	static String getQueryString(int queryId)
	{//System.out.println("Getting queryString for"+queryId);
		return getQuery(queryId).getQuery();
		
	}
	
	
	
	
	
	
}
