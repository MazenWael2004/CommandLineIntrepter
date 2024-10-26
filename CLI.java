import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CLI {
    //list files command:

    public void ls(String directoryName){
      File currentfile = new File(directoryName);
      if(!currentfile.isDirectory()){
        throw new IllegalArgumentException(directoryName+"is not a valid path.");
      }
      
      String files[] = currentfile.list(); // make sure it's not null in testing...
      System.out.println("Files : ");

      for(int i =0; i<files.length; i++){
        System.out.println(files[i]);
      }

    }

    public void lsA(String directoryName){
      File currentfile = new File(directoryName);
      if(!currentfile.isDirectory()){
        throw new IllegalArgumentException(directoryName+"is not a valid path.");
      }
      
      File files[] = currentfile.listFiles(); // mk an array of object files
      System.out.println("Files(including hidden) : ");

      for(int i =0; i<files.length; i++){
        System.out.println(files[i] + (files[i].isHidden() ? " (hidden)" : ""));
      }

    }

    public void lsR(String directoryName){
       File currentFile = new File(directoryName);

       if(!currentFile.isDirectory()){
        throw new IllegalArgumentException(directoryName+"is not a valid path.");
       }
       File files[] = currentFile.listFiles();

       if(files == null){
        return;
       }

       System.out.println(" Files in the directory: "+directoryName);

       for(int i =0; i<files.length; i++){
        System.out.println(files[i] + (files[i].isHidden() ? " (hidden)" : ""));

        if(files[i].isDirectory()){
          lsR(files[i].getPath());
        }
       }
    }

   public String cat(String fileName){
    String Output = "";
    File file = new File(fileName);
    if(!file.exists() | file.isDirectory()){
      System.out.println(fileName + "is not a valid file");
    }

    try(Scanner scanner = new Scanner(file)){
      while(scanner.hasNextLine()){
        String line = scanner.nextLine(); 
        Output +=line;
        System.out.println(line);
      }
    } catch(Exception e){
      System.err.println("An error occurred while reading the file: " + e.getMessage());
    }
    return Output;
   }

  

}
