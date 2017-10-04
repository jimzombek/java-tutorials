package com.jmzombe.walkdir;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryWalker {
  public static Path path = Paths.get("c:/jmzombe");
  
  public static void main(String[] args) { 
	  String directoryName = args[0];
	  System.out.println("Directory Name: " + directoryName); 
	  listFilesAndSubDirectories(directoryName);
	  
	  try {
        listFilesAndSubDirectories2("jmzombe");
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
  }
  
  // Old School way of doing it
  public static void listFilesAndSubDirectories(String directoryName) {
	  File directory = new File(directoryName);

      // Get all the files from a directory
      File[] fList = directory.listFiles();
     
      for (File file : fList){
          if (file.isFile()) {
              System.out.println("File Name: " + file.getAbsolutePath());
          } else if (file.isDirectory()){
        	  System.out.println("Directory Name: " + file.getAbsolutePath());
              listFilesAndSubDirectories(file.getAbsolutePath());
          }
      }
  }
  
  // Java 8 Constructs, Lamada, Streams
  public static List<Path> listFilesAndSubDirectories2(String directory) throws IOException {
      return Files.walk(path)
          .filter(Files::isRegularFile)
          .filter(path -> !path.getParent().toString().contains("/target"))
          .filter(path -> path.getFileName().toString().equals("application"))
          .collect(Collectors.toList());
  }
}