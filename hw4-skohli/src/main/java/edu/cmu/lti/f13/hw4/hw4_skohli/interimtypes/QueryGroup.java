package edu.cmu.lti.f13.hw4.hw4_skohli.interimtypes;

import java.util.ArrayList;
import java.util.List;

import edu.cmu.lti.f13.hw4.hw4_skohli.typesystems.Document;

public class QueryGroup {
	private String query;
	private FrequencyVector frequencyVector = null;
	List<PersistantDocument> answers = new ArrayList<PersistantDocument>();

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

	void add(Document doc, FrequencyVector frequencyVector) {
		PersistantDocument myDocument = new PersistantDocument(
				answers.size() + 1);
		myDocument.text = doc.getText();
		myDocument.relevanceValue = doc.getRelevanceValue();
		myDocument.score = doc.getScore();
		myDocument.setFrequencyVector(frequencyVector);
		answers.add(myDocument);
	}

	public List<PersistantDocument> getResultList() {
		return answers;
	}

	public FrequencyVector getFrequencyVector() {
		return frequencyVector;
	}

	public void setFrequencyVector(FrequencyVector frequencyVector) {
		this.frequencyVector = frequencyVector;
	}

	public String toString() {
		int pos = 0;
		PersistantDocument doc = null;
		for (pos = 0; pos < answers.size(); pos++) {
			 doc = answers.get(pos);

			if (doc.getRelevanceValue() == 1) {
break;
			}

		}
		if(pos<answers.size())
		pos++;
		String string ="Score:"+doc.getScore()+" rank="+pos+" rel="+doc.getRelevanceValue()+" qid=" +queryId +" sent"+doc.getSentenceId();

		return string;
	}
}
