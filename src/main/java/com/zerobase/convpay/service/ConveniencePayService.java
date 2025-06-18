package com.zerobase.convpay.service;


import com.zerobase.convpay.dto.*;
import com.zerobase.convpay.type.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * [클래스 UML]
 * 사용자 -> 결제 서비스 -> 머니 어댑터
 */

@Component
public class ConveniencePayService { // 편결이

    private final CardAdapter cardAdapter = new CardAdapter();
    private final MoneyAdapter moneyAdapter = new MoneyAdapter();

    private final Map<PayMethodType, PaymentInterface> paymentInterfaceMap =
            new HashMap<>();
    private final DiscountInterface discountInterface;

    public ConveniencePayService(Set<PaymentInterface> paymentInterfaceSet,
                                 DiscountInterface discountByConvenience) {
        paymentInterfaceSet.forEach(
                paymentInterface -> paymentInterfaceMap.put(
                        paymentInterface.getPayMethodType(), paymentInterface
                )
        );

        this.discountInterface = discountByConvenience;
    }

    public PayResponse pay(PayRequest payrequest) {
        // 결제수단을 key 로 가지고 옴
        PaymentInterface paymentInterface =
                paymentInterfaceMap.get(payrequest.getPayMethodType());

        if (payrequest.getPayMethodType() == PayMethodType.CARD) {
            paymentInterface = cardAdapter;
        } else {
            paymentInterface = moneyAdapter;
        }

        Integer discountAmount = discountInterface.getDiscountAmount(payrequest);

        PaymentResult paymentResult =
                paymentInterface.payment(discountAmount);

        // 실패 케이스
        if (paymentResult == PaymentResult.PAYMENT_FAIL) {
            return new PayResponse(PayResult.FAIL, 0);
        }
        // 성공 케이스
        return new PayResponse(PayResult.SUCCESS, discountAmount);
    }

    public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
        PaymentInterface paymentInterface;

        if (payCancelRequest.getPayMethodType() == PayMethodType.CARD) {
            paymentInterface = cardAdapter;
        } else {
            paymentInterface = moneyAdapter;
        }

        CancelPaymentResult cancelPaymentResult = paymentInterface.cancelPayment(
                payCancelRequest.getPayCancelAmount());

        if (cancelPaymentResult == CancelPaymentResult.CANCEL_PAYMENT_FAIL) {
            return new PayCancelResponse(
                    PayCancelResult.PAY_CANCEL_SUCCESS, 0);
        }

        // 성공 케이스
        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS,
                payCancelRequest.getPayCancelAmount());
    }
}
