package wang.mh.feignconsumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
import wang.mh.feignconsumer.Product;

@FeignClient("hello-service")
public interface ProductService {

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    Product query(@RequestParam("code") String code);

    @RequestMapping(value = "/product", method = RequestMethod.DELETE)
    String delete(@RequestParam("code") String code);

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    String add(@RequestBody Product product);

}
