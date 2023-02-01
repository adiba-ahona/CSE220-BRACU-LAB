import java.io.*;
import java.util.*;
public class Test{
  public static void main(String [] args) throws Exception{
  File file = new File("C:\\Users\\19101257\\Desktop\\Hello.txt");
  Scanner sc= new Scanner(file);
  while (sc.hasNextLine()){
  String st= sc.nextLine();
  System.out.println(st);
  }
  }
}