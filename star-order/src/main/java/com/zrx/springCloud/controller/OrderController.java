package com.zrx.springCloud.controller;

import com.zrx.springCloud.entity.Order;
import com.zrx.springCloud.service.IOrderService;
import com.zrx.springCloud.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Administrator
 * @date 2022/7/1
 * @time 16:53
 */
@RestController
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @PostMapping("/orders/{pid}/{number}")
    public ResultVO create(@PathVariable Integer pid, @PathVariable Integer number) throws Exception {
        Order order = orderService.create(pid, number);
        System.out.println("测试热启动"+order);
        return order != null ? ResultVO.success("下单成功", order) : ResultVO.failure("下单失败");
    }
}
