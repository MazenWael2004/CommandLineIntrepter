import java.io.File;

public class CLI {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        // sytnax is className object name = new constructor();
        CLI cli = new CLI();
        //check number of arguments greater than 0
        if(args.length > 0){
            //first argument is command
            String command = args[0];
            switch(command){
                case "pwd":
                cli.pwd();
                break;
                case "cd":
                //command and parameter
                if(args.length == 2 ){
                    cli.cd(args[1]);
                }
                else{
                    System.err.println("Usage: cd <directory>");
                }
                break;
                case "mkdir":
                if(args.length == 2){
                    cli.mkdir(args[1]);
                }
                else{
                    System.err.println("Usage: mkdir <directory>");
                }
                break;
                case "rmdir":
                if(args.length == 2){
                    cli.rmdir(args[1]);
                break;
                
            }

        }

        cli.pwd();
        System.out.print("current direcotry: ");
        cli.pwd();
        System.out.println();
        cli.cd("C:\\Users\\amrel\\OneDrive\\Documents\\Birth of a bee");
        System.out.print("new direcotry: ");
        cli.pwd();
        System.out.println();
        cli.cd("\\Mind");
        System.out.print("newest direcotry: ");
        cli.pwd();
        System.out.println();
    }

    }
    //constructor
    public CLI(){
        //must be initialized when opening CLI
        currentDirectory = System.getProperty("user.dir");
    }
    //must be stored in CLI class
    private String currentDirectory;
    //Prints the working directory
    public String pwd(){
        return currentDirectory;  //changed from print to return for testability
    }

    //Changes the current directory
    //note to whoever is making main java \ is a break character
    //so input  "\\" is '\' so need to normalize \ input into \\ for
    //cd to work  
    // public void cd(String newDirectory){
    //     // create a file of current directory for navigation 
    //     File currentNavDirectory = new File(currentDirectory);
    //     // if in formate a-Z: or a-Z:\ or /  then absolute directory
    //     if ( newDirectory.matches("^[a-zA-Z]:\\\\?$")||newDirectory.matches("^[a-zA-Z]:\\\\.*") || newDirectory.matches("^/.*")) {

    //         currentNavDirectory = new File(newDirectory);
    //         if(currentNavDirectory.exists() && currentNavDirectory.isDirectory()){
    //             currentDirectory = newDirectory;
    //         }
    //         else{
    //             System.err.println("this directory does not exist " + currentNavDirectory.getPath() );
    //         }
    //         return;
    //     }
    //     //relative directory has 3 cases, within current file or parent file or within parent file
    //     else{

    //         //breakdown newDirectory into parts based on / and \  java needs \\ as 
    //         // \ is an escape character and since in regex'regular expression' needs another
    //         // \\ at end so \\\\
    //         //store each path component seperately within array
    //         String [] pathComponents = newDirectory.split("[/\\\\]");
    //         for(String component :pathComponents){
    //             //navigate back to parent directory
    //             if(component.equals("..")){
    //                 //check if there is parent file ie not root file
    //                 if(currentNavDirectory.getParentFile() != null){
    //                     //updates navigationDirectory
    //                     currentNavDirectory = currentNavDirectory.getParentFile();
    //                 }
    //                 // does nothing if already at root but continues loop
    //             }
    //             else{
    //                 //add component to currentNavDirectory
    //                 File checkDirectory = new File(currentNavDirectory , component);
    //                 //check if new nav directory exists and is a directory(file) and not a program or something
    //                 if(checkDirectory.exists() && checkDirectory.isDirectory()){
    //                     currentNavDirectory = checkDirectory;
    //                 }
    //                 else{
    //                     System.err.println("this directory does not exist " + checkDirectory.getPath() );
    //                 }
    //             }
    //         }
    //         currentDirectory = currentNavDirectory.getPath();
    //         System.out.println("at new directory: " + currentDirectory);
    //         return;  
    //     }
    // }
    //cd again simple
    public void cd(String path){
        File newDir;
        String absolutePath ;
        //check if path is absolute if so the newDir is file to this path
        if(new File(path).isAbsolute()){
            newDir = new File(path);
           
        }
        //check if path simply wants parent folder
        else if("..".equals(path)){
            newDir = new  File(currentDirectory).getParentFile().getAbsoluteFile();
        }
        //if neither then a relative path so append to currentDirectory 
        else{
            newDir =  new File(currentDirectory, path).getAbsoluteFile();
        }
        absolutePath = newDir.getAbsolutePath();
        if(newDir.exists()&&newDir.isDirectory()){
            currentDirectory = absolutePath;
        }
        else
        {
            System.err.println("this directory does not exist: " + absolutePath);
        }

    }

    //takes absolute or relative path and creates directory there
    public void mkdir(String path){
        //create logical file at path
       File newDirectory = new File(path);
       //normalize path to absolute path
       String newDirectoryPath = newDirectory.getAbsolutePath();
       
       if(newDirectory.mkdirs()){//create physical file and all parent files needed
        System.out.println("new Directory created at: "+ newDirectoryPath);
       }
       else if(newDirectory.exists()){
        //alerts directory already exits
        System.err.println("Failed to create directory as it already exists at: " + newDirectoryPath);
       }
       else{
        //normal error alert
        System.err.println("Failed to create directory at: " + newDirectoryPath);
       }     
    }
    //Removes each given directory only if it is empty
    public void rmdir(String path){
        File dirToRemove = new File(path);
        String dirToRemovePath = dirToRemove.getAbsolutePath();
        //check if directory exists 
        if(dirToRemove.exists()){
            //check if directory  and that it is empty
            if(dirToRemove.isDirectory() && dirToRemove.list().length == 0){
                //remove and check that it was removed
                if(dirToRemove.delete()){
                    System.out.println("Directory removed: " + dirToRemovePath);
                }
                else{
                    System.err.println("Failed to remove:"+ dirToRemovePath);
                }
            }
            else{
                if(dirToRemove.isDirectory()){
                    System.err.println("Directory: "+dirToRemovePath+ " is not empty");
                }
                else{
                    System.err.println("Not a Directory: " + dirToRemovePath);
                }
            }
        }
        else{
            System.err.println("Directory does not exist:" + dirToRemovePath);
        }
    }
}
