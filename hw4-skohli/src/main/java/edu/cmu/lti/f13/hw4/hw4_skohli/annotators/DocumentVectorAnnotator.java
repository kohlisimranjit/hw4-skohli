package edu.cmu.lti.f13.hw4.hw4_skohli.annotators;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.cas.NonEmptyFSList;
import org.apache.uima.jcas.cas.TOP;
//import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.tcas.Annotation;

import edu.cmu.lti.f13.hw4.hw4_skohli.constants.PatternConstants;
import edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.EnrichedDocument;
import edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.QueryResultGroup;
import edu.cmu.lti.f13.hw4.hw4_skohli.interimtypes.FrequencyVector;
import edu.cmu.lti.f13.hw4.hw4_skohli.typesystems.Document;
import edu.cmu.lti.f13.hw4.hw4_skohli.typesystems.Token;

public class DocumentVectorAnnotator extends JCasAnnotator_ImplBase {
	static Pattern qidPattern = Pattern.compile(PatternConstants.QUSETION_ID);
	static Pattern relPattern = Pattern.compile(PatternConstants.RELEVANCE);

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
int i=0;
		FSIterator<Annotation> iter = jcas.getAnnotationIndex().iterator();
		if (iter.isValid()) {
			iter.moveToNext();
			Document doc = (Document) iter.get();
		//System.out.println(i);
			createTermFreqVector(jcas, doc);
//		return;
			// FSList fs= doc.getTokenList();
			// fs.
			// doc.addToIndexes();
		}

	}

	/**
	 * 
	 * @param jcas
	 * @param doc
	 */

	private void createTermFreqVector(JCas jcas, Document doc) {
		String docText=jcas.getDocumentText();
		//System.out.println(docText);
		
		Matcher qidMatcher = qidPattern.matcher(docText);
		Matcher relPatternMatcher = relPattern.matcher(docText);

		qidMatcher.find();
		relPatternMatcher.find();
		//System.out.println(relPatternMatcher.start()+" "+relPatternMatcher.end()+"\t"+qidMatcher.start()+" "+qidMatcher.end());;
		String relString=docText.substring(relPatternMatcher.start()+4, relPatternMatcher.end());
		String qidString=docText.substring(qidMatcher.start()+4, qidMatcher.end());		
		//System.out.println(qidString+"\t"+relString);
		
		doc.setQueryID(Integer.parseInt(qidString));
		doc.setRelevanceValue(Integer.parseInt(relString));
		doc.setText(docText.substring(relPatternMatcher.end(), docText.length()).trim());

		
		/*NonEmptyFSList nonEmptyFSList=new NonEmptyFSList(jcas);

		doc.setTokenList(nonEmptyFSList);
		NonEmptyFSList v=nonEmptyFSList;
		String arr[]=doc.getText().split(" ");
		WordMap wordMap=new WordMap(arr);
		
		Map<String,Integer> map=wordMap.getMap();
		Set<String> set=map.keySet();
		Iterator<String> iterator=set.iterator();
		while(iterator.hasNext())
		{String word=iterator.next();
			Token token=new Token(jcas);
			token.setText(word);
			token.setFrequency(map.get(word));
	v.setHead(token);		
	   if (iterator.hasNext()) {
		      NonEmptyFSList nextList=new NonEmptyFSList(jcas);
		      v.setTail(nextList);
		      v=nextList;
		    }	
		}
		
		
		
		
		v=nonEmptyFSList;
		Object object=null;
		for(int i=0;true;i++){nonEmptyFSList.getTail();
			object=nonEmptyFSList.getNthElement(i);
			if(object==nonEmptyFSList.getTail())
			break;
			Token ob = (Token)object;
			System.out.println("token \t"+ob.getText());
			}
		
		*/
		
		
		
	}

}
