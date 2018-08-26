package wang.mh.feignconsumer.service;

import org.springframework.stereotype.Service;
import wang.mh.commonservice.dto.Product;
import wang.mh.commonservice.service.ProductService;
@Service
public class ProductServiceFallback implements RefactorProductService{
    @Override
    public Product query(String code) {
        return new Product("", "");
    }

    @Override
    public String delete(String code) {
        return null;
    }

    @Override
    public String add(Product product) {
        return null;
    }
}
