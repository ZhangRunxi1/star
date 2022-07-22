package com.zrx.springCloud.controller;

import com.zrx.springCloud.entity.Order;
import com.zrx.springCloud.entity.Product;
import com.zrx.springCloud.entity.User;
import com.zrx.springCloud.service.IOrderService;
import com.zrx.springCloud.service.IProductService;
import com.zrx.springCloud.util.ResultVO;
import com.zrx.springCloud.utils.myEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Administrator
 * @date 2022/7/5
 * @time 23:33
 */
@RestController
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private IProductService productService;

    @Autowired
    private IOrderService orderService;
    @PostMapping("/orders/lapse")
    public ResultVO lapse() throws InterruptedException{
        return productService.lapse();
    }

    @GetMapping("/orders/lb")
    public ResultVO testLoadBalance(HttpServletRequest request) {
        return productService.testLoadBalance();
    }

//    @GetMapping("/orders/lb")
//    public ResultVO testLoadBalance(HttpServletRequest request) {
//        ResultVO resultVO = restTemplate.getForObject("http://star-product/products/lb", ResultVO.class);
//        return resultVO;
//    }

    @RequestMapping("/orders/foo")
    public ResultVO foo(HttpServletRequest request) {
        User user = new User();
        user.setUid(10);
        user.setUsername("张三");
        user.setPassword("123");
        user.setTelephone("23234321423");
        ResultVO foo = productService.foo(user);
        return foo;
    }

    @GetMapping("orders/testObjectParam")
    public ResultVO testObjectParam() {
        Product product = new Product();
        product.setPid(4);
        product.setPname("光年之外");
        product.setPrice(60d);
        product.setStock(100);
        ResultVO resultVO = productService.testObjectParam(product);
        return resultVO;
    }

    @GetMapping("/orders/{oid}")
    public ResultVO findByOid(@PathVariable Integer oid) {
        Order order = orderService.findByOid(oid);
        return order != null ? ResultVO.success("查询订单成功", order) : ResultVO.failure("查询订单失败");
    }


}
