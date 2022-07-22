package com.zrx.springCloud.service.impl;

import com.zrx.springCloud.dao.IProductDao;
import com.zrx.springCloud.entity.Product;
import com.zrx.springCloud.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

/**
 * @author Administrator
 * @date 2022/7/1
 * @time 16:41
 */
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    IProductDao productDao;


    @Override
    public Product findByPid(Integer pid) {
        Optional<Product> optional = productDao.findById(pid);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
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