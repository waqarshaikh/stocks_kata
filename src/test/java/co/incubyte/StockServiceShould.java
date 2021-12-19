package co.incubyte;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StockServiceShould {

  List<Stock> dummyStocks = List.of(
      new Stock("HCC", "Hindustan", 100),
      new Stock("GOOGL", "Google", 100),
      new Stock("APPL", "Apple", 100)
  );
  private StockGateway stockGateway;
  StockService stockService = new StockService(stockGateway);

  @BeforeEach
  void setUp() {
    stockGateway = mock(StockGateway.class);
    when(stockGateway.getStocks()).thenReturn(dummyStocks);
  }

  @Test
  void get_stock_from_httpclient() {
    stockService.getStockByTicker("HCC");
    verify(stockGateway).getStocks();

    List<Stock> stocks = stockGateway.getStocks();
    List<Stock> stockWithTickerHCC = stocks.stream()
        .filter(stock -> stock.getTicker().equals("HCC"))
        .collect(Collectors.toList());

    assertFalse(stockWithTickerHCC.isEmpty());
  }

  @Test
  void get_stocks_from_httpclient_with_price_between_10_and_40() {
    stockService.getStocksWithPriceBetween10And40();

    verify(stockGateway).getStocks();

    List<Stock> stocks = stockGateway.getStocks();
    List<Stock> stockWithPriceBetween10And40 = stocks.stream()
        .filter(stock -> stock.getPrice() < 60 & stock.getPrice() > 101)
        .collect(Collectors.toList());

    assertFalse(stockWithPriceBetween10And40.isEmpty());
  }
}
