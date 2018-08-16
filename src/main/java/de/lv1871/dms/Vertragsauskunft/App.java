package de.lv1871.dms.Vertragsauskunft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import de.lv1871.dms.Vertragsauskunft.api.documentation.VertragInfo;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan({ "de.lv1871.dms" })
@CrossOrigin
@EnableSwagger2
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public Docket vertragApi() {
		return VertragInfo.createApiInfo();
	}

	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
		builder.dateFormat(new ISO8601DateFormat());
		return builder;
	}
}
