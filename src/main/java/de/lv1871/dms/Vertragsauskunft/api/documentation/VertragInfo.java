package de.lv1871.dms.Vertragsauskunft.api.documentation;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Arrays;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class VertragInfo {

	private static final String APIKEY_HEADER_NAME = ApiKeyHeadername.DEFAULTHEADERNAME.getHeadername();

	private static final String API_TITLE = "Vertrag";
	private static final String API_NAME = "vertrag-api";
	private static final String API_DESCRIPTION = "Über dieses API lassen sich die Metainformationen eines Vertrags abrufen";

	private static ApiInfo vertragApiInfo() {
		return new ApiInfoBuilder().title(API_TITLE).description(API_DESCRIPTION).build();
	}

	public static Docket createApiInfo() {
		return new Docket(DocumentationType.SWAGGER_2).groupName(API_NAME).useDefaultResponseMessages(false)
				.securitySchemes(Arrays.asList(new SecurityScheme[] { apiKey() })).apiInfo(vertragApiInfo()).select()
				.paths(vertragAPIPath()).build();
	}

	private static Predicate<String> vertragAPIPath() {
		return regex("/api/vertrag.*");
	}

	private static ApiKey apiKey() {
		return new ApiKey(APIKEY_HEADER_NAME, APIKEY_HEADER_NAME, "header");
	}

}
