import static org.junit.Assert.*;
import org.junit.*;

public class ItemTest {

  Item item;

  @Before
  public void before() {
    this.item = new Item(9.99);
  }

  @Test
  public void canGetPrice() {
    assertEquals(9.99, item.getPrice(), 0.01);
  }

  @Test
  public void canGetDiscount() {
    item.discountPrice(0.5);
    assertEquals(4.995, item.getPrice(), 0.01);
  }

}