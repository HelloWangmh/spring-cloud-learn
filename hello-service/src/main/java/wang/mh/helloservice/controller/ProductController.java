package wang.mh.helloservice.controller;

import org.springframework.web.bind.annotation.*;
import wang.mh.commonservice.dto.Product;
import wang.mh.commonservice.service.ProductService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class ProductController implements ProductService{

    private Map<String, Product> map = new ConcurrentHashMap<>();

    @Override
    public Product query(@RequestParam String code) {
        return map.get(code);
    }

    @Override
    public String delete(@RequestParam String code) {
        return map.containsKey(code) ? map.remove(code).getCode() : null;
    }

    @Override
    public String add(@RequestBody Product product) {
        map.put(product.getCode(), product);
        return product.getCode();
    }
}
