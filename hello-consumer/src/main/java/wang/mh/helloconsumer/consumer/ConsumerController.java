package wang.mh.helloconsumer.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consume")
    public String consume() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class);
        return response.getBody();
    }
}
