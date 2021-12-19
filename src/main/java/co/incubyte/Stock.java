package co.incubyte;

public class Stock {

  private double price;
  private String ticker;
  private String name;

  public Stock() {
  }

  public Stock(String ticker, String name, double price) {
    this.ticker = ticker;
    this.name = name;
    this.price = price;
  }
  public String getTicker() {
    return ticker;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }


}
