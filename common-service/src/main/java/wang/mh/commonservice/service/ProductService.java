package wang.mh.commonservice.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wang.mh.commonservice.dto.Product;

public interface ProductService {
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    Product query(@RequestParam("code") String code);

    @RequestMapping(value = "/product", method = RequestMethod.DELETE)
    String delete(@RequestParam("code") String code);

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    String add(@RequestBody Product product);
}
