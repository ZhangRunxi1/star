package com.zrx.springCloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Administrator
 * @date 2022/7/13
 * @time 15:26
 */
@Component
public class FooFilter extends ZuulFilter {

    /**
     * filterType()方法用于告诉Zuul，该过滤器是
     * 前置过滤器、路由过滤器还是后置过滤器
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * filterOrder()方法返回一个整数值，定义过滤器的执行顺序
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * shouldFilter()方法返回一个布尔值来指示该
     * 过滤器是否要执行
     */
    public boolean shouldFilter() {
        return true;
    }

    /**
     * run()方法用于编写当前过滤器的主要逻辑
     */
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println("前置过滤器: " + request.getMethod() + ", " + request.getRequestURL().toString());
        return null;
    }
}