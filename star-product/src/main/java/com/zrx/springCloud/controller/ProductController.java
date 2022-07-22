package com.zrx.springCloud.controller;

import com.zrx.springCloud.entity.Product;
import com.zrx.springCloud.service.IProductService;
import com.zrx.springCloud.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;

/**
 * @author Administrator
 * @date 2022/7/1
 * @time 16:40
 */
@RestController
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("/products/{pid}")
    public ResultVO findProduct(@PathVariable("pid") Integer pid){
        Product byPid = productService.findByPid(pid);
        return byPid!=null?ResultVO.success("获取成功！",byPid):ResultVO.failure("获取失败！");
    }
}
