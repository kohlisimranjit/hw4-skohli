package edu.cmu.lti.f13.hw4.hw4_skohi.data;

import java.util.ArrayList;
import java.util.List;

import edu.cmu.lti.f13.hw4.hw4_skohli.typesystems.Document;

public class QueryData {
String query;
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
List <Document> answers=new ArrayList<Document>();

void add(Document doc)
{answers.add(doc);
	}

}
