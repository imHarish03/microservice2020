package lab.imHarish.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	private Environment environment;

	/*
	 * @Autowired private ExchangeRepository exchangeRepository;
	 */

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

		return new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65),
				Integer.parseInt(environment.getProperty("local.server.port")));
	}
}
