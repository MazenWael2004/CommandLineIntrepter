import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;



import java.io.File;

public class CLITesting {


    CLI cli = new CLI();

    @Test
    public void mvTestRename() throws IOException{
        Path source = Paths.get("test.txt");
        Path destination = Paths.get("testRename.txt");
        Files.createFile(source);
        cli.mv(source,destination);
        assertTrue(Files.exists(destination));//ensure that renamed file exist
        assertFalse(Files.exists(source));//ensure that old named file not exist after renaming


    }
    @Test
    public void mvTestMove() throws IOException{
        Path source = Paths.get("test.txt");
        Path destination = Paths.get("testMove.txt");
        Files.createFile(source);
        cli.mv(source,destination);
        assertTrue(Files.exists(destination));
        assertFalse(Files.exists(source));


    }

    @Test
    public void rmTest(){
        Path testRemove = Paths.get("test.txt");
        cli.rm(testRemove);
        assertFalse(Files.exists(testRemove));//ensure that the removed file is not exist anymore

    }

    @Test
    public void outputRedirectTest() throws IOException{
        Path file = Paths.get("test.txt");




        cli.outputRedirect(file,"test hello");
        String content =Files.readString(file);
        assertEquals("test hello",content);





    }
    @Test
    public void appendRedirectTest() throws IOException{
        Path file = Paths.get("test.txt");




        cli.outputRedirect(file,"test hello\n");
        cli.appendRedirect(file,"test append");
        String content =Files.readString(file);
        assertEquals("test hello\ntest append",content);

    }

//    // List items testing...
//
//    @Test
//    public void lsTest(){
//        String testDirectory =  System.getProperty("user.dir");
//        File directory = new File(testDirectory);
//        String files[] = directory.list();
//
//        assertNotNull("Directory cannot be null", directory);
//        CLI.ls(testDirectory);
//        assertEquals(files.length ,directory.list().length);
//
//    }

//
//
//
//
//
//    @Test
//    public void lsR(){
//        String testDirectory =  System.getProperty("user.dir");
//        File directory = new File(testDirectory);
//        File files[] = directory.listFiles();
//        assertNotNull("Directory cannot be null",directory);
//        CommandLineIntrepter.lsR(testDirectory);
//        assertEquals(files.length ,directory.listFiles().length);
//
//    }
//
//    @Test
//
//    public void cat(){
//        String fileName = "example.txt";
//        String out = CommandLineIntrepter.cat(fileName);
//        String expectedout = "This is a prototype.";
//
//        assertEquals(out,expectedout);
//        assertNotNull(out);
//
//
//
//
//    }
//}
//
//
//
}
=======

    @Test
    public void testMoveAndRenameFile() throws IOException {
        // Test renaming a file
        CLI.mv("testfile.txt", "renamedfile.txt");
        assertFalse(Files.exists(Paths.get("testfile.txt")));
        assertTrue(Files.exists(Paths.get("renamedfile.txt")));
    }

    @Test
    public void testMoveFileToDirectory() throws IOException {
        // Test moving a file to a directory
        CLI.mv("testfile.txt", "testfolder/testfile.txt");
        assertFalse(Files.exists(Paths.get("testfile.txt")));
        assertTrue(Files.exists(Paths.get("testfolder/testfile.txt")));
    }

    @Test
    public void testRemoveFile() throws IOException {
        // Test removing a file
        CLI.rm("testfile.txt");
        assertFalse(Files.exists(Paths.get("testfile.txt")));
    }

    @Test
    public void testOutputRedirectionOverwrite() throws IOException {
        // Test output redirection (overwrite)
        CLI.redirectOutput("output.txt", "New Content\n");
        String content = Files.readString(Paths.get("output.txt"), StandardCharsets.UTF_8);
        assertEquals("New Content\n", content);
    }
    CLI CommandLineIntrepter = new CLI();
    // List items testing...
    
    @Test
    public void ls(){
        String testDirectory =  System.getProperty("user.dir");
        File directory = new File(testDirectory);
        String files[] = directory.list();

        assertNotNull("Directory cannot be null", directory);
        CommandLineIntrepter.ls(testDirectory);
        assertEquals(files.length ,directory.list().length);

    }

    @Test
    public void testAppendRedirection() throws IOException {
        // Test appending content to a file
        CLI.redirectOutput("output.txt", "First Line\n");
        CLI.appendOutput("output.txt", "Second Line\n");
        String content = Files.readString(Paths.get("output.txt"), StandardCharsets.UTF_8);
        assertEquals("First Line\nSecond Line\n", content);
    }
     @Test
      public void lsA(){
        String testDirectory =  System.getProperty("user.dir");
        File directory = new File(testDirectory);
        File files[] = directory.listFiles();
        assertNotNull("Directory cannot be null",directory);
        CommandLineIntrepter.lsA(testDirectory);
        assertEquals(files.length ,directory.listFiles().length);
        

    }

    @Test
    public void lsTest(){
        String testDirectory =  System.getProperty("user.dir");
        File directory = new File(testDirectory);
        String files[] = directory.list();

        assertNotNull("Directory cannot be null", directory);
        CommandLineIntrepter.ls(testDirectory);
        assertEquals(files.length ,directory.list().length);

    }

    @Test
    public void lsR(){
        String testDirectory =  System.getProperty("user.dir");
        File directory = new File(testDirectory);
        File files[] = directory.listFiles();
        assertNotNull("Directory cannot be null",directory);
        CommandLineIntrepter.lsR(testDirectory);
        assertEquals(files.length ,directory.listFiles().length);

    }

    @Test

    public void cat(){
        String fileName = "example.txt";
        String out = CommandLineIntrepter.cat(fileName);
        String expectedout = "This is a prototype.";

        assertEquals(out,expectedout);
        assertNotNull(out);



    }
}








>>>>>>> 47efd64b8c01909d856f55c3c9544b4062546b2b
