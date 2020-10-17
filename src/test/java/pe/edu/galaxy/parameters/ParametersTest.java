package pe.edu.galaxy.parameters;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTest {

    @Parameters({ "suite-param" })
    @Test
    public void ParametersTestOne(String param) {
        System.out.println("Test one suite param is: " + param);
    }
 
  
    @Parameters({ "test-two-param" })
    @Test
    public void ParametersTestTwo(String param) {
        System.out.println("Test two param is: " + param);
    }
 
  
    @Parameters({ "suite-param", "test-three-param" })
    @Test
    public void ParametersTestThree(String param, String paramTwo) {
        System.out.println("Test three suite param is: " + param);
        System.out.println("Test three param is: " + paramTwo);
    }
}
