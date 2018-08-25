package wang.mh.helloconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class ConsumerService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public String hello() {
        try {
            Random r = new Random();
            TimeUnit.MILLISECONDS.sleep(r.nextInt(3000));//默认超过2000ms不返还就会断路
        } catch (InterruptedException e) {
        }
        ResponseEntity<String> response = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class);
        return response.getBody();
    }

    public String fallback() {
        return "it's wrong";
    }
}
