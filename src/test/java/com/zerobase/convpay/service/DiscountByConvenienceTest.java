package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByConvenienceTest {
    DiscountByConvenience discountByConvenience
            = new DiscountByConvenience();

    @Test
    void discountTest() {
        //given
        PayRequest payRequestGS25 = new PayRequest(PayMethodType.MONEY
                , ConvenienceType.GS25, 1000);
        PayRequest payRequestCU = new PayRequest(PayMethodType.MONEY
                , ConvenienceType.CU, 1000);
        PayRequest payRequestSEVEN = new PayRequest(PayMethodType.MONEY
                , ConvenienceType.SEVEN, 1000);
        //when
        Integer discountedAmountGS25 =
                discountByConvenience.getDiscountAmount(payRequestGS25);
        Integer discountedAmountCU =
                discountByConvenience.getDiscountAmount(payRequestCU);
        Integer discountedAmountSEVEN =
                discountByConvenience.getDiscountAmount(payRequestSEVEN);
        //then
        assertEquals(800, discountedAmountGS25);
        assertEquals(900, discountedAmountCU);
        assertEquals(1000, discountedAmountSEVEN);
    }

}