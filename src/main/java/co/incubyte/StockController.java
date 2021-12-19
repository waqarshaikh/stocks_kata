package co.incubyte;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import java.util.List;

@Controller("/stocks")
public class StockController {

  private StockService stockService;

  public StockController(StockService stockService) {
    this.stockService = stockService;
  }

  @Get("/{ticker}")
  public Stock getStockByTicker(String ticker) {
     return stockService.getStockByTicker(ticker);
  }

  @Get
  public List<Stock> getStockWithPriceBetween10And40(@QueryValue double lt, @QueryValue double gt) {
    return stockService.getStocksWithPriceBetween10And40();

  }
}

