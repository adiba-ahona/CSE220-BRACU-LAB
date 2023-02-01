public class CircularArrayException extends Exception{
  String m;
  public CircularArrayException(String n)
  {
    m=n; 
  }
  public String toString(){
  return m;
  }
}
