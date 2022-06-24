package com.junioroffers.infrastructure.offer.client;

import com.junioroffers.infrastructure.offer.dto.JobOfferDto;

interface SampleOfferDto {

    default JobOfferDto emptyOffer() {
        return new JobOfferDto();
    }

    default JobOfferDto offerWithParameters(String company, String salary, String url, String position) {
        return JobOfferDto.builder()
                .salary(salary)
                .company(company)
                .offerUrl(url)
                .title(position)
                .build();
    }
}
