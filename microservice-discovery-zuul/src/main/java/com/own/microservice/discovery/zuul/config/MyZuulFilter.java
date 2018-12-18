package com.own.microservice.discovery.zuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

/**
 * @author mc
 * @version 1.0
 * @date 2018/12/18 11:11
 * @description 服务过滤配置
 */
//@Slf4j
//@Configuration
public class MyZuulFilter extends ZuulFilter {

	/**
	 * 过滤类型
	 * 此处可采用枚举或yml文件初始化来进行配置
	 * 返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型：
	 * pre：路由之前
	 * routing：路由之时
	 * post： 路由之后
	 * error：发送错误调用
	 * @return
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * 过滤顺序
	 * 此处可采用枚举或yml文件初始化来进行配置
	 * @return
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

	/**
	 * 过滤的内容
	 * 这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
	 * @return 返回true
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 实际业务代码
	 * @return
	 * @throws ZuulException
	 */
	@Override
	public Object run() throws ZuulException {
		//获取当前请求上下文
		RequestContext ctx = RequestContext.getCurrentContext();
		//获取请求域
		HttpServletRequest request = ctx.getRequest();
//		log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));

		//具体业务逻辑
		// todo
		return null;
	}
}
