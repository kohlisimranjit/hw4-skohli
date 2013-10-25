package edu.cmu.lti.f13.hw4.hw4_skohi.data;

import java.util.ArrayList;
import java.util.List;

import edu.cmu.lti.f13.hw4.hw4_skohli.typesystems.Document;

public class QueryData{
String query;
List <MyDocument> answers=new ArrayList<MyDocument>();


public String getQuery() {
	return query;
}
public void setQuery(String query) {
	this.query = query;
}
public int getQueryId() {
	return queryId;
}
public void setQueryId(int queryId) {
	this.queryId = queryId;
}
int queryId;

void add(Document doc)
{
	MyDocument myDocument=new MyDocument();
	myDocument.text=doc.getText();
	myDocument.relevanceValue=doc.getRelevanceValue();
	myDocument.score=doc.getScore();
	
	answers.add(myDocument);
	}


public List<MyDocument> getResultList()
{
	return answers;}
}
