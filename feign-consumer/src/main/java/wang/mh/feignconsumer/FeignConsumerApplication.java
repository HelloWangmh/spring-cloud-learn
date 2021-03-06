package wang.mh.feignconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@EnableFeignClients//开启 Feign
@SpringBootApplication
public class FeignConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignConsumerApplication.class, args);
	}

	@Bean
	public AlwaysSampler alwaysSampler() {
		return new AlwaysSampler();
	}
}
