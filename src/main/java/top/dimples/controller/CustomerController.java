package top.dimples.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.web.PagedModel;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.dimples.model.Customer;
import top.dimples.projection.CustomerProjection;
import top.dimples.repository.CustomerRepository;

import java.util.Objects;

/**
 * @author Dimples_YJ
 * @create 2024/9/21
 */
@RestController
@AllArgsConstructor
public class CustomerController {

    private CustomerRepository customerRepository;

    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/page")
    public Page<Customer> getAllCustomers(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @GetMapping("/lastName")
    public CustomerProjection getLastName(@RequestParam String lastName) {
        return customerRepository.findByLastName(lastName);
    }

    @GetMapping("/redis")
    public String getRedis(@RequestParam String key) {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        if (Objects.isNull(ops.get(key))) {
            ops.set(key, String.valueOf(System.currentTimeMillis()));
        }
        return ops.get(key);
    }
}
