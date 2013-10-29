package edu.cmu.lti.f13.hw4.hw4_skohli.casconsumers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;
import org.apache.uima.util.ProcessTrace;

import edu.cmu.lti.f13.hw4.hw4_skohli.utils.*;
import edu.cmu.lti.f13.hw4.hw4_skohli.constants.ReportConstants;
import edu.cmu.lti.f13.hw4.hw4_skohli.interimtypes.FrequencyVector;
import edu.cmu.lti.f13.hw4.hw4_skohli.interimtypes.PersistantDocument;
import edu.cmu.lti.f13.hw4.hw4_skohli.interimtypes.QueryGroupDictionary;
import edu.cmu.lti.f13.hw4.hw4_skohli.interimtypes.QueryGroup;
import edu.cmu.lti.f13.hw4.hw4_skohli.typesystems.Document;

public class RetrievalEvaluator extends CasConsumer_ImplBase {

	/** query id number **/
	public ArrayList<Integer> qIdList;

	/** query and text relevant values **/
	public ArrayList<Integer> relList;

	public void initialize() throws ResourceInitializationException {

		qIdList = new ArrayList<Integer>();

		relList = new ArrayList<Integer>();

	}

	/**
	 * TODO :: 1. construct the global word dictionary 2. keep the word
	 * frequency for each sentence
	 */
	@Override
	public void processCas(CAS aCas) throws ResourceProcessException {

		JCas jcas;
		try {
			jcas = aCas.getJCas();
		} catch (CASException e) {
			throw new ResourceProcessException(e);
		}

		FSIterator it = jcas.getAnnotationIndex(Document.type).iterator();

		if (it.hasNext()) {
			Document doc = (Document) it.next();

			// Make sure that your previous annotators have populated this in
			// CAS
			FSList fsTokenList = doc.getTokenList();

	/*		System.out.println(doc.getQueryID() + "-text->" + doc.getText()	+ " " + doc.getScore() + " " + doc.getRelevanceValue()
					+ "</text>");
		*/
			
			// ArrayList<Token>tokenList=Utils.fromFSListToCollection(fsTokenList,
			// Token.class);

			qIdList.add(doc.getQueryID());
			relList.add(doc.getRelevanceValue());

			// Do something useful here

		}

	}

	/**
	 * TODO 1. Compute Cosine Similarity and rank the retrieved sentences 2.
	 * Compute the MRR metric
	 */
	@Override
	public void collectionProcessComplete(ProcessTrace arg0)
			throws ResourceProcessException, IOException {
		System.out
				.println("*****************************************************************************************************************");
		super.collectionProcessComplete(arg0);

		// TODO :: compute the cosine similarity measure
		Map<Integer, QueryGroup> map = QueryGroupDictionary.getInstance()
				.getQueryTuples();

		for (int algo = 1; algo <= ReportConstants.ALGO_NAMES.length; algo++) {
			System.out.println("Calculating score using the "+ReportConstants.ALGO_NAMES[algo-1]+" Algorithm");
			int queryGroups = map.size();
			for (int queryNumber = 1; queryNumber <= queryGroups; queryNumber++) {
				
			
				QueryGroup queryGroup = map.get(queryNumber);
				FrequencyVector wordpQ = queryGroup.getFrequencyVector();
				List<PersistantDocument> doc = queryGroup.getResultList();
				for (PersistantDocument persistantDocument : doc) {
					FrequencyVector wordpR = persistantDocument
							.getFrequencyVector();

					double score = 0;
				
					if(algo==1)
					{score = WordVectorUtil
							.calculateCosineValue(wordpQ.getMap(),
									wordpR.getMap());}
					if(algo==2)
					{	score = WordVectorUtil
							.calculateJacardIndex(wordpQ.getMap(),
									wordpR.getMap());
					}
					if(algo==3)
					{score = WordVectorUtil
							.calculateSorensonIndex(wordpQ.getMap(),
									wordpR.getMap());
					}
					//score = cosineValueScore;
					//System.out.println("Score" + score		+ " sorensonIndexScore" + sorensonIndexScore+ " jacardIndexScore" + jacardIndexScore);

					
					persistantDocument.setScore(score);
					// doc.setScore(score);

				}
//System.out.println(queryGroup);
			}
			double metric_mrr = compute_mrr();
			System.out.println(ReportConstants.ALGO_NAMES[algo-1]+". (MRR) Mean Reciprocal Rank::" + metric_mrr);

		}

		// TODO :: compute the rank of retrieved sentences
		// arg0.

		// TODO :: compute the metric:: mean reciprocal rank

	}

	/**
	 * 
	 * @return cosine_similarity
	 */
	/*
	 * private double computeCosineSimilarity(Map<String, Integer> queryVector,
	 * Map<String, Integer> docVector) { double cosine_similarity=0.0;
	 * 
	 * // TODO :: compute cosine similarity between two sentences
	 * 
	 * 
	 * return cosine_similarity; }
	 */

	/**
	 * 
	 * @return mrr
	 */
	private double compute_mrr() {

		QueryGroupDictionary queryDirectory = QueryGroupDictionary
				.getInstance();
		double metric_mrr = WordVectorUtil.getMRR(queryDirectory);

		// TODO :: compute Mean Reciprocal Rank (MRR) of the text collection

		return metric_mrr;
	}

}
