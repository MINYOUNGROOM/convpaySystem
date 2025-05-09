package com.zerobase.convpay.dto;

public class PayRequest {
    // 편의점 종류
    ConvenienceType convenienceType;

    // 결제 금액
    Integer payAmount;

    // 생성자
    public PayRequest(ConvenienceType convenienceType, Integer payAmount) {
        this.convenienceType = convenienceType;
        this.payAmount = payAmount;
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
