package ar.com.mavha.test.cnfg;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.StringVendorExtension;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collection;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select().apis(RequestHandlerSelectors.basePackage("ar.com.mavha.test.endpoint"))
				.paths(PathSelectors.any())
				.build()
				.enable(true)
				.apiInfo(apiInfo());
	}

	public ApiInfo apiInfo() {
		StringVendorExtension vendorExtension = new StringVendorExtension("", "");
		Collection<VendorExtension> vendorExtensions = new ArrayList<>();
		vendorExtensions.add(vendorExtension);
		Contact contactInfo = new Contact("Sebastian Emanuel Bogado", "soyseeb.nsuconsulting.com", "seebogado@gmail.com");
		return new ApiInfo(
				"Mavha test",
				"Test with spring boot, jax-rs swagger, docker and travis.",
				"1.0",
				"Its only for a test",
				contactInfo,
				"Apache 2.0",
				"www.apache.org",
				vendorExtensions);
	}
}
