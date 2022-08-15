package com.zrx.springCloud.controller;

import com.zrx.springCloud.entity.Product;
import com.zrx.springCloud.entity.User;
import com.zrx.springCloud.util.ResultVO;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @date 2022/7/5
 * @time 23:34
 */
@RestController
public class TestController {
    @GetMapping("/products/lb")
    public ResultVO testLoadBalance(HttpServletRequest request) {
        return ResultVO.success("处理本次请求的product-service实例端口：" + request.getServerPort(), null);
    }


    @RequestMapping("/products/foo")
    public ResultVO foo(@RequestBody User user) {
        return ResultVO.success("post请求完成！", user);
    }

    @PostMapping("/products/lapse")
    public ResultVO lapse() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        System.out.println("测试代码提交！");
        return ResultVO.success("lapse...", null);
    }

    @PostMapping("/products/testObjectParam")
    public ResultVO testObjectParam(@RequestBody Product product, HttpServletRequest request) {
        return ResultVO.success(request.getServerPort() + "接收对象成功", product);
    }
}