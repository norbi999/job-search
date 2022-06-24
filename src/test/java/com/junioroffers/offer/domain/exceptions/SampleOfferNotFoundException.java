package com.junioroffers.offer.domain.exceptions;

public interface SampleOfferNotFoundException {

    default OfferNotFoundException sampleOfferNotFoundException() {
        return new OfferNotFoundException(100L);
    }
}
