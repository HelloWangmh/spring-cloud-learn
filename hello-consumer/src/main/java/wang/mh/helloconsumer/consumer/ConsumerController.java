package wang.mh.helloconsumer.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.mh.helloconsumer.service.ConsumerService;

@RestController
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @RequestMapping("/consume")
    public String consume() {
        return consumerService.hello();
    }


}
