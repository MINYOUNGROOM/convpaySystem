package com.zerobase.convpay.service;


import com.zerobase.convpay.dto.*;

/**
 * [클래스 UML]
 * 사용자 -> 결제 서비스 -> 머니 어댑터
 */
public class ConveniencePayService {

    private final MoneyAdapter moneyAdapter = new MoneyAdapter();


    // TODO : 결제 개발필요
    public PayResponse pay(PayRequest request) {
        MoneyUseResult moneyUseResult = moneyAdapter.use(request.getPayAmount());

        // 보통 실패 Exception이 계속 추가될 수 있기 때문에
        // 실패 경우를 위에 적어주고 맨 아래  성공 케이스를 넣어준다.
        // fail fast
        // Method()
        // Exception case 1
        // Exception case 2
        // Exception case 3
        // Exception case 4

        // Success case(Only one)
        // 실패 케이스
        if (moneyUseResult == MoneyUseResult.USE_FAIL) {
            return new PayResponse(PayResult.FAIL, 0);

        }
        // 성공 케이스
        return new PayResponse(PayResult.SUCCESS, request.getPayAmount());
    }

    // TODO : 결제취소 개발필요
    public PayCancelResponse payCancle(PayCancelRequest payCancelRequest) {


    }
}
