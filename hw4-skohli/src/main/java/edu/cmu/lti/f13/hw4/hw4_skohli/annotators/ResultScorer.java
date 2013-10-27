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

import edu.cmu.lti.f13.hw4.hw4_skohli.utils.WordVectorUtil;
import edu.cmu.lti.f13.hw4.hw4_skohli.constants.PatternConstants;
import edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.EnrichedDocument;
import edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.QueryResultGroup;
import edu.cmu.lti.f13.hw4.hw4_skohli.interimtypes.FrequencyVector;
import edu.cmu.lti.f13.hw4.hw4_skohli.interimtypes.QueryDictionary;
import edu.cmu.lti.f13.hw4.hw4_skohli.typesystems.Document;

public class ResultScorer extends JCasAnnotator_ImplBase {
	static Pattern qidPattern = Pattern.compile(PatternConstants.QUSETION_ID);
	static Pattern relPattern = Pattern.compile(PatternConstants.RELEVANCE);

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {

		// System.out.println("Entered"+this.getClass());
		int i = 0;

		FSIterator<Annotation> iter = jcas.getAnnotationIndex().iterator();
		if (iter.isValid()) {
			iter.moveToNext();
			Document doc = (Document) iter.get();
			// System.out.println(i);
			if (doc.getRelevanceValue() != 99) {
				FrequencyVector wordpR = new FrequencyVector(doc.getText().split(" "));
				String queryString = QueryDictionary.getQueryString(doc
						.getQueryID());
				FrequencyVector wordpQ = new FrequencyVector(queryString.split(" "));
				double score = 0;
				double jacardIndexScore = WordVectorUtil.calculateJacardIndex(
						wordpQ.getMap(), wordpR.getMap());
				double cosineValueScore = WordVectorUtil.calculateCosineValue(
						wordpQ.getMap(), wordpR.getMap());
				double sorensonIndexScore = WordVectorUtil
						.calculateSorensonIndex(wordpQ.getMap(),
								wordpR.getMap());
				
				
				System.out.println("cosineValueScore"+cosineValueScore+" sorensonIndexScore"+sorensonIndexScore+" jacardIndexScore"+jacardIndexScore);
				doc.setScore(score);
				// QueryDirectory.getMap().put(doc.getQueryID(), doc);

				// System.out.println(score);
			}
			// return;
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