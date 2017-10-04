package com.jmzombe.generics;


public class Translation {
  private int translationId; 
  private String name;
  private String history;
  private String translationVersion;  
 
  public Translation() {
  }
  
  public int getTranslationId() {
	return translationId;
  }
  
  public void setTranslationId(int translationId) {
	this.translationId = translationId;
  }
 
  public String getName() {
	return name;
  }

  public void setName(String name) {
	this.name = name;
  }

  public String getHistory() {
	return history;
  }

  public void setHistory(String history) {
	this.history = history;
  }

  public String getTranslationVersion() {
	return translationVersion;
  }
 
  public void setTranslationVersion(String translationVersion) {
	this.translationVersion = translationVersion;
  }
}
