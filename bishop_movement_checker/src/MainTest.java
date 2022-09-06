import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

  @Test
  public void sampleTests() {
    Assertions.assertEquals(true,Main.bishop("a1","b4",2));
    Assertions.assertEquals(false,Main.bishop("a1","b5",5));
    Assertions.assertEquals(true,Main.bishop("f1","f1",0));
    Assertions.assertEquals(false,Main.bishop("e6","a1",2));
  }
}