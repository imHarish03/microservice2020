package lab.imHarish.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		// Setting Query params
		Map<String, String> variables = new HashMap<>();
		variables.put("from", from);
		variables.put("to", to);

		// invoking another micro-service using rest template
		ResponseEntity<CurrencyConversionBean> data = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, variables);
		CurrencyConversionBean response = data.getBody();

		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
				quantity.multiply(response.getConversionMultiple()), response.getPort());
	}

	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		CurrencyConversionBean response = currencyExchangeProxy.retrieveExchangeValue(from, to);

		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
				quantity.multiply(response.getConversionMultiple()), response.getPort());
	}

	@GetMapping("/auth/from/{from}/to/{to}/quantity/{quantity}")
	@Retry(name = "currency", fallbackMethod = "fallback")
	public String auth(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

		System.out.println("Currency API invoking");
		CurrencyConversionBean response = currencyExchangeProxy.authValue("Harisdhabdh");

		return "Welcome";
	}

	public String fallback(String input, Exception ex) {
		return "fallback response";
	}

}
