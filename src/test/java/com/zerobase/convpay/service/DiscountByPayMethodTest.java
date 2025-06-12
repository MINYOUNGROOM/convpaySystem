package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByPayMethodTest {
    DiscountByPayMethod discountByPayMethod = new DiscountByPayMethod();

    @Test
    void discountSuccess() {
        //given
        PayRequest payRequestMoney = new PayRequest(PayMethodType.MONEY,
                ConvenienceType.GS25, 1000);
        PayRequest payRequestCard = new PayRequest(PayMethodType.CARD,
                ConvenienceType.GS25, 1000);
        //when
        Integer discountedAmountMoney = discountByPayMethod.getDiscountAmount(payRequestMoney);
        Integer discountedAmountCard = discountByPayMethod.getDiscountAmount(payRequestCard);
        //then
        assertEquals(700,discountedAmountMoney);
        assertEquals(1000,discountedAmountCard);
    }

}