package com.junioroffers.offer.domain.exceptions;

import org.springframework.http.HttpStatus;

public interface SampleOfferErrorResponse {

    default OfferErrorResponse sampleOfferErrorResponse() {
        return new OfferErrorResponse("Offer with id 100 not found", HttpStatus.NOT_FOUND);
    }
}
