package wang.mh.helloservice.controller;

import org.springframework.web.bind.annotation.*;
import wang.mh.helloservice.Product;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class ProductController {

    private Map<String, Product> map = new ConcurrentHashMap<>();

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public Product query(@RequestParam String code) {
        return map.get(code);
    }

    @RequestMapping(value = "/product", method = RequestMethod.DELETE)
    public String delete(@RequestParam String code) {
        return map.containsKey(code) ? map.remove(code).getCode() : null;
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String add(@RequestBody Product product) {
        map.put(product.getCode(), product);
        return product.getCode();
    }
}
