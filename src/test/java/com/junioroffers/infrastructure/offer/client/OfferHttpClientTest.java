package com.junioroffers.infrastructure.offer.client;

import com.junioroffers.infrastructure.RemoteOfferClient;
import com.junioroffers.infrastructure.offer.dto.JobOfferDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

class OfferHttpClientTest implements SampleOfferResponse, SampleRestTemplateExchangeResponse, SampleOfferDto {

    @Test
    public void should_return_one_element_list_of_offers() {
        // given
        final RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
        ResponseEntity<List<JobOfferDto>> responseEntity = responseWithOneOffer();
        when(getExchange(restTemplate)).thenReturn(responseEntity);
        RemoteOfferClient remoteOfferClient = new OfferHttpClient(restTemplate, "https://programming-masterpiece.com:1123/test");

        // when
        final List<JobOfferDto> offers = remoteOfferClient.getOffers();

        // then
        assertThat(offers.size()).isEqualTo(1);
    }

    @Test
    public void should_return_empty_list_of_offers() {
        // given
        final RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
        ResponseEntity<List<JobOfferDto>> responseEntity = responseWithNoOffers();
        when(getExchange(restTemplate)).thenReturn(responseEntity);
        RemoteOfferClient remoteOfferClient = new OfferHttpClient(restTemplate, "https://programming-masterpiece.com:1123/test");

        // when
        final List<JobOfferDto> offers = remoteOfferClient.getOffers();

        // then
        assertThat(offers.size()).isEqualTo(0);
    }

    @Test
    public void should_return_two_offers() {
        // given
        final RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
        ResponseEntity<List<JobOfferDto>> responseEntity = responseWithOffers(emptyOffer(), emptyOffer());
        when(getExchange(restTemplate)).thenReturn(responseEntity);
        RemoteOfferClient remoteOfferClient = new OfferHttpClient(restTemplate, "https://programming-masterpiece.com:1123/test");

        // when
        final List<JobOfferDto> offers = remoteOfferClient.getOffers();

        // then
        assertThat(offers.size()).isEqualTo(2);
    }
}
