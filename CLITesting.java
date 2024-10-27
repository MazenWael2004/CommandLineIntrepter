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
    @Before

    public void setUp() throws IOException {
        // Create initial test files and directories
        Files.write(Paths.get("testfile.txt"), "Initial Content".getBytes(StandardCharsets.UTF_8));

        // Check if the directory already exists before creating it
        Path folderPath = Paths.get("testfolder");
        if (!Files.exists(folderPath)) {
            Files.createDirectory(folderPath);
        }
    }


//
//    @After
//    public void tearDown() throws IOException {
//        // Clean up after tests
//        Files.deleteIfExists(Paths.get("testfile.txt"));
//        Files.deleteIfExists(Paths.get("renamedfile.txt"));
//        Files.deleteIfExists(Paths.get("testfolder/testfile.txt"));
//        Files.deleteIfExists(Paths.get("output.txt"));
//        Files.deleteIfExists(Paths.get("testfolder"));
//    }

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
    public void lsTest(){
        String testDirectory =  System.getProperty("user.dir");
        File directory = new File(testDirectory);
        String files[] = directory.list();

        assertNotNull("Directory cannot be null", directory);
        CommandLineIntrepter.ls(testDirectory);
        assertEquals(files.length ,directory.list().length);

    }

    @Test
<<<<<<< HEAD
    public void testAppendRedirection() throws IOException {
        // Test appending content to a file
        CLI.redirectOutput("output.txt", "First Line\n");
        CLI.appendOutput("output.txt", "Second Line\n");
        String content = Files.readString(Paths.get("output.txt"), StandardCharsets.UTF_8);
        assertEquals("First Line\nSecond Line\n", content);
=======
    public void lsA(){
        String testDirectory =  System.getProperty("user.dir");
        File directory = new File(testDirectory);
        File files[] = directory.listFiles();
        assertNotNull("Directory cannot be null",directory);
        CommandLineIntrepter.lsA(testDirectory);
        assertEquals(files.length ,directory.listFiles().length);
        

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



>>>>>>> 78678aeebc267bf423720aea1db7d40a057a403b
    }
}



