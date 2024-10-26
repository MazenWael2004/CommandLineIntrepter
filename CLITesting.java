import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import java.io.File;

import org.junit.*;
public class CLITesting {
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



    }
}
