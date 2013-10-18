

/* First created by JCasGen Thu Oct 17 21:13:40 EDT 2013 */
package edu.cmu.lti.f13.hw4.hw4_skohli.enrichedtypesystems;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Thu Oct 17 23:59:48 EDT 2013
 * XML source: /home/richie/git/hw4-skohli/hw4-skohli/src/main/resources/descriptors/retrievalsystem/DocumentVectorAnnotator.xml
 * @generated */
public class queryCollection extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(queryCollection.class);
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
  protected queryCollection() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public queryCollection(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public queryCollection(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public queryCollection(JCas jcas, int begin, int end) {
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
     
}

    