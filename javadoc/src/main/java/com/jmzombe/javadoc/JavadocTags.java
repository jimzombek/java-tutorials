package com.jmzombe.javadoc;

/**
* <h1>Test All Javadoc Tags!</h1>
* The JavadocAnnotations class utilizes all Javadoc Tags for
* the purpose of creating Javadocs.
* <p><b>Note:</b> Giving proper comments in your program makes it more
* user friendly and it is assumed as a high quality code.</p>
*
* @author  Jim Zombek
* @version 1.0
* @since   2016-05-17
*/
public class JavadocTags {
	
	public JavadocTags() {
	}
		
	/**
	* @deprecated use {@link #new()} instead. 
	*/
	public void method1(String a) {
	}
	
	/**
    * This method persists the image into MongoDB.
    * 
	* @param  name the location of the image, relative to the url argument
	* @return      the image at the specified URL
	* 
	* @throws      IOException
	*/
	public String method2(String name) {
		return(null);
	}
	
	/**
	 * This method persists the image into MongoDB. It uses the MongoClient API.
	 * 
	 * <pre>
	 * {@code   public void MyMongoCClient() {
	 *           this = mongoClient;
	 *         }
	 * }
	 * </pre>
	 *  
	 * @param  name the location of the image, relative to the url argument
	 * @return      the image at the specified URL
	 * 
	 * @throws      IOException
	 */
	 public String method3(String name) {
		return(null);
	 }
		
	 /**
	  * This method reads an image from MongoDB. It uses the MongoClient API.
	  * 
	  * @param  name the location of the image, relative to the url argument
	  * @return      the image at the specified URL
	  * 
	  * @see         method3() for further details
	  * 
	  * @throws      IOException
	  */
	  public String method4(String name) {
	      return(null);
	  }
}

//done @author 	Adds the author of a class. 	@author name-text
//done @deprecated 	Adds a comment indicating that this API should no longer be used. 	@deprecated deprecated-text
//done @exception 	Adds a Throws subheading to the generated documentation, with the class-name and description text. 	@exception class-name description
//done {@link} 	Inserts an in-line link with visible text label that points to the documentation for the specified package, class or member name of a referenced class. T 	{@link package.class#member label}
//done @param 	Adds a parameter with the specified parameter-name followed by the specified description to the "Parameters" section. 	@param parameter-name description
//done @return 	Adds a "Returns" section with the description text. 	@return description
//done @since 	Adds a "Since" heading with the specified since-text to the generated documentation. 	@since release
//done @throws 	The @throws and @exception tags are synonyms. 	@throws class-name description
//done @version Adds a "Version" subheading with the specified version-text to the generated docs when the -version option is used. 	@
//done {@code} 	Displays text in code font without interpreting the text as HTML markup or nested javadoc tags. 	{@code text}
//@see 	Adds a "See Also" heading with a link or text entry that points to reference. 	@see reference


//{@docRoot} 	Represents the relative path to the generated document's root directory from any generated page 	{@docRoot}
//{@inheritDoc} 	Inherits a comment from the nearest inheritable class or implementable interface 	Inherits a comment from the immediate surperclass.
//{@linkplain} 	Identical to {@link}, except the link's label is displayed in plain text than code font. 	{@linkplain package.class#member label}
//@serial 	Used in the doc comment for a default serializable field.	@serial field-description | include | exclude
//@serialData 	Documents the data written by the writeObject( ) or writeExternal( ) methods 	@serialData data-description
//@serialField 	Documents an ObjectStreamField component. 	@serialField field-name field-type field-description
//{@value} 	When {@value} is used in the doc comment of a static field, it displays the value of that constant:	{@value package.class#field}

