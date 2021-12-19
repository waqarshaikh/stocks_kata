package co.incubyte;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@MicronautTest
public class StocksIntegrationTest {

  @Inject
  @Client("/stocks")
  HttpClient httpClient;

  @Test
  void returns_list_of_stocks() {
    Stock stock
        = httpClient.toBlocking()
        .retrieve(HttpRequest.GET("HCC"), Argument.of(Stock.class));
    assertThat(stock.getName()).isEqualTo("Hindustan Construction Company Limited");
    assertThat(stock.getPrice()).isEqualTo(65);
    assertThat(stock.getTicker()).isEqualTo("HCC");
  }

  @Test
  void returns_list_of_stocks_with_price_between_10_and_40() {
    List<Stock> stocks
        = httpClient.toBlocking()
        .retrieve(HttpRequest.GET("?lt=60&gt=101"), Argument.listOf(Stock.class));
    for (Stock stock : stocks) {
      System.out.println(stock.getPrice());
      assertThat(stock.getPrice() < 101 & stock.getPrice() > 60).isTrue();
    }

  }
}
