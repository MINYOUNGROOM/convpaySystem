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
        CardUseResult cardUseResult;
        MoneyUseResult moneyUseResult;


        if(payrequest.getPayMethodType() == PayMethodType.CARD){
            cardAdapter.authorization();
            cardAdapter.approval();
            cardUseResult =  cardAdapter.capture(payrequest.getPayAmount()); // 여기서 반환값을 받기엔 해당 값을 가지고 있어줘야해서 위 지역변수로 빼줌
        } else {
            moneyUseResult = moneyAdapter.use(payrequest.getPayAmount());
        }


        // 실패 케이스
        if (moneyUseResult == MoneyUseResult.USE_FAIL) {
            return new PayResponse(PayResult.FAIL, 0);

        }
        // 성공 케이스
        return new PayResponse(PayResult.SUCCESS, request.getPayAmount());
    }

    // TDD 상 메소드를 만들면 테스트 케이스 구현
    public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
        MoneyUseCancelResult moneyUseCancelResult = moneyAdapter.useCancel(payCancelRequest.getPayCancelAmount());

        if (moneyUseCancelResult == MoneyUseCancelResult.MONEY_USE_CANCEL_FAIL) {
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
        }
        // 성공 케이스
        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS, payCancelRequest.getPayCancelAmount());
    }
}
