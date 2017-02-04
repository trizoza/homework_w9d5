import static org.junit.Assert.*;
import org.junit.*;

public class CustomerTest {

  Customer regularCustomer;
  Customer loyalCustomer;

  @Before
  public void before() {
    this.regularCustomer = new Customer(false);
    this.loyalCustomer = new Customer(true);
  }

  @Test
  public void canGetLoyaltyFalse() {
    assertEquals(false, regularCustomer.getLoyalty());
  }

  @Test
  public void canGetLoyaltyTrue() {
    assertEquals(true, loyalCustomer.getLoyalty());
  }

}