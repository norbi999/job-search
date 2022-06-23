package com.junioroffers.offer.domain;

import com.junioroffers.offer.domain.dto.OfferDto;
import com.junioroffers.offer.domain.dto.SampleOfferDto;
import com.junioroffers.offer.domain.exceptions.OfferNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

class OfferServiceTest implements SampleOfferDto {

    @Test
    public void should_return_two_expected_offers() {
        OfferService offerService = new OfferService();
        final List<OfferDto> expectedOffers = Arrays.asList(cybersourceOffer(), cdqPolandOffer());

        final List<OfferDto> allOffers = offerService.findAllOffers();

        then(allOffers).containsExactlyInAnyOrderElementsOf(expectedOffers);
    }

    @Test
    public void should_return_correct_offer_for_given_id_two() {
        OfferService offerService = new OfferService();

        final OfferDto offerById = offerService.findOfferById(2L);

        then(offerById).isEqualTo(cdqPolandOffer());
    }

    @Test
    public void should_return_correct_offer_for_given_id_one() {
        OfferService offerService = new OfferService();

        final OfferDto offerById = offerService.findOfferById(1L);

        then(offerById).isEqualTo(cybersourceOffer());
    }

    @Test
    public void should_throw_offer_not_found_exception_when_no_offer_with_given_id() {
        OfferService offerService = new OfferService();

        Throwable thrown = catchThrowable(() -> offerService.findOfferById(100));

        assertThat(thrown)
                .isInstanceOf(OfferNotFoundException.class)
                .hasMessage("Offer with id 100 not found");
    }
}