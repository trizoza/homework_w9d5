import static org.junit.Assert.*;
import org.junit.*;

public class BasketTest {

  Basket basket;
  Item item1;
  Item item2;
  Item item3;
  Item item4;
  Item item5;
  Customer regularCustomer;
  Customer loyalCustomer;

  @Before
  public void before() {
    this.basket = new Basket();
    this.item1 = new Item(9.99);
    this.item2 = new Item(19.99);
    this.item3 = new Item(19.99);
    this.item4 = new Item(9.99);
    this.item5 = new Item(9.99);
    this.regularCustomer = new Customer(false);
    this.loyalCustomer = new Customer(true);
  }

  @Test
  public void canGetBasketLenght() {
    assertEquals(0, basket.howManyItems());
  }

  @Test
  public void canAddItem() {
    basket.addItem(item1);
    assertEquals(1, basket.howManyItems());
    assertEquals(9.99, basket.getValue(), 0.01);
  }

  @Test
  public void canAddCustomer() {
    basket.addCustomer(regularCustomer);
    assertEquals(false, basket.getCustomer().getLoyalty());
  }

  @Test
  public void canBuyOneGetOneWithTwo() {
    basket.addItem(item1);
    basket.addItem(item2);
    assertEquals(2, basket.howManyItems());
    assertEquals(19.99, basket.getValue(), 0.01);
  }

  @Test
  public void canBuyOneGetOneWithThree() {
    basket.addItem(item1);
    basket.addItem(item2);
    basket.addItem(item3);
    assertEquals(3, basket.howManyItems());
    assertEquals(35.98, basket.getValue(), 0.01);
  }

  @Test
  public void canBuyOneGetOneWithFour() {
    basket.addItem(item1);
    basket.addItem(item2);
    basket.addItem(item3);
    basket.addItem(item4);
    assertEquals(4, basket.howManyItems());
    assertEquals(35.98, basket.getValue(), 0.01);
  }

  @Test
  public void canBuyOneGetOneWithFive() {
    basket.addItem(item1);
    basket.addItem(item2);
    basket.addItem(item3);
    basket.addItem(item4);
    basket.addItem(item5);
    assertEquals(5, basket.howManyItems());
    assertEquals(44.97, basket.getValue(), 0.01);
  }

  @Test
  public void canSellToRegularCustomer() {
    basket.addCustomer(regularCustomer);
    basket.addItem(item1);
    basket.addItem(item2);
    basket.addItem(item3);
    basket.addItem(item4);
    basket.addItem(item5);
    assertEquals(5, basket.howManyItems());
    assertEquals(44.97, basket.getValue(), 0.01);
  }

  @Test
  public void canGetLoyaltyDiscount() {
    basket.addCustomer(loyalCustomer);
    basket.addItem(item1);
    basket.addItem(item2);
    basket.addItem(item3);
    basket.addItem(item4);
    basket.addItem(item5);
    assertEquals(5, basket.howManyItems());
    assertEquals(44.07, basket.getValue(), 0.01);
  }

  @Test
  public void canRemoveItem() {
    basket.addItem(item1);
    basket.addItem(item2);
    basket.addItem(item3);
    basket.addItem(item4);
    basket.removeItem(item4);
    assertEquals(3, basket.howManyItems());
    assertEquals(35.98, basket.getValue(), 0.01);
  }

  @Test
  public void canRemoveMoreItems() {
    basket.addItem(item1);
    basket.addItem(item2);
    basket.addItem(item3);
    basket.addItem(item4);
    basket.removeItem(item4);
    basket.removeItem(item3);
    basket.removeItem(item2);
    assertEquals(1, basket.howManyItems());
    assertEquals(9.99, basket.getValue(), 0.01);
  }

  @Test
  public void canRemoveAllItems() {
    basket.addItem(item1);
    basket.addItem(item2);
    basket.addItem(item3);
    basket.addItem(item4);
    basket.removeItem(item4);
    basket.removeItem(item3);
    basket.removeItem(item2);
    basket.removeItem(item1);
    assertEquals(0, basket.howManyItems());
    assertEquals(0, basket.getValue(), 0.01);
  }

  @Test
  public void canRemoveAllItemsWithCustomer() {
    basket.addCustomer(loyalCustomer);
    basket.addItem(item1);
    basket.addItem(item2);
    basket.addItem(item3);
    basket.addItem(item4);
    basket.removeItem(item4);
    basket.removeItem(item3);
    basket.removeItem(item2);
    basket.removeItem(item1);
    assertEquals(0, basket.howManyItems());
    assertEquals(0, basket.getValue(), 0.01);
  }

  @Test
  public void canRemoveAllItemsAtOnce() {
    basket.addItem(item1);
    basket.addItem(item2);
    basket.addItem(item3);
    basket.addItem(item4);
    basket.removeAllItems();
    assertEquals(0, basket.howManyItems());
    assertEquals(0, basket.getValue(), 0.01);
  }

  @Test
  public void canRemoveAllItemsAtOnceWithCustomer() {
    basket.addCustomer(regularCustomer);
    basket.addItem(item1);
    basket.addItem(item2);
    basket.addItem(item3);
    basket.addItem(item4);
    basket.removeAllItems();
    assertEquals(0, basket.howManyItems());
    assertEquals(0, basket.getValue(), 0.01);
  }



}