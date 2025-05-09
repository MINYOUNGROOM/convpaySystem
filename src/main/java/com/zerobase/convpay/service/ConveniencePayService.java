package com.zerobase.convpay.service;


import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.dto.PayResponse;
import com.zerobase.convpay.dto.PayResult;

/**
 * [클래스 UML]
 * 사용자 -> 결제 서비스 -> 머니 어댑터
 */
public class ConveniencePayService {

    private  final MoneyAdapter moneyAdapter = new MoneyAdapter();


    // TODO : 결제 개발필요
    public PayResponse pay(PayRequest request) {
        moneyAdapter.use();
        return new PayResponse(PayResult.SUCCESS, 100);
    }

    // TODO : 결제취소 개발필요
    public void payCancle() {


    }
}
