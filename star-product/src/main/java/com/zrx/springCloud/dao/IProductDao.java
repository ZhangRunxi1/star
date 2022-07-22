package com.zrx.springCloud.dao;

import com.zrx.springCloud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Administrator
 * @date 2022/7/1
 * @time 16:45
 */
public interface IProductDao extends JpaRepository<Product,Integer> {
}
