package com.jmzombe.generics;

import java.util.ArrayList;
import java.util.List;

public class OrganizationDao implements BaseDao<Organization> {

  @Override
  public Organization get(int id)  {
       return new Organization();
  }
 
  @Override
  public List<Organization> list()  {
      return new ArrayList<Organization>();
  }
  
  @Override
  public int add(Organization organization)  {
      return 0;
  }
  
  @Override
  public void update(Organization organization) {
  }
  
  @Override
  public void delete(int id) {
  }
  
 }