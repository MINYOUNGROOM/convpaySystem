package com.zerobase.convpay.service;


import com.zerobase.convpay.dto.*;
import com.zerobase.convpay.type.*;

/**
 * [클래스 UML]
 * 사용자 -> 결제 서비스 -> 머니 어댑터
 */
public class ConveniencePayService { // 편결이

    private final MoneyAdapter moneyAdapter = new MoneyAdapter();
    private final CardAdapter cardAdapter = new CardAdapter();

    public PayResponse pay(PayRequest payrequest) {
        PaymentInterface paymentInterface;

        if(payrequest.getPayMethodType() == PayMethodType.CARD) {
            paymentInterface = cardAdapter;
        }else {
            paymentInterface = moneyAdapter;
        }

        PaymentResult paymentResult = paymentInterface.payment(payrequest.getPayAmount());

        // 실패 케이스
        if (paymentResult == PaymentResult.PAYMENT_FAIL){
            return new PayResponse(PayResult.FAIL, 0);
        }
        // 성공 케이스
        return new PayResponse(PayResult.SUCCESS, payrequest.getPayAmount());
    }

    // TDD 상 메소드를 만들면 테스트 케이스 구현
    public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
        PaymentInterface paymentInterface;

        if(payCancelRequest.getPayMethodType() == PayMethodType.CARD) {
            paymentInterface = cardAdapter;
        }else {
            paymentInterface = moneyAdapter;
        }

        CancelPaymentResult cancelPaymentResult = paymentInterface.cancelPayment(payCancelRequest.getPayCancelAmount());

        if (cancelPaymentResult == CancelPaymentResult.CANCEL_PAYMENT_FAIL) {
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS, 0);
        }

        // 성공 케이스
        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS, payCancelRequest.getPayCancelAmount());
    }
}
