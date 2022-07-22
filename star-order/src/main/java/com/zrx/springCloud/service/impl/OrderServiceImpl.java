package com.zrx.springCloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zrx.springCloud.dao.IOrderDao;
import com.zrx.springCloud.entity.Order;
import com.zrx.springCloud.entity.Product;
import com.zrx.springCloud.service.IOrderService;
import com.zrx.springCloud.service.IProductService;
import com.zrx.springCloud.util.ResultVO;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.Random;

/**
 * @author Administrator
 * @date 2022/7/1
 * @time 16:55
 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderDao orderDao;
    @Autowired
    private IProductService iProductService;

    @HystrixCommand
    @Override
    public Order create(Integer pid, Integer number) {
//        randomlyRunLong();
        ResultVO resultVO = iProductService.findByPid(pid);
        Integer status = resultVO.getCode();
        if (status == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            return null;
        }

        Map map = (Map) resultVO.getData();
        Product product = new Product();
        try {
            BeanUtils.populate(product, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 创建订单
        Order order = new Order();
        // 为了测试，用户数据就直接定为常量
        order.setUid(1);
        order.setUsername("邓紫棋");
        order.setPid(pid);
        order.setPname(product.getPname());
        order.setPrice(product.getPrice());
        order.setNumber(number);
        orderDao.save(order);

        return order;
    }

    @HystrixCommand(fallbackMethod = "buildFallbackOrder")
    @Override
    public Order findByOid(Integer oid) {
//        randomlyRunLong();
        Optional<Order> optional = orderDao.findById(oid);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }


    private Order buildFallbackOrder(Integer oid) {
        Order order = new Order();
        order.setNumber(-1);
        order.setPid(-1);
        order.setNumber(0);
        order.setPname("后备数据");
        order.setPrice(0d);
        order.setUid(-1);
        order.setUsername("后备数据");
        return order;
    }
    private void randomlyRunLong() {
        Random rand = new Random();
        // （（大数 - 小数） + 1） + 小数
        int n = rand.nextInt((3 - 1) + 1) + 1;
        if (n == 3) {
            try {
                // 休眠11s
                Thread.sleep(11000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
