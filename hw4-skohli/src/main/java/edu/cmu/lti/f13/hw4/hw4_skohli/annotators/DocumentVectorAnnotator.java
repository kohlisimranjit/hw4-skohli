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

import edu.cmu.lti.f13.hw4.hw4_skohli.constants.PatternConstants;
import edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.EnrichedDocument;
import edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.QueryResultGroup;
import edu.cmu.lti.f13.hw4.hw4_skohli.typesystems.Document;

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
		// TO DO: construct a vector of tokens and update the tokenList in CAS

		/*FSArray fsArray = null;
		// new FSArray(jcas, 10);

		String docText = doc.getText();
		String jcasString = jcas.getDocumentText();
		String jcasSentence[] = jcasString.split("\n");
		String docTextSentence[] = docText.split("\n");

//		int j = 0;

		QueryResultGroup queryGroup = null;
for(int i=0;i<10;i++)
{System.out.println(i);}
		for (int i=0;i<jcasSentence.length;i++) {
			String sentence = jcasSentence[i];
			System.out.println(i+"->now checking==========" + sentence);
			Matcher qidMatcher = qidPattern.matcher(sentence);
			Matcher relPatternMatcher = relPattern.matcher(sentence);

			EnrichedDocument enrichedDocument = new EnrichedDocument(jcas);

			enrichedDocument.setText(docTextSentence[i]);
			qidMatcher.find();

			relPatternMatcher.find();
			if (sentence.indexOf("rel=99") > -1) {
				//j = 0;
				queryGroup = new QueryResultGroup(jcas);

				enrichedDocument.setRelevanceValue(99);
				queryGroup.setQuery(enrichedDocument);
				fsArray = new FSArray(jcas, 10);
				System.out.println("fsArray->" + fsArray);
				queryGroup.setResults(fsArray);
			} else {
				System.out.println("fsArray->" + fsArray);
				//fsArray.set(j++, enrichedDocument);

			}

			// ListBase lb=queryGroup.getResults();

			// System.out.print("Start index: " + qidMatcher.start());
			// System.out.print(" End index: " + qidMatcher.end() + " ");
			// System.out.println(qidMatcher.group());
			// System.out.println(relPatternMatcher.group());
			// System.out.println(docTextSentence[i++]);
System.out.println("endend"+i);
		}
		// System.out.println(myMatcher.start());
*/	}

}
