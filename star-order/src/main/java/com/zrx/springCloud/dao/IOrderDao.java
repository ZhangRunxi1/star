package com.zrx.springCloud.dao;

import com.zrx.springCloud.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Administrator
 * @date 2022/7/1
 * @time 16:55
 */
public interface IOrderDao extends JpaRepository<Order,Integer> {
}
