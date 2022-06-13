package com.junioroffers.config;

import com.junioroffers.infrastructure.RemoteOfferClient;
import com.junioroffers.infrastructure.offer.client.OfferHttpClient;
import com.junioroffers.infrastructure.offer.error.RestTemplateResponseErrorHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class Config {

    @Bean
    RestTemplateResponseErrorHandler restTemplateResponseErrorHandler() {
        return new RestTemplateResponseErrorHandler();
    }

    @Bean
    RestTemplate restTemplate(@Value("${offer.http.client.config.connectionTimeout}") long connectionTimeout,
                              @Value("${offer.http.client.config.readTimeout}") long readTimeout,
                              RestTemplateResponseErrorHandler errorHandler) {
        return new RestTemplateBuilder()
                .errorHandler(errorHandler)
                .setConnectTimeout(Duration.ofMillis(connectionTimeout))
                .setReadTimeout(Duration.ofMillis(connectionTimeout))
                .build();
    }

    @Bean
    RemoteOfferClient offerHttpClient(RestTemplate restTemplate, @Value("${offer.http.client.config.uri:http://example.com}") String uri) {
        return new OfferHttpClient(restTemplate, uri);
    }
}
