package wang.mh.helloservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    @Autowired
    private Registration registration;


    @RequestMapping("hello")
    public String hello() {
        log.info("host : {}, serverId : {}", registration.getPort(), registration.getServiceId());
        return "hello,world";
    }
}
