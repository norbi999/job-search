package com.junioroffers.offer.domain;


import com.junioroffers.offer.domain.dto.OfferDto;

import java.util.UUID;


public class OfferMapper {
    // mapToOfferDto przyjmującą (String companyName, String position, String salary, String offerUrl).

    public static OfferDto mapToOfferDto(UUID id, String position, String salary, String offerUrl, String cybersource) {
        return OfferDto.builder()
                .id(id)
                .companyName(cybersource)
                .position(position)
                .salary(salary)
                .offerUrl(offerUrl)
                .build();
    }
}


