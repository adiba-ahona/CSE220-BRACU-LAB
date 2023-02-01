import java.lang.reflect.Method;

public class JI9040211 {
 public static void main(String[] args) throws Exception { 
  final JI9040211 self = new JI9040211(); 
  // This count is used to decide when to pass an invalid number of arguments to the method during the reflection call. 
  // This should be sufficiently high to reproduce the NPE, since the JRE generates the dynamic (internal) method invoker 
  // after the method has been invoked a good number of times. 
  final int warmupCount = 500; 
  for (int i = 0; i < 1000; i++) { 
   final Method method = self.getClass().getMethod("doSomething", String.class); 
   if (i > warmupCount) { 
    // intentionally pass wrong argument 
    method.invoke(self, null); 
   } else { 
    method.invoke(self, "test-" + i); 
   } 
  } 
 }
  public void doSomething(final String foo) { 
   System.out.println(foo); 
  } 
 }