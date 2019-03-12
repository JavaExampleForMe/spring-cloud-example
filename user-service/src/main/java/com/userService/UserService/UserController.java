package com.userService.UserService;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    //through the gateway http://localhost:8080/user-service/user/doit
//directly http://localhost:8001/user/doit
    //    the port is updated by the yml file . in it port=8001  it overwrites server.port=7001 from the bootstrap.properties
    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping("user/doit")
    public String user()
    {
        return restTemplate.getForObject("http://payment-service/payment/doit",String.class)+"Hello user";

    }

    public String fallback(Throwable t){
        return "USer Fallback.....................";
    }
}
