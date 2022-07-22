package com.zrx.springCloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zrx.springCloud.entity.Product;
import com.zrx.springCloud.entity.User;
import com.zrx.springCloud.util.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Administrator
 * @date 2022/7/1
 * @time 16:41
 */

@FeignClient(name = "star-product")
public interface IProductService {
    @GetMapping("/products/{pid}")
    ResultVO findByPid(@PathVariable("pid") Integer pid);

    @GetMapping("/products/lb")
    ResultVO testLoadBalance();

    @RequestMapping("/products/foo")
    public ResultVO foo(@RequestBody User user);

    @PostMapping("/products/lapse")
    public ResultVO lapse() throws InterruptedException;

    @PostMapping("/products/testObjectParam")
    public ResultVO testObjectParam(@RequestBody Product product);
}
