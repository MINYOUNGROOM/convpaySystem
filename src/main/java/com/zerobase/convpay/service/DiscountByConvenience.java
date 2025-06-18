package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayRequest;
import org.springframework.stereotype.Component;

@Component
public class DiscountByConvenience implements DiscountInterface {
    @Override
    public Integer getDiscountAmount(PayRequest payRequest) {
        switch (payRequest.getConvenienceType()) {
            case CU -> {
                return payRequest.getPayAmount() * 9 / 10 ;
            }
            case GS25 -> {
                return payRequest.getPayAmount() * 8 / 10 ;
            }
            case SEVEN -> {
                return payRequest.getPayAmount();
            }
        }
        return payRequest.getPayAmount();
    }
}
