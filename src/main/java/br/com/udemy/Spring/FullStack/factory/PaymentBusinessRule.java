package br.com.udemy.Spring.FullStack.factory;

import br.com.udemy.Spring.FullStack.domain.PaymentTicket;

import java.time.LocalDate;

public class PaymentBusinessRule {

    public static LocalDate definePaymentTicket(PaymentTicket paymentTicket){
        return paymentTicket.getDueDate().plusDays(7);
    }
}
