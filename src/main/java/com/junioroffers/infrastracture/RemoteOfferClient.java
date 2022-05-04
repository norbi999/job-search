package com.junioroffers.infrastracture;

import com.junioroffers.infrastracture.offer.dto.OfferDto;

import java.util.List;

public interface RemoteOfferClient {
    List<OfferDto> getOffers();
}
