package lab.imHarish.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lab.imHarish.microservices.limitsservice.bean.LimitConfiguration;

@RestController
public class LimitsConfigurationController {

	@Autowired
	private Configuration config;

	@GetMapping("/limits")
	public LimitConfiguration retrieveConfiguration() {
		return new LimitConfiguration(config.getMinimum(), config.getMaximum());

	}

}
