
/* First created by JCasGen Thu Oct 17 22:06:35 EDT 2013 */
package edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Fri Oct 25 00:13:32 EDT 2013
 * @generated */
public class QueryResultGroup_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (QueryResultGroup_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = QueryResultGroup_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new QueryResultGroup(addr, QueryResultGroup_Type.this);
  			   QueryResultGroup_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new QueryResultGroup(addr, QueryResultGroup_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = QueryResultGroup.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.QueryResultGroup");
 
  /** @generated */
  final Feature casFeat_query;
  /** @generated */
  final int     casFeatCode_query;
  /** @generated */ 
  public int getQuery(int addr) {
        if (featOkTst && casFeat_query == null)
      jcas.throwFeatMissing("query", "edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.QueryResultGroup");
    return ll_cas.ll_getRefValue(addr, casFeatCode_query);
  }
  /** @generated */    
  public void setQuery(int addr, int v) {
        if (featOkTst && casFeat_query == null)
      jcas.throwFeatMissing("query", "edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.QueryResultGroup");
    ll_cas.ll_setRefValue(addr, casFeatCode_query, v);}
    
  
 
  /** @generated */
  final Feature casFeat_results;
  /** @generated */
  final int     casFeatCode_results;
  /** @generated */ 
  public int getResults(int addr) {
        if (featOkTst && casFeat_results == null)
      jcas.throwFeatMissing("results", "edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.QueryResultGroup");
    return ll_cas.ll_getRefValue(addr, casFeatCode_results);
  }
  /** @generated */    
  public void setResults(int addr, int v) {
        if (featOkTst && casFeat_results == null)
      jcas.throwFeatMissing("results", "edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.QueryResultGroup");
    ll_cas.ll_setRefValue(addr, casFeatCode_results, v);}
    
   /** @generated */
  public int getResults(int addr, int i) {
        if (featOkTst && casFeat_results == null)
      jcas.throwFeatMissing("results", "edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.QueryResultGroup");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_results), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_results), i);
  return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_results), i);
  }
   
  /** @generated */ 
  public void setResults(int addr, int i, int v) {
        if (featOkTst && casFeat_results == null)
      jcas.throwFeatMissing("results", "edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.QueryResultGroup");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_results), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_results), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_results), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_mmr;
  /** @generated */
  final int     casFeatCode_mmr;
  /** @generated */ 
  public int getMmr(int addr) {
        if (featOkTst && casFeat_mmr == null)
      jcas.throwFeatMissing("mmr", "edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.QueryResultGroup");
    return ll_cas.ll_getIntValue(addr, casFeatCode_mmr);
  }
  /** @generated */    
  public void setMmr(int addr, int v) {
        if (featOkTst && casFeat_mmr == null)
      jcas.throwFeatMissing("mmr", "edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.QueryResultGroup");
    ll_cas.ll_setIntValue(addr, casFeatCode_mmr, v);}
    
  
 
  /** @generated */
  final Feature casFeat_id;
  /** @generated */
  final int     casFeatCode_id;
  /** @generated */ 
  public int getId(int addr) {
        if (featOkTst && casFeat_id == null)
      jcas.throwFeatMissing("id", "edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.QueryResultGroup");
    return ll_cas.ll_getIntValue(addr, casFeatCode_id);
  }
  /** @generated */    
  public void setId(int addr, int v) {
        if (featOkTst && casFeat_id == null)
      jcas.throwFeatMissing("id", "edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.QueryResultGroup");
    ll_cas.ll_setIntValue(addr, casFeatCode_id, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public QueryResultGroup_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_query = jcas.getRequiredFeatureDE(casType, "query", "edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.EnrichedDocument", featOkTst);
    casFeatCode_query  = (null == casFeat_query) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_query).getCode();

 
    casFeat_results = jcas.getRequiredFeatureDE(casType, "results", "uima.cas.FSArray", featOkTst);
    casFeatCode_results  = (null == casFeat_results) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_results).getCode();

 
    casFeat_mmr = jcas.getRequiredFeatureDE(casType, "mmr", "uima.cas.Integer", featOkTst);
    casFeatCode_mmr  = (null == casFeat_mmr) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_mmr).getCode();

 
    casFeat_id = jcas.getRequiredFeatureDE(casType, "id", "uima.cas.Integer", featOkTst);
    casFeatCode_id  = (null == casFeat_id) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_id).getCode();

  }
}



    