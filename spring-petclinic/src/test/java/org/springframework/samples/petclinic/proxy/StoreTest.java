package org.springframework.samples.petclinic.proxy;

import org.junit.Test;

public class StoreTest {

    @Test
    public void testPay() {
        Payment cashProxy = new CashProxy();
        Store store = new Store(cashProxy);
        System.out.println("1500원짜리 물건 구매");
        store.buyItem(1500);
        System.out.println("900원짜리 물건 구매");
        store.buyItem(900);
    }
}

