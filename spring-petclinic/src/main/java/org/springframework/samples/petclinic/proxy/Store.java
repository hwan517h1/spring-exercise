package org.springframework.samples.petclinic.proxy;

public class Store {

    private Payment payment;

    public Store(Payment payment) {
        this.payment = payment;
    }

    public void buyItem(int amount) {
        payment.pay(amount);
    }
}
