package edu.cmu.lti.f13.hw4.hw4_skohli.interimtypes;

import java.util.ArrayList;
import java.util.List;

import edu.cmu.lti.f13.hw4.hw4_skohli.typesystems.Document;

public class QueryGroup{
private String query;
private FrequencyVector frequencyVector=null;
List <PersistantDocument> answers=new ArrayList<PersistantDocument>();


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
	PersistantDocument myDocument=new PersistantDocument();
	myDocument.text=doc.getText();
	myDocument.relevanceValue=doc.getRelevanceValue();
	myDocument.score=doc.getScore();
	
	answers.add(myDocument);
	}


public List<PersistantDocument> getResultList()
{
	return answers;}
public FrequencyVector getFrequencyVector() {
	return frequencyVector;
}
public void setFrequencyVector(FrequencyVector frequencyVector) {
	this.frequencyVector = frequencyVector;
}
}
