package com.junioroffers.infrastructure.offer.client;

import com.junioroffers.infrastructure.offer.dto.OfferDto;

interface SampleOfferDto {

    default OfferDto emptyOffer() {
        return new OfferDto();
    }

    default OfferDto offerWithParameters(String company, String salary, String url, String position) {
        return OfferDto.builder()
                .salary(salary)
                .company(company)
                .offerUrl(url)
                .title(position)
                .build();
    }
}
