public class Item {

  private double price;

  public Item(double price) {
    this.price = price;
  }

  public double getPrice() {
    return price;
  }

  public double discountPrice(double discount) {
    price = price * discount;
    return price;
  }

}