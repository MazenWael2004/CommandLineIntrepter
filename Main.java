//import java.util.Scanner;
//import java.io.*;
//
//public class Main {
//    public static void main(String[] args) {
//
//        System.out.println("  Welcome to our CLI ");
//        Scanner scanner = new Scanner(System.in);
//        Scanner scanner2 = new Scanner(System.in);
//        boolean flag = true;
//        String currentdirectory = System.getProperty("user.dir");
//
//        CLI cli = new CLI();
//
//        while(flag){
//        System.out.print(currentdirectory+" Enter a command: ");
//        String command = scanner.nextLine();
//
//        System.out.println("You entered: " + command);
//        if(command.toLowerCase().equals("ls")){
//            cli.ls(currentdirectory);
//        }
//        else if(command.toLowerCase().equals("ls -a")){
//            cli.lsA(currentdirectory);
//        }
//        else if(command.toLowerCase().equals("ls -r")){
//            cli.lsR(currentdirectory);
//        }
//
//        else if(command.toLowerCase().equals("cat")){
//            String filename = scanner.nextLine();
//            cli.cat(filename);
//
//        }
//
//        else if(command.toLowerCase().equals("exit") ){
//            flag = false;
//        }
//
//
//    }
//    System.out.println("Thank you!");
//    scanner.close();
//    scanner2.close();
//}
//
//}
