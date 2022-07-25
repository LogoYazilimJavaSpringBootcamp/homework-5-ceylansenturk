package com.paymentservice.paymentservice.controller;

import com.paymentservice.paymentservice.model.Payment;
import com.paymentservice.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired(required = false)
    public Payment createPayment(@RequestBody Payment payment){

        return paymentService.createPayment(payment);

    }

    @GetMapping
    public Payment createPayment(@PathVariable Integer paymentId){
        return paymentService.createPaymentById(paymentId);
    }
}
