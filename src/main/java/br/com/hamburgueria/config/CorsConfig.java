package br.com.hamburgueria.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter {

	@Bean
	public FilterRegistrationBean corsFilterRegistrationBean() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration configAutenticacao = new CorsConfiguration();
		configAutenticacao.setAllowCredentials(true);
		configAutenticacao.addAllowedOrigin("*");
		configAutenticacao.addAllowedHeader("*");
		configAutenticacao.addAllowedMethod("POST");
		configAutenticacao.addAllowedMethod("GET");
		configAutenticacao.addAllowedMethod("DELETE");
		configAutenticacao.addAllowedMethod("PUT");
		configAutenticacao.addAllowedMethod("OPTIONS");
		configAutenticacao.setMaxAge(3600L);
		source.registerCorsConfiguration("/oauth/token", configAutenticacao);
		source.registerCorsConfiguration("/**", configAutenticacao); // Global
																		// for
																		// all
																		// paths

		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**");
	}
}
