package edu.cmu.lti.f13.hw4.hw4_skohli.interimtypes;

public class PersistantDocument {
int relevanceValue;
double score;
String text;


public int getRelevanceValue() {
	return relevanceValue;
}
public void setRelevanceValue(int relevanceValue) {
	this.relevanceValue = relevanceValue;
}



public double getScore() {
	return score;
}
public void setScore(double score) {
	this.score = score;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}


}