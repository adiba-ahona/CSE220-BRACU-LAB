import java.util.Scanner;
import java.util.Stack;
public class BracketTester{
  public static void main(String[] args){
    Scanner go = new Scanner(System.in);
    String dhk = go.nextLine();
    Stack stack = new Stack();
    char[] a = dhk.toCharArray();
    boolean check = true;
    for (int i=0; i<=a.length; i++){
      try{
        if(a[i] == '[' || a[i] == '{' || a[i] == '(' ){
          stack.push(a[i]);
        }
        if(a[i]== ']'){
          if(stack.peek()!=(Object)'['){
            check = false;
            System.out.println(a[i] + " character not opened");
            break;
          }
          else{
            stack.pop();
          }
        }
        if(a[i]== ')'){
          if(stack.peek()!=(Object)'('){
            check = false;
            System.out.println(a[i] + " character not opened");
            break;
          }
          else{
            stack.pop();
          }
        }
        if(a[i]== '}'){
          if(stack.peek()!=(Object)'{'){
            check = false;
            System.out.println(a[i] + " character not opened");
            break;
          }
          else{
            stack.pop();
          }
        }
      }
      catch(Exception e){
        System.out.println(e);
      }
    }
    if(stack.isEmpty()){
      if(check){
        System.out.println("Right Expression");
      }
    }
      else{
        System.out.println("Wrong Expression"); 
      }
    }
  }