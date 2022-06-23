package com.junioroffers.infrastructure;

import com.junioroffers.infrastructure.offer.dto.JobOfferDto;

import java.util.List;

public interface RemoteOfferClient {
    List<JobOfferDto> getOffers();
}
