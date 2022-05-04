package com.junioroffers.infrastracture.offer.client;

import com.junioroffers.infrastracture.offer.dto.OfferDto;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class OfferClientTest {

    @Test
    public void should_return_one_element_list_of_offers() {
        //given
        RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
        String uri = "test";

        when(restTemplate.exchange(ArgumentMatchers.anyString(),
                ArgumentMatchers.any(HttpMethod.class),
                ArgumentMatchers.any(),
                ArgumentMatchers.<ParameterizedTypeReference<List<OfferDto>>>any()))
                .thenReturn(new ResponseEntity<>(Collections.singletonList(new OfferDto()), HttpStatus.ACCEPTED));
        OfferHttpClient offerHttpClient = new OfferHttpClient(restTemplate, uri);

        //when
        List<OfferDto> offers = offerHttpClient.getOffers();

        //then
        assertThat(offers.size()).isEqualTo(1);

    }


    //  should_retourn_empty_list_of_offers

    //  should_retourn_two_offers

}