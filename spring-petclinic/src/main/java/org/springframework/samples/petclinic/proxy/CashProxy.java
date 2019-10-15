package org.springframework.samples.petclinic.proxy;

import org.springframework.util.StopWatch;

public class CashProxy implements Payment { // Cash의 기존 코드 유지하며, CashProxy에 새로운 기능 추가

    Payment cash = new Cash();

    @Override
    public void pay(int amount) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        if (amount < 1000) {
            System.out.print("1000원 미만이므로 ");
            cash.pay(amount);
        } else {
            System.out.println(amount + "원을 신용카드로 결제했습니다.");
        }

        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }
}
