import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CLITest {
    private CLI cli; // store CLI object
     private Path tempDirectory; // Temporary directory for 

    @Before //before  any test run this
    public void setup()throws IOException { //infroms compiler  and other developers there 
                                            //may be an exception and
                                            //them to deal with it
        cli = new CLI(); //create a CLI object
        // Create a temporary directory for testing
        tempDirectory = Files.createTempDirectory("testDir");
        //change to temp directory for testing
        cli.cd(tempDirectory.toString());
    }
    //pwd test cases initial, changed, invalid these are also test cases for cd()
    @Test
    public void testInitialPwd(){
        String currentDirectory = cli.pwd(); // get current directory from pwd
        //compare current directory to tempdirectory
        assertEquals(tempDirectory.toString(),currentDirectory);
        
    }
    //chosen root as all devices have root 
    @Test
    public void testCd()throws IOException{
        //append newDir to tempDirectory ie C:\temp then now newdir is C:\temp\newDirectory
        Path newDirectory = Files.createDirectory(tempDirectory.resolve("newDirectory"));
        cli.cd(newDirectory.toString());
        String currentDirectory = cli.pwd(); // get current directory from pwd
        assertEquals(newDirectory.toString(),currentDirectory);
    }
    @Test
    public void testInvalidChangecd() {
        cli.cd("invalidDirectory");
        assertEquals( tempDirectory.toString(), cli.pwd());
    }
    @Test
    public void testParentDirectorycd() throws IOException {
        //create a subdirectory for tempdirecotry and store path
        Path subDirectory = Files.createDirectory(tempDirectory.resolve("subDirectory"));
        //change to subdirectory
        cli.cd(subDirectory.toString());
        //change back to parent directory using '..'
        cli.cd("..");
        //assert that it should be tempdirectory now
        assertEquals(tempDirectory.toString(), cli.pwd());
    }
    @Test
    public void midwayParentCd() throws IOException {
        // Create a path from temp to subDir
        Path subDirectory = Files.createDirectory(tempDirectory.resolve("subDir"));
        // Resolve to ".." and back to "subDir" then normalize the path
        Path backToSub = subDirectory.resolve("..").resolve("subDir").normalize();
        // Use the CLI instance to call cd
        cli.cd(backToSub.toString());
        // Assert the current directory is back to subDirectory
        assertEquals(subDirectory.toString(), cli.pwd());
    }
    @Test
    public void testMkdir(){
        //create new path to  directory under temp directory
        String newDirName = tempDirectory.resolve("newDir").toString();
        //make this directory
        cli.mkdir(newDirName);
        //test if directory was created
        File newDir =  new File(newDirName);
        assertTrue(newDir.exists() && newDir.isDirectory());
    }
    @Test
    public void testMkdirExistingDirectory(){
        //create new path to  directory under temp directory
        String newDirName = tempDirectory.resolve("newDir").toString();
        //make this directory
        cli.mkdir(newDirName);
        //make it again
        cli.mkdir(newDirName);
        //directory should still exist
        File newDir =  new File(newDirName);
        assertTrue(newDir.exists() && newDir.isDirectory());
    }
    //test rmdir
    @Test
    public void testRmdir(){
        //create new path to  directory under temp directory
        String newDirName = tempDirectory.resolve("newDir").toString();
        //make this directory
        cli.mkdir(newDirName);
        //remove directory
        cli.rmdir(newDirName);
        //directory should not exist
        File newDir =  new File(newDirName);
        assertFalse(newDir.exists());
    }
    @Test
    public void testRmdirNonEmpty()throws IOException{
        //create a directory with a file in it
        String nonEmptyPath = tempDirectory.resolve("notEmpty").toString();
        cli.mkdir(nonEmptyPath);
        File nonEmptyFile = new File(nonEmptyPath);
        //append a file to this file
        new File(nonEmptyFile, "subFolder").createNewFile();
        //try removing nonEmpty file should still exist
        cli.rmdir(nonEmptyPath);
        assertTrue(nonEmptyFile.exists()&& nonEmptyFile.isDirectory());
    }
    @After
public void cleanup() throws IOException {
    // Delete the temporary directory and its contents
    //temp exists and is not null
    if (tempDirectory != null && Files.exists(tempDirectory)) {
        //traverse directory from temp to all subdirectories
        Files.walk(tempDirectory)
        //create file for each path found
            .map(Path::toFile)
            //delete each file
            .forEach(File::delete);
        Files.delete(tempDirectory);
    }

}
}

