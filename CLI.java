import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

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
  public static void mv(String sourcePath, String destPath) throws IOException {

    Path source = Paths.get(sourcePath);
    Path destination = Paths.get(destPath);
    Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
  }
  public static void rm(String filePath) throws IOException {
    Path file = Paths.get(filePath);
    Files.deleteIfExists(file);
  }

  public static void redirectOutput(String filePath, String content) throws IOException {
    Path file = Paths.get(filePath);
    Files.write(file, content.getBytes(StandardCharsets.UTF_8));
  }

  public static void appendOutput(String filePath, String content) throws IOException {
    Path file = Paths.get(filePath);
    Files.write(file, content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
  }

}
