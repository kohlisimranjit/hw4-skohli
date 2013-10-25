

/* First created by JCasGen Thu Oct 17 22:24:00 EDT 2013 */
package edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Fri Oct 25 00:13:32 EDT 2013
 * XML source: /home/richie/git/hw4-skohli/hw4-skohli/src/main/resources/descriptors/retrievalsystem/VectorSpaceRetrieval.xml
 * @generated */
public class EnrichedDocument extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(EnrichedDocument.class);
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
  protected EnrichedDocument() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public EnrichedDocument(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public EnrichedDocument(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public EnrichedDocument(JCas jcas, int begin, int end) {
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
  //* Feature: relevanceValue

  /** getter for relevanceValue - gets 
   * @generated */
  public int getRelevanceValue() {
    if (EnrichedDocument_Type.featOkTst && ((EnrichedDocument_Type)jcasType).casFeat_relevanceValue == null)
      jcasType.jcas.throwFeatMissing("relevanceValue", "edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.EnrichedDocument");
    return jcasType.ll_cas.ll_getIntValue(addr, ((EnrichedDocument_Type)jcasType).casFeatCode_relevanceValue);}
    
  /** setter for relevanceValue - sets  
   * @generated */
  public void setRelevanceValue(int v) {
    if (EnrichedDocument_Type.featOkTst && ((EnrichedDocument_Type)jcasType).casFeat_relevanceValue == null)
      jcasType.jcas.throwFeatMissing("relevanceValue", "edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.EnrichedDocument");
    jcasType.ll_cas.ll_setIntValue(addr, ((EnrichedDocument_Type)jcasType).casFeatCode_relevanceValue, v);}    
   
    
  //*--------------*
  //* Feature: queryID

  /** getter for queryID - gets 
   * @generated */
  public int getQueryID() {
    if (EnrichedDocument_Type.featOkTst && ((EnrichedDocument_Type)jcasType).casFeat_queryID == null)
      jcasType.jcas.throwFeatMissing("queryID", "edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.EnrichedDocument");
    return jcasType.ll_cas.ll_getIntValue(addr, ((EnrichedDocument_Type)jcasType).casFeatCode_queryID);}
    
  /** setter for queryID - sets  
   * @generated */
  public void setQueryID(int v) {
    if (EnrichedDocument_Type.featOkTst && ((EnrichedDocument_Type)jcasType).casFeat_queryID == null)
      jcasType.jcas.throwFeatMissing("queryID", "edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.EnrichedDocument");
    jcasType.ll_cas.ll_setIntValue(addr, ((EnrichedDocument_Type)jcasType).casFeatCode_queryID, v);}    
   
    
  //*--------------*
  //* Feature: text

  /** getter for text - gets 
   * @generated */
  public String getText() {
    if (EnrichedDocument_Type.featOkTst && ((EnrichedDocument_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.EnrichedDocument");
    return jcasType.ll_cas.ll_getStringValue(addr, ((EnrichedDocument_Type)jcasType).casFeatCode_text);}
    
  /** setter for text - sets  
   * @generated */
  public void setText(String v) {
    if (EnrichedDocument_Type.featOkTst && ((EnrichedDocument_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.EnrichedDocument");
    jcasType.ll_cas.ll_setStringValue(addr, ((EnrichedDocument_Type)jcasType).casFeatCode_text, v);}    
   
    
  //*--------------*
  //* Feature: tokenList

  /** getter for tokenList - gets 
   * @generated */
  public FSArray getTokenList() {
    if (EnrichedDocument_Type.featOkTst && ((EnrichedDocument_Type)jcasType).casFeat_tokenList == null)
      jcasType.jcas.throwFeatMissing("tokenList", "edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.EnrichedDocument");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((EnrichedDocument_Type)jcasType).casFeatCode_tokenList)));}
    
  /** setter for tokenList - sets  
   * @generated */
  public void setTokenList(FSArray v) {
    if (EnrichedDocument_Type.featOkTst && ((EnrichedDocument_Type)jcasType).casFeat_tokenList == null)
      jcasType.jcas.throwFeatMissing("tokenList", "edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.EnrichedDocument");
    jcasType.ll_cas.ll_setRefValue(addr, ((EnrichedDocument_Type)jcasType).casFeatCode_tokenList, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for tokenList - gets an indexed value - 
   * @generated */
  public FSArray getTokenList(int i) {
    if (EnrichedDocument_Type.featOkTst && ((EnrichedDocument_Type)jcasType).casFeat_tokenList == null)
      jcasType.jcas.throwFeatMissing("tokenList", "edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.EnrichedDocument");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((EnrichedDocument_Type)jcasType).casFeatCode_tokenList), i);
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((EnrichedDocument_Type)jcasType).casFeatCode_tokenList), i)));}

  /** indexed setter for tokenList - sets an indexed value - 
   * @generated */
  public void setTokenList(int i, FSArray v) { 
    if (EnrichedDocument_Type.featOkTst && ((EnrichedDocument_Type)jcasType).casFeat_tokenList == null)
      jcasType.jcas.throwFeatMissing("tokenList", "edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems.EnrichedDocument");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((EnrichedDocument_Type)jcasType).casFeatCode_tokenList), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((EnrichedDocument_Type)jcasType).casFeatCode_tokenList), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    