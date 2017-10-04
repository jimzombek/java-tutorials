package com.jmzombe.generics;

public class Main {
  
	public static void main(String[] args) {
		
		OrganizationDao organizationDao = new OrganizationDao();
		Organization organization = organizationDao.get(1);
		organizationDao.add(new Organization());
		organizationDao.update(new Organization());
		organizationDao.list();
		organizationDao.delete(1);
	}
}
