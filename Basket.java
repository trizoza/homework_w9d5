import java.util.*;
import java.util.concurrent.*;

public class Basket {

  CopyOnWriteArrayList<Item> cart;
  ArrayList<Customer> customers;
  double value;

  public Basket() {
    this.cart = new CopyOnWriteArrayList<Item>();
    this.customers = new ArrayList<Customer>();
    this.value = 0;
  }

  public double getValue() {
    return value;
  }

  public int howManyItems() {
    return cart.size();
  }

  public void addItem(Item item) {
    cart.add(item);
    setValue();
  }

  public void removeItem(Item item) {
    for (Item everyItem : cart) {
      if (everyItem == item) {
        cart.remove(item);
        setValue();
      }
    }
  }

  public void removeAllItems() {
    for (Item everyItem : cart) {
      cart.remove(0);
      setValue();
    }
  }

  public void addCustomer(Customer customer) {
    if (customers.size() > 0) {
      for (Customer everyCustomer : customers) {
        customers.remove(0);
      }
    }
    customers.add(customer);
  }

  public Customer getCustomer() {
    return customers.get(0);
  }

  public void setValue() {
    value = 0;
    ////////// BUY ONE GET ONE //////////////////////////////////
    buyOneGetOne();
    /////////// 10 % OFF /////////////////////////////////////////
    tenPercentOff();
    //////////// LOYALTY DISCOUNT ////////////////////////////////
    loyaltyDiscount();
  }

  public void buyOneGetOne() {
    if (cart.size() == 0) {
      value = 0;
    }
    else if (cart.size() == 1) {
      sortByPrice();
      value += cart.get(0).getPrice();
    }
    else if (cart.size() > 1 && cart.size() % 2 == 0) {
      sortByPrice();
      for (int i = cart.size()/2; i < cart.size(); i++ ) {
        value +=  cart.get(i).getPrice();
      }
    }
    else {
      sortByPrice();
      for (int i = (cart.size()-1)/2; i < cart.size(); i++ ) {
        value +=  cart.get(i).getPrice();
      }
    }
  }

  public void tenPercentOff() {
    if (value >= 20) {
      value *= 0.9;
    }
  }

  public void loyaltyDiscount() {
    if (customers.size() != 0 && cart.size() > 0 && customers.get(0).getLoyalty() == true) {
      value *= 0.98;
    }
  }

  public void sortByPrice() {
  Collections.sort(cart, new Comparator<Item>() {
      @Override
      public int compare(Item item1, Item item2) {
        return Double.compare(item1.getPrice(), item2.getPrice());
      }
    });
  }

}