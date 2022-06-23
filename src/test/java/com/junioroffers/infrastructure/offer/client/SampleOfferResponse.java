package com.junioroffers.infrastructure.offer.client;

import com.junioroffers.infrastructure.offer.dto.JobOfferDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public interface SampleOfferResponse extends SampleOfferDto {

    default ResponseEntity<List<JobOfferDto>> responseWithOneOffer() {
        return new ResponseEntity<>(Collections.singletonList(emptyOffer()), HttpStatus.ACCEPTED);
    }

    default ResponseEntity<List<JobOfferDto>> responseWithNoOffers() {
        return new ResponseEntity<>(Collections.emptyList(), HttpStatus.ACCEPTED);
    }

    default ResponseEntity<List<JobOfferDto>> responseWithOffers(JobOfferDto... jobOfferDtos) {
        return new ResponseEntity<>(Arrays.asList(jobOfferDtos), HttpStatus.ACCEPTED);
    }
}
