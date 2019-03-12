package com.payment.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Value("${eureka.instance.instanceId}")
    private String ins;
//through the gateway  http://localhost:8080/payment-service/payment/doit
//directly http://localhost:11431/payment/doit
//    the port is updated by the yml file . in it port=0 meaning port is randomly selected  it overwrites server.port=7001 from the bootstrap.properties
    @RequestMapping("payment/doit")
    public String payment()
    {
        return "Hello payment (" + ins +")";
    }
}
