package edu.cmu.lti.f13.hw4.hw4_skohli.annotators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
//import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.tcas.Annotation;

import edu.cmu.lti.f13.hw4.hw4_skohi.data.QueryDirectory;
import edu.cmu.lti.f13.hw4.hw4_skohi.data.WordMap;
import edu.cmu.lti.f13.hw4.hw4_skohi.data.WordVectorUtil;
import edu.cmu.lti.f13.hw4.hw4_skohli.constants.PatternConstants;
import edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.EnrichedDocument;
import edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.QueryResultGroup;
import edu.cmu.lti.f13.hw4.hw4_skohli.typesystems.Document;

public class ResultScorer extends JCasAnnotator_ImplBase {
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
			if(doc.getRelevanceValue()!=99)
			{
				WordMap wordpR=new WordMap(doc.getText().split(" "));
				String queryString=QueryDirectory.getQueryString(doc.getQueryID());
				WordMap wordpQ=new WordMap(queryString.split(" "));
		double score=		WordVectorUtil.calculateCosineValue(wordpQ.getMap(), wordpR.getMap());
doc.setScore(score);
	
		//System.out.println(score);
			}
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


}
