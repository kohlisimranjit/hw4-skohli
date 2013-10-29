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

import edu.cmu.lti.f13.hw4.hw4_skohli.interimtypes.FrequencyVector;
import edu.cmu.lti.f13.hw4.hw4_skohli.interimtypes.QueryGroupDictionary;
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
	 * @param Function takes in Jcas and the document.
	 * From the document it extracts the string and stores it in persistent doc. 
	 *While storing in persistentdoc the termFrequency vector is calculated and inserted alongside it.
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

		QueryGroupDictionary.getInstance().put(doc);
		
		
		
	}

}
