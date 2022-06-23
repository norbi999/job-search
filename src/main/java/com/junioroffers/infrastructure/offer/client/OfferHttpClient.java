package com.junioroffers.infrastructure.offer.client;

import com.junioroffers.infrastructure.RemoteOfferClient;
import com.junioroffers.infrastructure.offer.dto.JobOfferDto;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
@AllArgsConstructor

public class OfferHttpClient implements RemoteOfferClient {

    private final RestTemplate restTemplate;
    private final String uri;

    @Override
    public List<JobOfferDto> getOffers() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        final HttpEntity<HttpHeaders> requestEntity = new HttpEntity<>(httpHeaders);
        try {
            ResponseEntity<List<JobOfferDto>> response = restTemplate.exchange(uri, HttpMethod.GET, requestEntity,
                    new ParameterizedTypeReference<List<JobOfferDto>>() {});
            final List<JobOfferDto> body = response.getBody();
            return (body != null) ? body : Collections.emptyList();
        } catch (ResourceAccessException e){
            return Collections.emptyList();
        }
    }
}
