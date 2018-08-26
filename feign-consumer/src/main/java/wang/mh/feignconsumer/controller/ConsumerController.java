package wang.mh.feignconsumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.mh.feignconsumer.Product;
import wang.mh.feignconsumer.service.HelloService;
import wang.mh.feignconsumer.service.ProductService;

import java.util.Objects;

@RestController
@Slf4j
public class ConsumerController {

    @Autowired
    private HelloService helloService;
    @Autowired
    private ProductService productService;

    @RequestMapping("/consume")
    public String consume(){
        return helloService.hello();
    }


    @RequestMapping("/product")
    public boolean product() {
        String code = "123";
        Product product = new Product(code, "Iphone");
        productService.add(product);
        Product queryProduct = productService.query(code);
        log.info("query product : {}", queryProduct.toString());
        productService.delete(code);
        return Objects.isNull(productService.query(code));
    }
}
