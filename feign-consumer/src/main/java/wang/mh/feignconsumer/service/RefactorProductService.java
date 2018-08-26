package wang.mh.feignconsumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import wang.mh.commonservice.service.ProductService;

@FeignClient(value = "hello-service", fallback = ProductServiceFallback.class)
public interface RefactorProductService extends ProductService{

}
