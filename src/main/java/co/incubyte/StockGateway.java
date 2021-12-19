package co.incubyte;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.List;

@Singleton
public class StockGateway {

  @Inject
  @Client("https://61bdb57a2a1dd4001708a0f3.mockapi.io")
  HttpClient httpClient;

  public List<Stock> getStocks() {
    return httpClient.toBlocking()
        .retrieve(HttpRequest.GET("/api/v1/stocks"), Argument.listOf(Stock.class));
  }
}
