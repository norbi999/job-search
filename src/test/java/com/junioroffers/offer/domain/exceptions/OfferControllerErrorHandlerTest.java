package com.junioroffers.offer.domain.exceptions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OfferControllerErrorHandlerTest implements SampleOfferErrorResponse, SampleOfferNotFoundException {

    @Test
    public void should_return_correct_error_response() {
        OfferControllerErrorHandler offerControllerErrorHandler = new OfferControllerErrorHandler();
        final OfferNotFoundException givenException = sampleOfferNotFoundException();
        final OfferErrorResponse expectedResponse = sampleOfferErrorResponse();

        final OfferErrorResponse actualResponse = offerControllerErrorHandler.offerNotFound(givenException);

        assertThat(actualResponse).isEqualTo(expectedResponse);
    }
}