package ar.com.mavha.test.cnfg;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfiguration extends ResourceConfig {

	public JerseyConfiguration() {
		packages("ar.com.mavha.test");
	}

}
