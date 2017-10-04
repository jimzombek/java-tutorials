package com.jmzombe.generics;

import java.util.ArrayList;
import java.util.List;

public class TranslationDao implements BaseDao<Translation> {

  @Override
  public Translation get(int id)  {
       return new Translation();
  }
 
  @Override
  public List<Translation> list()  {
      return new ArrayList<Translation>();
  }
  
  @Override
  public int add(Translation translation)  {
      return 0;
  }
  
  @Override
  public void update(Translation translation) {
  }
  
  @Override
  public void delete(int id) {
  }
  
 }