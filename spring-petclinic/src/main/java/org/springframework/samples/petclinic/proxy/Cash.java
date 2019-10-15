package org.springframework.samples.petclinic.proxy;

public class Cash implements Payment {

    @Override
    public void pay(int amount) {
        System.out.println(amount + "원을 현금으로 결제했습니다.");
    }
}
