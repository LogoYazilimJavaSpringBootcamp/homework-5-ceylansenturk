package com.java.moviereviewsite.client;

import com.java.moviereviewsite.dto.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "payment-service", url = "${payment.url}")
public interface PaymentClient {
    @PostMapping(value = "/payments")
    Payment createPayment(@RequestBody Payment payment);
}
