package com.jmzombe.c3po;

import java.beans.PropertyVetoException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class PooledDataSource {
	private static ComboPooledDataSource instance = null;
	
	private static final String DB_USER = "dbUser";
	private static final String DB_PASSWORD = "dbPassword";
 
	private static final String MIN_POOL_SIZE = "minPoolSize";
			
	
	// c3p0 properties
	private static final String ACQUIRE_INCREMENT = "acquireIncrement";
	private static final String ACQUIRE_RETRY_ATTEMPTS = "aquireRetryAttempts";
	private static final String ACQUIRE_RETRY_DELAY = "aequireRetryDelay";
	private static final String AUTO_COMMIT_ON_CLOSE = "false";
	private static final String AUTOMATIC_TEST_TABLE = "autommaticTestTable";
	private static final String BREAK_AFTER_ACQUIRE_FAILURE = "breakAfterAcquireFailure";
	private static final String CHECKOUT_TIMEOUT = "checkoutTimeout";
	private static final String CONNECTION_CUSTOMIZER_CLASS_NAME = "connectionCustomizerClassName";
	private static final String CONNECTION_TESTER_CLASS_NAME = "connectionTesterClassName";
	private static final String CONTEXT_CLASS_LOADER_SOURCE = "contextClassLoaderSource";
	private static final String DATA_SOURCE_NAME = "dataSourceName";
	private static final String DEBUG_UNRETURNED_CONNECTION_STACK_TRACES = "debugUnreturnedConnectionStackTraces";
	private static final String DRIVER_CLASS = "driverClass"; 
	private static final String EXTENSIONS = "extensions"; 
	private static final String FACTORY_CLASS_LOCATION  = "factoryClassLocation";
	private static final String FORCE_IGNORE_UNRESOLVED_TRANSACTIONS = "forceIgnoreUnresolvedTransactions";
	private static final String FORCE_SYNCHRONOUS_CHECKINS = "forceSynchronousCheckins";
	private static final String FORCE_USE_NAMED_DRIVER_CLASS = "forceUseNamedDriverClass";
	private static final String IDLE_CONNECTION_TEST_PERIOD = "idleConnectionTestPeriod";
    private static final String INITIAL_POOL_SIZE = "initialPoolSize";
    private static final String JDBC_URL = "jdbcUrl";
    private static final String MAX_ADMINISTRAATIVE_TASK_TIME = "maxAdministrativeTaskTime";
    private static final String MAX_CONNECTION_AGE = "maxConnectionAge";
    private static final String MAX_IDLE_TIME = "maxIdleTime";
    private static final String MAX_IDLE_TIME_EXCESS_CONNECTIONS = "maxIdleTimeExcessConnections";
    private static final String MAX_POOL_SIZE = "maxPoolSize";
    private static final String MAX_STATEMENTS = "maxStatements";
    private static final String MAX_STATEMENTS_PER_CONNECTION = "maxStatementsPerConnection";
    					
	
	private PooledDataSource() {
    }
		
	public static ComboPooledDataSource getInstance() throws PropertyVetoException {
	      if (instance == null) {      
	          synchronized (PooledDataSource.class) {
	              if (instance == null) {
	                  instance = createPooledDataSource();
	              }
	          }
	      }
	      return instance;
	  }
	  
	private static ComboPooledDataSource createPooledDataSource() throws PropertyVetoException {
	  ComboPooledDataSource cpds = new ComboPooledDataSource();
		 
	  try {
	      int jimz = Integer.parseInt("5a");
	      System.out.println(jimz);
	  } catch (NumberFormatException e) {
		  System.out.println("invalid number");
	  }
	  
	  
	  Properties prop = new Properties();
      String fileName = "config.properties";
      try (InputStream is = PooledDataSource.class.getClassLoader().getResourceAsStream(fileName)) {
          // Load properties file from class path
     	  if (is != null) {
    		  prop.load(is);
    	  } else {
    		  throw new FileNotFoundException("property file '" + fileName + "' not found in the classpath");
    	  }
   
          // Get the database property values and print them out
          System.out.println(prop.getProperty(JDBC_URL));
          System.out.println(prop.getProperty(DB_USER));
          System.out.println(prop.getProperty(DB_PASSWORD));
          System.out.println(prop.getProperty(INITIAL_POOL_SIZE));
       	  System.out.println(prop.getProperty(MIN_POOL_SIZE));
          System.out.println(prop.getProperty(ACQUIRE_INCREMENT));
          System.out.println(prop.getProperty(MAX_POOL_SIZE));
          System.out.println(prop.getProperty(MAX_STATEMENTS));
          System.out.println(prop.getProperty(IDLE_CONNECTION_TEST_PERIOD));
          
          // test what if property does not exist?  ---> returns null, should we have a default value?
          // what if config file does not exist? --> is = null
          // what is password is bad ---> throws NumberFormatException
          
          // log when a connection is taken out and returned to pool
          // log how many connections are in pool, how many are taken out
          
          
          
            	          	  
    	  // PARM - acquireIncrement
       	  // C3P0 DEFAULT - If parm does not exist in config.properties file, use c3p0 default -> 3
    	  // DESCRIPTION - Determines how many connections at a time c3p0 will try to acquire when the
          //  pool is exhausted.
    	  String acquireIncrement = prop.getProperty(ACQUIRE_INCREMENT);
    	  if (acquireIncrement != null) {
    		  cpds.setAcquireIncrement(Integer.parseInt(acquireIncrement));
      	  }

    	  // PARM - acquireRetryAttempts
    	  // C3P0 DEFAULT - If parm does not exist in config.properties file, use c3p0 default -> 30
    	  // DESCRIPTION - Defines how many times c3p0 will try to acquire a new Connection from the 
    	  //   database before giving up. If this value is less than or equal to zero, c3p0 will keep
    	  //   trying to fetch a Connection indefinitely.
    	  String acquireRetryAttempts = prop.getProperty(ACQUIRE_RETRY_ATTEMPTS);
    	  if (acquireRetryAttempts != null) {
    	      cpds.setAcquireRetryAttempts(Integer.parseInt(acquireRetryAttempts));
    	  }
       	  
    	  // PARM - acquireRetryDelay
    	  // C3P0 DEFAULT - If parm does not exist in config.properties file, use c3p0 default -> 1000
    	  // DESCRIPTION - Milliseconds, time c3p0 will wait between acquire attempts. 
    	  String acquireRetryDelay = prop.getProperty(ACQUIRE_RETRY_DELAY);
    	  if (acquireRetryDelay != null ) {
    		  cpds.setAcquireRetryDelay(Integer.parseInt(acquireRetryDelay));
    	  }
   	  
    	  // PARM - autoCommitOnClose
    	  // C3P0 DEFAULT - If parm does not exist in config.properties file, use c3p0 default -> false
    	  // DESCRIPTION - The JDBC spec is unforgivably silent on what should happen to unresolved, pending
    	  //   transactions on Connection close. C3P0's default policy is to rollback any uncommitted, pending
    	  //   work. (I think this is absolutely, undeniably the right policy, but there is no consensus among
    	  //   JDBC driver vendors.) Setting autoCommitOnClose to true causes uncommitted pending work to be 
    	  //   committed, rather than rolled back on Connection close. [Note: Since the spec is absurdly unclear
    	  //   on this question, application authors who wish to avoid bugs and inconsistent behavior should ensure
    	  //   that all transactions are explicitly either committed or rolled-back before close is called.
    	  String autoCommitOnClose = (prop.getProperty(AUTO_COMMIT_ON_CLOSE));
    	  if (autoCommitOnClose != null) {
    	      cpds.setAutoCommitOnClose(Boolean.parseBoolean(autoCommitOnClose));
    	  }
    	  
    	  // PARM - automaticTestTable
    	  // C3P0 DEFAULT - If parm does not exist in config.properties file, use c3p0 default -> null
    	  // DESCRIPTION - If provided, c3p0 will create an empty table of the specified name, and use queries against
    	  //   that table to test the Connection. If automaticTestTable is provided, c3p0 will generate its own test query,
    	  //   therefore any preferredTestQuery set will be ignored. You should not work with the named table after c3p0 
    	  //   creates it; it should be strictly for c3p0's use in testing your Connection. (If you define your own 
    	  //   ConnectionTester, it must implement the QueryConnectionTester interface for this parameter to be useful.
    	  String automaticTestTable = prop.getProperty(AUTOMATIC_TEST_TABLE);
    	  if (automaticTestTable != null) {
    		  cpds.setAutomaticTestTable(automaticTestTable);
    	  }
    	    	    	  
    	  // PARM - breakAfterAcquireFailure
    	  // C3P0 DEFAULT - If parm does not exist in config.properties file, use c3p0 default -> false
    	  // DESCRIPTION - If true, a pooled DataSource will declare itself broken and be permanently closed if a
    	  //   Connection cannot be obtained from the database after making acquireRetryAttempts to acquire one. If
    	  //   false, failure to obtain a Connection will cause all Threads waiting for the pool to acquire a Connection
    	  //   to throw an Exception, but the DataSource will remain valid, and will attempt to acquire again following
    	  //   a call to getConnection()
    	  String breakAfterAcquireFailure = prop.getProperty(BREAK_AFTER_ACQUIRE_FAILURE);
    	  if (breakAfterAcquireFailure != null) {
    		  cpds.setBreakAfterAcquireFailure(Boolean.parseBoolean(breakAfterAcquireFailure));
    	  }
 
    	  // PARM - checkoutTimeout
    	  // C3P0 DEFAULT - If parm does not exist in config.properties file, use c3p0 default -> 0
    	  // DESCRIPTIOn - The number of milliseconds a client calling getConnection() will wait for a Connection to
    	  //   be checked-in or acquired when the pool is exhausted. Zero means wait indefinitely. Setting any positive
    	  //   value will cause the getConnection() call to time-out and break with an SQLException after the specified
    	  //   number of milliseconds.
    	  String checkoutTimeout = prop.getProperty(CHECKOUT_TIMEOUT);
    	  if (checkoutTimeout != null) {
    		  cpds.setCheckoutTimeout(Integer.parseInt(checkoutTimeout));
    	  }
       	  
    	  // PARM - connectionCustomizerClassName
    	  // C3P0 DEFAULT - If parm does not exist in config.properties file, use c3p0 default -> null
    	  // DESCRIPTION - The fully qualified class-name of an implementation of the ConnectionCustomizer interface,
    	  //   which users can implement to set up Connections when they are acquired from the database, or on check-out,
    	  //   and potentially to clean things up on check-in and Connection destruction. If standard Connection properties
    	  //   (holdability, readOnly, or transactionIsolation) are set in the ConnectionCustomizer's onAcquire() method,
    	  //   these will override the Connection default values.
    	  String connectionCustomizerClassName = prop.getProperty(CONNECTION_CUSTOMIZER_CLASS_NAME);
    	  if (connectionCustomizerClassName != null) {
    		  cpds.setConnectionCustomizerClassName(prop.getProperty(connectionCustomizerClassName));
    	  }
        	  
    	  // PARM - connectionTesterClassName
    	  // C3P0 DEFAULT - If parm does not exist in config.properties file, use c3p0 default -> com.mchange.v2.c3p0.impl.DefaultConnectionTester
    	  // DESCRIPTION - The fully qualified class name of an implementation of the ConnectionTester interface, or
    	  //   QueryConnectionTester if you would like instances to have access to a user-configured preferredTestQuery.
    	  //   This can be used to customize how c3p0 DataSources test Connections, but with the introduction of 
    	  //   automaticTestTable and preferredTestQuery configuration parameters, "rolling your own" should be overkill
    	  //   for most users. 
    	  String connectionTesterClassName = prop.getProperty(CONNECTION_TESTER_CLASS_NAME);
    	  if (connectionTesterClassName != null) {
    	      cpds.setConnectionTesterClassName(connectionTesterClassName);
    	  }
        	  
    	  // PARM - contextClassLoaderSource
    	  // C3P0 DEFAULT - If parm does not exist in config.properties file, use c3p0 default -> caller
    	  // DESCRIPTION - Must be one of caller, library, or none. Determines how the contextClassLoader (see java.lang.Thread)
    	  //   of c3p0-spawned Threads is determined. If caller, c3p0-spawned Threads (helper threads, java.util.Timer threads) 
    	  //   inherit their contextClassLoader from the client Thread that provokes initialization of the pool. If library, 
    	  //   the contextClassLoader will be the class that loaded c3p0 classes. If none, no contextClassLoader will be set
    	  //   (the property will be null), which in practice means the system ClassLoader will be used. The default setting of
    	  //   caller is sometimes a problem when client applications will be hot redeployed by an app-server. When c3p0's Threads
    	  //   hold a reference to a contextClassLoader from the first client that hits them, it may be impossible to garbage collect
    	  //   a ClassLoader associated with that client when it is undeployed in a running VM. Setting this to library can resolve
    	  //   these issues. 
    	  String contextClassLoaderSource = prop.getProperty(CONTEXT_CLASS_LOADER_SOURCE);
    	  if (contextClassLoaderSource != null) {
    		  cpds.setContextClassLoaderSource(contextClassLoaderSource);
    	  }
    
    	  // PARM - dataSourceName
    	  // C3P0 DEFAULT - If parm does not exist in config.properties file, use c3p0 default -> if configured with a named
    	  //   config, the config name, otherwise the pool's "identity token"
    	  // DESCRIPTION - Every c3p0 pooled data source is given a dataSourceName, which serves two purposes. It helps
    	  //   users find DataSources via C3P0Registry, and it is included in the name of JMX mBeans in order to help track
    	  //   and distinguish between multiple c3p0 DataSources even across application or JVM restarts. dataSourceName 
    	  //   defaults to the pool's configuration name, if a named config was used, or else to an "identity token" (an opaque, 
    	  //   guaranteed unique String associated with every c3p0 DataSource). You may update this property to any name you 
    	  //   find convenient. dataSourceName is not guaranteed to be unique � for example, multiple DataSource created from
    	  //   the same named configuration will share the same dataSourceName. But if you are going to make use of dataSourceName,
    	  //   you will probably want to ensure that all pooled DataSources within your JVM  do have unique names.
    	  String dataSourceName = prop.getProperty(DATA_SOURCE_NAME);
    	  if (dataSourceName != null) {
    		  cpds.setDataSourceName( dataSourceName);
    	  } 
    
    	  // PARM - debugUnreturnedConnectionStackTraces
    	  // C3P0 DEFAULT - If parm does not exist in config.properties file, use c3p0 default -> false
    	  // DESCRIPTION - If true, and if unreturnedConnectionTimeout is set to a positive value, then the
    	  //   pool will capture the stack trace (via an Exception) of all Connection checkouts, and the stack 
    	  //   traces will be printed when unreturned checked-out Connections timeout. This is intended to debug
    	  //   applications with Connection leaks, that is applications that occasionally fail to return Connections,
    	  //   leading to pool growth, and eventually exhaustion (when the pool hits maxPoolSize with all Connections
    	  //   checked-out and lost). This parameter should only be set while debugging, as capturing the stack trace
    	  //   will slow down every Connection check-out.
    	  String debugUnreturnedConnectionStackTraces = prop.getProperty(DEBUG_UNRETURNED_CONNECTION_STACK_TRACES);
    	  if (debugUnreturnedConnectionStackTraces != null) {
    		  cpds.setDebugUnreturnedConnectionStackTraces(Boolean.parseBoolean(prop.getProperty(debugUnreturnedConnectionStackTraces)));
    	  }    	  

    	  // Default: null
          // The fully-qualified class name of the JDBC driverClass that is expected to provide Connections. c3p0 will preload
          // any class specified here to ensure that appropriate URLs may be resolved to an instance of the driver by 
          // java.sql.DriverManager. If you wish to skip DriverManager resolution entirely and ensure that an instance of the
          // specified class is used to provide Connections, use driverClass in combination with forceUseNamedDriverClass. 
          String driverClass = prop.getProperty(DRIVER_CLASS);
          if (driverClass != null) {
        	  cpds.setDriverClass(driverClass);
          }
          
          // PARM - extensions
          // C3P0 DEFAULT - If parm does not exist in config.properties file, use c3p0 default -> an empty java.util.Map
          // DESCRIPTION - A java.util.Map (raw type) containing the values of any user-defined configuration extensions
          //   defined for this DataSource. 
          String extensions = prop.getProperty(EXTENSIONS);
          if (extensions != null) {
        	  cpds.setExtensions(new HashMap<Object, Object>());
          }
    	  
          // PARM - factoryClassLocation
          // C3P0 DEFAULT - If parm does not exist in config.properties file, use c3p0 default -> null
          // DESCRIPTION - DataSources that will be bound by JNDI and use that API's Referenceable interface to store
          //   themselves may specify a URL from which the class capable of dereferencing a them may be loaded. If (as is
          //   usually the case) the c3p0 libraries will be locally available to the JNDI service, leave this set as null.
          String factoryClassLocation = prop.getProperty(FACTORY_CLASS_LOCATION);
          if (factoryClassLocation != null) {
        	  cpds.setFactoryClassLocation(factoryClassLocation);
          }
          
          // PARM - forceIgnoreUnresolvedTransactions
          // C3P0 DEFAULT - If parm does not exist in config.properties file, use c3p0 default -> false
          // DESCRIPTION - Strongly disrecommended. Setting this to true may lead to subtle and bizarre bugs. This is a terrible
          //   setting, leave it alone unless absolutely necessary. It is here to workaround broken databases / JDBC drivers that do
          //   not properly support transactions, but that allow Connections' autoCommit flags to go to false regardless. If you are
          //   using a database that supports transactions "partially" (this is oxymoronic, as the whole point of transactions is to 
          //   perform operations reliably and completely, but nonetheless such databases are out there), if you feel comfortable 
          //   ignoring the fact that Connections with autoCommit == false may be in the middle of transactions and may hold locks
          //   and other resources, you may turn off c3p0's wise default behavior, which is to protect itself, as well as the usability
          //   and consistency of the database, by either rolling back (default) or committing (see c3p0.autoCommitOnClose above) 
          //   unresolved transactions. This should only be set to true when you are sure you are using a database that allows Connections'
          //   autoCommit flag to go to false, but offers no other meaningful support of transactions. Otherwise setting this to true is
          //   just a bad idea.	
          String forceIgnoreUnresolvedTransactions = prop.getProperty(FORCE_IGNORE_UNRESOLVED_TRANSACTIONS);
    	  if (forceIgnoreUnresolvedTransactions != null) {
    		  cpds.setForceIgnoreUnresolvedTransactions(Boolean.parseBoolean(forceIgnoreUnresolvedTransactions));
    	  }  

    	  // PARM - forceSynchronousCheckins
    	  // C3P0 DEFAULT - If parm does not exist in config.properties file, use c3p0 default -> false
    	  // DESCRIPTION - Setting this to true forces Connections to be checked-in synchronously, which under some circumstances
    	  //   may improve performance. Ordinarily Connections are checked-in asynchronously so that clients avoid any overhead of 
    	  //   testing or custom check-in logic. However, asynchronous check-in contributes to thread pool congestion, and very busy
    	  //   pools might find clients delayed waiting for check-ins to complete. Expanding numHelperThreads can help manage Thread
    	  //   pool congestion, but memory footprint and switching costs put limits on practical thread pool size. To reduce thread
    	  //   pool load, you can set forceSynchronousCheckins to true. Synchronous check-ins are likely to improve overall performance
    	  //   when testConnectionOnCheckin is set to false and no slow work is performed in a ConnectionCustomizer's onCheckIn(...) method.
    	  //   If Connections are tested or other slow work is performed on check-in, then this setting will cause clients to experience
    	  //   the overhead of that work on Connection.close(), which you must trade-off against any improvements in pool performance.
    	  String forceSynchronousCheckins = prop.getProperty(FORCE_SYNCHRONOUS_CHECKINS);
    	  if (forceSynchronousCheckins != null) {
    		  cpds.setForceIgnoreUnresolvedTransactions(Boolean.parseBoolean(forceSynchronousCheckins));
    	  }  

    	  // PARM - forceUseNamedDriverClass
    	  // C3P0 DEFAULT - If parm does not exist in config.properties file, use c3p0 default -> false
    	  // DESCRIPTION - Setting the parameter driverClass causes that class to preload and register with java.sql.DriverManager. 
    	  // However, it does not on its own ensure that the driver used will be an instance of driverClass, as DriverManager may 
    	  // (in unusual cases) know of other driver classes which can handle the specified jdbcUrl. Setting this parameter to true
    	  // causes c3p0 to ignore DriverManager and simply instantiate driverClass directly. 
    	  String forceUseNamedDriverClass = prop.getProperty(FORCE_USE_NAMED_DRIVER_CLASS);
    	  if (forceUseNamedDriverClass != null) {
    		  cpds.setForceUseNamedDriverClass(Boolean.parseBoolean(forceUseNamedDriverClass));
    	  }  
          
    	  // PARM - idleConnectionTestPeriod
    	  // C3P0 DEFAULT - If parm does not exist in config.properties file, use c3p0 default -> 0
    	  // DESCRIPTION - If this is a number greater than 0, c3p0 will test all idle, pooled but unchecked-out connections,
    	  //  every this number of seconds. 
    	  String idleConnectionTestPeriod = prop.getProperty(IDLE_CONNECTION_TEST_PERIOD);
    	  if (idleConnectionTestPeriod != null) {
    		  cpds.setIdleConnectionTestPeriod(Integer.parseInt(idleConnectionTestPeriod));
    	  }
    	  
    	  // PARM - initialPoolSize
    	  // C3P0 DEFAULT - If parm does not exist in config.properties file, use c3p0 default -> 3
    	  // DESCRIPTIOn - Number of Connections a pool will try to acquire upon startup. Should be between minPoolSize
    	  //   and maxPoolSize.  
    	  String initialPoolSize = prop.getProperty(INITIAL_POOL_SIZE);
    	  if (initialPoolSize != null) {
    		  cpds.setInitialPoolSize(Integer.parseInt(initialPoolSize));
    	  }

    	  // PARM - jdbcUrl
    	  // C3P0 DEFAULT - If parm does not exist in config.properties file, use c3p0 default -> null
    	  // DESCRIPTION - The JDBC URL of the database from which Connections can and should be acquired. Should resolve
    	  //   via java.sql.DriverManager to an appropriate JDBC Driver (which you can ensure will be loaded and available 
    	  //   by setting driverClass), or if you wish to specify which driver to use directly (and avoid DriverManager 
    	  //   resolution), you may specify driverClass in combination with forceUseNamedDriverClass. Unless you are supplying
    	  //   your own unpooled DataSource, a must always be provided and appropriate for the JDBC driver, however it is resolved. 
    	  String jdbcUrl = prop.getProperty(JDBC_URL);
    	  if (jdbcUrl != null) {
    		  cpds.setJdbcUrl(jdbcUrl);
    	  }  
    	  
    	  // PARM - maxAdministrativeTaskTime
    	  // C3P0 DEFAULT - If parm does not exist in config.properties file, use c3p0 default -> 0
    	  // DESCRIPTION - Seconds before c3p0's thread pool will try to interrupt an apparently hung task. Rarely useful. Many
    	  //   of c3p0's functions are not performed by client threads, but asynchronously by an internal thread pool. c3p0's 
    	  //   asynchrony enhances client performance directly, and minimizes the length of time that critical locks are held by
    	  //   ensuring that slow jdbc operations are performed in non-lock-holding threads. If, however, some of these tasks "hang", 
    	  //   that is they neither succeed nor fail with an Exception for a prolonged period of time, c3p0's thread pool can become
    	  //   exhausted and administrative tasks backed up. If the tasks are simply slow, the best way to resolve the problem is to
    	  //   increase the number of threads, via numHelperThreads. But if tasks sometimes hang indefinitely, you can use this parameter
    	  //   to force a call to the task thread's interrupt() method if a task exceeds a set time limit. [c3p0 will eventually recover
    	  //   from hung tasks anyway by signalling an "APPARENT DEADLOCK" (you'll see it as a warning in the logs), replacing the thread 
    	  //   pool task threads, and interrupt()ing the original threads. But letting the pool go into APPARENT DEADLOCK and then recover
    	  //   means that for some periods, c3p0's performance will be impaired. So if you're seeing these messages, increasing numHelperThreads
    	  //   and setting maxAdministrativeTaskTime might help. maxAdministrativeTaskTime should be large enough that any resonable
    	  //   attempt to acquire a Connection from the database, to test a Connection, or to destroy a Connection, would be expected
    	  //   to succeed or fail within the time set. Zero (the default) means tasks are never interrupted, which is the best and safest
    	  //   policy under most circumstances. If tasks are just slow, allocate more threads. If tasks are hanging forever, try to figure
    	  //   out why, and maybe setting maxAdministrativeTaskTime can help in the meantime. 
    	  String maxAdministrativeTaskTime = prop.getProperty(MAX_ADMINISTRAATIVE_TASK_TIME);
    	  if (maxAdministrativeTaskTime != null) {
    		  cpds.setMaxAdministrativeTaskTime(Integer.parseInt(maxAdministrativeTaskTime));
    	  }
    	  
    	  // PARM - maxConnectionAge
    	  // C3P0 DEFAULT - If parm does not exist in config.properties file, use c3p0 default -> 0  
    	  // DESCRIPTION - Seconds, effectively a time to live. A Connection older than maxConnectionAge will be destroyed and
    	  //   purged from the pool. This differs from maxIdleTime in that it refers to absolute age. Even a Connection which has
    	  //   not been much idle will be purged from the pool if it exceeds maxConnectionAge. Zero means no maximum absolute
    	  //   age is enforced.
    	  String maxConnectionAge = prop.getProperty(MAX_CONNECTION_AGE);
    	  if (maxConnectionAge != null) {
    		  cpds.setMaxConnectionAge(Integer.parseInt(maxConnectionAge));
    	  }
    	  
    	  // PARM - maxIdleTime
    	  // C3P0 DEFAULT - If parm does not exist in config.properties file, use c3p0 default -> 0 
    	  // DESCRIPTION - Seconds a Connection can remain pooled but unused before being discarded. Zero means idle connections 
    	  // never expire. 
    	  String maxIdleTime = prop.getProperty(MAX_IDLE_TIME);
    	  if (maxIdleTime != null) {
    		  cpds.setMaxIdleTime(Integer.parseInt(maxIdleTime));
    	  }
    	  
    	  // PARM - maxIdleTimeExcessConnections
    	  // C3P0 DEFAULT - If parm does not exist in config.properties file, use c3p0 default -> 0
    	  // DESCRIPTION - Number of seconds that Connections in excess of minPoolSize should be permitted to remain idle in the pool 
    	  //   before being culled. Intended for applications that wish to aggressively minimize the number of open Connections, shrinking 
    	  //   the pool back towards minPoolSize if, following a spike, the load level diminishes and Connections acquired are no longer 
    	  //   needed. If maxIdleTime is set, maxIdleTimeExcessConnections should be smaller if the parameter is to have any effect.
    	  //   Zero means no enforcement, excess Connections are not idled out.
    	  String maxIdleTimeExcessConnections = prop.getProperty(MAX_IDLE_TIME_EXCESS_CONNECTIONS);
    	  if (maxIdleTimeExcessConnections != null) {
    		  cpds.setMaxIdleTimeExcessConnections(Integer.parseInt(maxIdleTimeExcessConnections));
    	  }
    	  
    	  // PARM - maxPoolSize
    	  // C3P0 DEFAULT - If parm does not exist in config.properties file, use c3p0 default -> 15
    	  // DESCRIPTION - Maximum number of Connections a pool will maintain at any given time. 
    	  String maxPoolSize = prop.getProperty(MAX_POOL_SIZE);
    	  if (maxPoolSize != null) {
    		  cpds.setMaxPoolSize(Integer.parseInt(maxPoolSize));
    	  }
    	  
    	  // PARM - maxStatements
    	  // C3P0 DEFAULT - If parm does not exist in config.properties file, use c3p0 default -> 0
    	  // DESCRIPTION - The size of c3p0's global PreparedStatement cache. If both maxStatements and maxStatementsPerConnection
    	  //   are zero, statement caching will not be enabled. If maxStatements is zero but maxStatementsPerConnection is a non-zero
    	  //   value, statement caching will be enabled, but no global limit will be enforced, only the per-connection maximum. 
    	  //   maxStatements controls the total number of Statements cached, for all Connections. If set, it should be a fairly large
    	  //   number, as each pooled Connection requires its own, distinct flock of cached statements. As a guide, consider how many
    	  //   distinct PreparedStatements are used frequently in your application, and multiply that number by maxPoolSize to arrive 
    	  //   at an appropriate value. Though maxStatements is the JDBC standard parameter for controlling statement caching, users 
    	  //   may find c3p0's alternative maxStatementsPerConnection more intuitive to use. 
    	  String maxStatements = prop.getProperty(MAX_STATEMENTS);
    	  if (maxStatements != null) {
    		  cpds.setMaxStatements(Integer.parseInt(maxStatements));
    	  }
    	  
    	  // PARM - maxStatementsPerConnection
    	  // C3P0 DEFAULT - If parm does not exist in config.properties file, use c3p0 default -> 0 
    	  // DESCRIPTION - The number of PreparedStatements c3p0 will cache for a single pooled Connection. If both maxStatements
    	  // and maxStatementsPerConnection are zero, statement caching will not be enabled. If maxStatementsPerConnection is 
    	  // zero but maxStatements is a non-zero value, statement caching will be enabled, and a global limit enforced, but 
    	  // otherwise no limit will be set on the number of cached statements for a single Connection. If set, 
    	  // maxStatementsPerConnection should be set to about the number distinct PreparedStatements that are used frequently
    	  // in your application, plus two or three extra so infrequently statements don't force the more common cached statements
    	  // to be culled. Though maxStatements is the JDBC standard parameter for controlling statement caching, users may
    	  // find maxStatementsPerConnection more intuitive to use.  
    	  String maxStatementsPerConnection = prop.getProperty(MAX_STATEMENTS_PER_CONNECTION);
    	  if (maxStatementsPerConnection != null) {
    		  cpds.setMaxStatementsPerConnection(Integer.parseInt(maxStatementsPerConnection));
    	  }
    	  
    	  
    	  
    	  cpds.setUser(prop.getProperty(DB_USER));
    	  cpds.setPassword(prop.getProperty(DB_PASSWORD));  
      	  cpds.setMinPoolSize(Integer.parseInt(prop.getProperty(MIN_POOL_SIZE)));
    	  cpds.setMaxPoolSize(Integer.parseInt(prop.getProperty(MAX_POOL_SIZE)));
    	  cpds.setMaxStatements(Integer.parseInt(prop.getProperty(MAX_POOL_SIZE)));
    	  cpds.setIdleConnectionTestPeriod(Integer.parseInt(prop.getProperty(IDLE_CONNECTION_TEST_PERIOD)));
    	  
    	 
    	  
      } catch(IOException e) {
          System.out.println("Unable to find " + fileName);
      } 
	  
      return cpds;
	}
}
