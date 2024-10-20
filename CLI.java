import java.io.File;

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
}
