package co.incubyte;

import jakarta.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class StockService {

  StockGateway stockGateway;

  public StockService(StockGateway stockGateway) {
    this.stockGateway = stockGateway;
  }

  public Stock getStockByTicker(String ticker) {
    List<Stock> stocks = stockGateway.getStocks();
    List<Stock> filteredStock = stocks.stream()
        .filter(stock -> stock.getTicker().equals(ticker))
        .collect(Collectors.toList());
    return filteredStock.get(0);
  }

  public List<Stock> getStocksWithPriceBetween10And40() {
    List<Stock> filteredStocks = stockGateway.getStocks().stream()
        .filter(stock -> stock.getPrice() < 101 & stock.getPrice() > 60)
        .collect(Collectors.toList());
    return filteredStocks;
  }
}
