package com.zerobase.convpay.dto;

import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethodType;

public class PayRequest {
    // 결제 수단
    PayMethodType payMethodType;

    // 편의점 종류
    ConvenienceType convenienceType;

    // 결제 금액
    Integer payAmount;

    public PayMethodType getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(PayMethodType payMethodType) {
        this.payMethodType = payMethodType;
    }

    // 생성자
    public PayRequest(PayMethodType payMethodType, ConvenienceType convenienceType, Integer payAmount) {
        this.payMethodType = payMethodType;
        this.convenienceType = convenienceType;
        this.payAmount = payAmount;
    }

    // 생성자
    public PayRequest(PayMethodType payMethodType) {
        this.payMethodType = payMethodType;
    }


    // lombok을 안 쓰기 때문에 직접 getter, setter 주입
    public ConvenienceType getConvenienceType() {
        return convenienceType;
    }

    public void setConvenienceType(ConvenienceType convenienceType) {
        this.convenienceType = convenienceType;
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }


}
