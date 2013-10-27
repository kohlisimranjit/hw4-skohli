package edu.cmu.lti.f13.hw4.hw4_skohli.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import edu.stanford.nlp.dcoref.CorefChain;
import edu.stanford.nlp.dcoref.CorefCoreAnnotations.CorefChainAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations.CollapsedCCProcessedDependenciesAnnotation;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations.TreeAnnotation;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.util.TypesafeMap.Key;

public class NLP {
	static Properties props = null;
	 static StanfordCoreNLP pipeline = null;
	
	static{ 
		 props = new Properties();
	 
	    props.put("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
	       pipeline = new StanfordCoreNLP(props);
	    //pipeline.annotate(document);
	    
	     }
	 
	 
public static List<String> getLemmatizedList( String text)
{    // creates a StanfordCoreNLP object, with POS tagging, lemmatization, NER, parsing, and coreference resolution 
   List<String> lemmatizedTokenList = new ArrayList<String>();
    
    // read some text in the text variable
   // = ""; // Add your text here!
    
    // create an empty Annotation just with the given text
    Annotation document = new Annotation(text);
    
    // run all Annotators on this text
    //StanfordCoreNLP   pipeline = new StanfordCoreNLP(props);
    pipeline.annotate(document);
    
    // these are all the sentences in this document
    // a CoreMap is essentially a Map that uses class objects as keys and has values with custom types
    List<CoreMap> sentences = document.get( SentencesAnnotation.class);
    
    for(int i=0; i<sentences.size();i++) {
    	//System.out.println(i);
    
    	CoreMap sentence=sentences.get(i);
      // traversing the words in the current sentence
      // a CoreLabel is a CoreMap with additional token-specific methods
      for (CoreLabel token: sentence.get(TokensAnnotation.class)) {
        // this is the text of the token
        //String word = token.get(TextAnnotation.class);
        // this is the POS tag of the token
        //String pos = token.get(PartOfSpeechAnnotation.class);
        // this is the NER label of the token
        //String ne = token.get(NamedEntityTagAnnotation.class);     
     
        String lemmaString = token.get(LemmaAnnotation.class); 
        lemmatizedTokenList.add(lemmaString);
        //System.out.println(i +"\t"+lemmaString+"\t"+token.originalText()+"\t"+pos+"\t" +ne);
        
        
i++;
      }

      // this is the parse tree of the current sentence
    //  Tree tree = sentence.get(TreeAnnotation.class);

      // this is the Stanford dependency graph of the current sentence
      //SemanticGraph dependencies = sentence.get(CollapsedCCProcessedDependenciesAnnotation.class);
    }

    // This is the coreference link graph
    // Each chain stores a set of mentions that link to each other,
    // along with a method for getting the most representative mention
    // Both sentence and token offsets start at 1!
    Map<Integer, CorefChain> graph = 
      document.get(CorefChainAnnotation.class);
	return lemmatizedTokenList;}




public static String getLemmaTizedString(String sentence) {
	List<String> LemmatizedList=getLemmatizedList(sentence);
String line="";
	for(String word:LemmatizedList)
	{
		line+=word+" ";
	}

	return line.trim();
}




public static void main(String args[])
{getLemmatizedList("don't good, day");
	
	}

}
