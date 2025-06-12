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
//    private final DiscountInterface discountInterface = new DiscountByPayMethod();
    // 예로들어, 정책이 바뀌어서 결제 수단 말고 편의점 으로 할인이 되게 하고 싶어요
    // ~ 한다면 다시 아래껄로 사용
    private final DiscountInterface discountInterface = new DiscountByConvenience();

    public PayResponse pay(PayRequest payrequest) {
        PaymentInterface paymentInterface;

        if(payrequest.getPayMethodType() == PayMethodType.CARD) {
            paymentInterface = cardAdapter;
        }else {
            paymentInterface = moneyAdapter;
        }

        Integer discountAmount = discountInterface.getDiscountAmount(payrequest);
        PaymentResult paymentResult =
                paymentInterface.payment(discountAmount);

        // 실패 케이스
        if (paymentResult == PaymentResult.PAYMENT_FAIL){
            return new PayResponse(PayResult.FAIL, 0);
        }
        // 성공 케이스
        return new PayResponse(PayResult.SUCCESS, discountAmount);
    }

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
