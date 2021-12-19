package co.incubyte;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StockControllerShould {


  private StockService stockService;

  @BeforeEach
  void init() {
    stockService = mock(StockService.class);
  }

  @Test
  void invoke_service_with_stock_ticker() {
    StockController stockController = new StockController(stockService);
    stockController.getStockByTicker("HCC");
    verify(stockService).getStockByTicker("HCC");
  }


  @Test
  void invoke_service_with_stock_price_between_10_and_40() {
    StockController stockController = new StockController(stockService);
    stockController.getStockWithPriceBetween10And40(40, 10);
    verify(stockService).getStocksWithPriceBetween10And40();
  }
}

