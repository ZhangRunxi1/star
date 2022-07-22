package com.zrx.springCloud.service;

import com.zrx.springCloud.entity.Product;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @date 2022/7/1
 * @time 16:41
 */

public interface IProductService {
    Product findByPid(Integer pid);
}
