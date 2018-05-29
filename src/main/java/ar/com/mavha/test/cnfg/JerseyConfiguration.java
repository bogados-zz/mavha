package ar.com.mavha.test.cnfg;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfiguration extends ResourceConfig {

	public JerseyConfiguration() {
		packages("ar.com.mavha.test");
		/*
		BeanConfig swaggerConfig = new BeanConfig();
		swaggerConfig.setBasePath("/");
		SwaggerConfigLocator.getInstance().putConfig(SwaggerContextService.CONFIG_ID_DEFAULT, swaggerConfig);
		packages(getClass().getPackage().getName(),	ApiListingResource.class.getPackage().getName());
		*/
	}

}
