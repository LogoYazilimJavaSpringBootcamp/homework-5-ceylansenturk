package com.paymentservice.paymentservice.service;

import com.paymentservice.paymentservice.model.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentService {
    public Payment createPayment(Payment payment) {

        log.info("Üyelik oluşturuldu "+ payment.toString());
        return payment;
    }

    public Payment createPaymentById(Integer paymentId) {
        return null;
    }


}
