package com.zrx.springCloud.service;

import com.zrx.springCloud.entity.Order;

import java.util.Optional;

/**
 * @author Administrator
 * @date 2022/7/1
 * @time 16:54
 */
public interface IOrderService {
    Order create(Integer pid, Integer number);
    Order findByOid(Integer oid);
}
