package com.own.microservice.provide.rfriends.circle.album.service.impl;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.own.microservice.provide.rfriends.circle.album.service.AdminService;
import org.springframework.stereotype.Service;

/**
 * @author mc
 * @version 1.0
 * @date 2018/12/17 10:19
 * @description
 */
@Service
public class AdminServiceImpl implements AdminService {

	@Override
	public void testHystrix() {

	}
}
