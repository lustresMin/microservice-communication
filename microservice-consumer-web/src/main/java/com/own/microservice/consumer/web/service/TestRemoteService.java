package com.own.microservice.consumer.web.service;

import com.own.microservice.common.jackson.Result;
import com.own.microservice.consumer.web.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author:         马伟鸿
 * @createDate:     2018/7/1 11:11
 * @version:        1.0
 */

@FeignClient(name = "provider-functional",configuration = FeignConfig.class)
@RequestMapping("/activityComments/")
public interface TestRemoteService {

    /**
     * 根据活动id查询评论
     * @return
     */
    @PostMapping("findCommentsByActivityId")
	Result findCommentsByActivityId(
			@RequestParam(value = "page") Integer page,
			@RequestParam(value = "size") Integer size,
			@RequestParam(value = "sort") String sort,
			@RequestParam(value = "id") Integer id);


    /**
     * 新增
     * @return
     */
    @PostMapping("insert")
    Result insert(@RequestBody ActivityComments activityComments, @RequestParam(value = "userId") Integer userId);
    /**
     * 修改
     * @return
     */
    @PostMapping("update")
    Result update(@RequestBody ActivityComments activityComments, @RequestParam(value = "userId") Integer userId);
    /**
     * 批量删除
     * @return
     */
    @PostMapping("deleteInBatch")
    Result deleteInBatch(@RequestBody List<ActivityComments> activityCommentsList, @RequestParam(value = "userId") Integer userId);
    /**
     * 根据主键删除
     * @return
     */
    @PostMapping("getById")
    Result deleteGetById(@RequestParam(value = "id") Integer id, @RequestParam(value = "userId") Integer userId);
    /**
     * 根据主键查询
     * @return
     */
    @GetMapping("findOne")
    Result findOne(@RequestParam(value = "id") Integer id);
    /**
     * 条件分页查询
     * @return
     */
    @PostMapping("pageQuery")
    Result pageQuery(@RequestParam(value = "page") Integer page,
					 @RequestParam(value = "size") Integer size,
					 @RequestParam(value = "sort") String sort,
					 @RequestBody ActivityComments activityComments);
}
