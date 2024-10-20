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
}
