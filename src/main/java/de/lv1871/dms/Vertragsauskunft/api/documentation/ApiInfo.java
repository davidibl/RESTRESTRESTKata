package de.lv1871.dms.Vertragsauskunft.api.documentation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;

@Configuration
public class ApiInfo {

	private static final String APIKEY_HEADER_NAME = ApiKeyHeadername.DEFAULTHEADERNAME.getHeadername();

	@Bean
	SecurityConfiguration security() {
		return new SecurityConfiguration(null, null, null, null, APIKEY_HEADER_NAME, ApiKeyVehicle.HEADER,
				APIKEY_HEADER_NAME, ",");
	}

}
