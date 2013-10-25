

/* First created by JCasGen Thu Oct 17 22:06:35 EDT 2013 */
package edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;
import edu.cmu.lti.f13.hw4.hw4_skohli.typesystems.Document;
import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Fri Oct 25 00:13:32 EDT 2013
 * XML source: /home/richie/git/hw4-skohli/hw4-skohli/src/main/resources/descriptors/retrievalsystem/VectorSpaceRetrieval.xml
 * @generated */
public class QueryResultGroup extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(QueryResultGroup.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected QueryResultGroup() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public QueryResultGroup(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public QueryResultGroup(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public QueryResultGroup(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: query

  /** getter for query - gets 
   * @generated */
  public EnrichedDocument getQuery() {
    if (QueryResultGroup_Type.featOkTst && ((QueryResultGroup_Type)jcasType).casFeat_query == null)
      jcasType.jcas.throwFeatMissing("query", "edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.QueryResultGroup");
    return (EnrichedDocument)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((QueryResultGroup_Type)jcasType).casFeatCode_query)));}
    
  /** setter for query - sets  
   * @generated */
  public void setQuery(EnrichedDocument v) {
    if (QueryResultGroup_Type.featOkTst && ((QueryResultGroup_Type)jcasType).casFeat_query == null)
      jcasType.jcas.throwFeatMissing("query", "edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.QueryResultGroup");
    jcasType.ll_cas.ll_setRefValue(addr, ((QueryResultGroup_Type)jcasType).casFeatCode_query, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: results

  /** getter for results - gets 
   * @generated */
  public FSArray getResults() {
    if (QueryResultGroup_Type.featOkTst && ((QueryResultGroup_Type)jcasType).casFeat_results == null)
      jcasType.jcas.throwFeatMissing("results", "edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.QueryResultGroup");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((QueryResultGroup_Type)jcasType).casFeatCode_results)));}
    
  /** setter for results - sets  
   * @generated */
  public void setResults(FSArray v) {
    if (QueryResultGroup_Type.featOkTst && ((QueryResultGroup_Type)jcasType).casFeat_results == null)
      jcasType.jcas.throwFeatMissing("results", "edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.QueryResultGroup");
    jcasType.ll_cas.ll_setRefValue(addr, ((QueryResultGroup_Type)jcasType).casFeatCode_results, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for results - gets an indexed value - 
   * @generated */
  public Document getResults(int i) {
    if (QueryResultGroup_Type.featOkTst && ((QueryResultGroup_Type)jcasType).casFeat_results == null)
      jcasType.jcas.throwFeatMissing("results", "edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.QueryResultGroup");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((QueryResultGroup_Type)jcasType).casFeatCode_results), i);
    return (Document)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((QueryResultGroup_Type)jcasType).casFeatCode_results), i)));}

  /** indexed setter for results - sets an indexed value - 
   * @generated */
  public void setResults(int i, Document v) { 
    if (QueryResultGroup_Type.featOkTst && ((QueryResultGroup_Type)jcasType).casFeat_results == null)
      jcasType.jcas.throwFeatMissing("results", "edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.QueryResultGroup");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((QueryResultGroup_Type)jcasType).casFeatCode_results), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((QueryResultGroup_Type)jcasType).casFeatCode_results), i, jcasType.ll_cas.ll_getFSRef(v));}
   
    
  //*--------------*
  //* Feature: mmr

  /** getter for mmr - gets 
   * @generated */
  public int getMmr() {
    if (QueryResultGroup_Type.featOkTst && ((QueryResultGroup_Type)jcasType).casFeat_mmr == null)
      jcasType.jcas.throwFeatMissing("mmr", "edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.QueryResultGroup");
    return jcasType.ll_cas.ll_getIntValue(addr, ((QueryResultGroup_Type)jcasType).casFeatCode_mmr);}
    
  /** setter for mmr - sets  
   * @generated */
  public void setMmr(int v) {
    if (QueryResultGroup_Type.featOkTst && ((QueryResultGroup_Type)jcasType).casFeat_mmr == null)
      jcasType.jcas.throwFeatMissing("mmr", "edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.QueryResultGroup");
    jcasType.ll_cas.ll_setIntValue(addr, ((QueryResultGroup_Type)jcasType).casFeatCode_mmr, v);}    
   
    
  //*--------------*
  //* Feature: id

  /** getter for id - gets 
   * @generated */
  public int getId() {
    if (QueryResultGroup_Type.featOkTst && ((QueryResultGroup_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.QueryResultGroup");
    return jcasType.ll_cas.ll_getIntValue(addr, ((QueryResultGroup_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets  
   * @generated */
  public void setId(int v) {
    if (QueryResultGroup_Type.featOkTst && ((QueryResultGroup_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.QueryResultGroup");
    jcasType.ll_cas.ll_setIntValue(addr, ((QueryResultGroup_Type)jcasType).casFeatCode_id, v);}    
  }

    