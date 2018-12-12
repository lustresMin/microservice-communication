package com.own.microservice.consumer.web.controller;

import com.own.microservice.consumer.web.service.TestRemoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;

import static org.springframework.http.ResponseEntity.ok;


/**
 * @description:
 * @author: 马伟鸿
 * @createDate: 2018/7/1 11:11
 * @version: 1.0
 */

@CrossOrigin
@RestController
@RequestMapping("/consumer/activityComments/")
@Api(tags = "活动评论API--马伟鸿")
public class TestRemoteServiceController {


    @Resource
    private TestRemoteService activityCommentsRemoteService;



    @PostMapping("findCommentsByActivityId")
    @ApiOperation(value = "根据活动id查询评论 APP活动结束后的评论加载")
    @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header")
    public ResponseEntity findCommentsByActivityId(

    @ApiParam(value = "第几页") @RequestParam(value = "page",required = false) Integer page,
    @ApiParam(value = "多少条")@RequestParam(value = "size",required = false) Integer size,
    @RequestParam(value = "sort",required = false) String sort,
    @ApiParam (value = "活动id", required = true) @RequestParam(value = "id") Integer id) {
        return ok(activityCommentsRemoteService.findCommentsByActivityId(page, size, sort, id));
    }

    @PostMapping("insert")
    @ApiOperation(value = "新增 APP活动结束后的添加评论")
    @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header")
    public ResponseEntity save(@RequestBody ActivityComments activityComments,
                               @ApiParam(hidden = true)@FusionUser Integer userId) {
        return ok(activityCommentsRemoteService.insert(activityComments,userId));
    }

    @PostMapping("update")
    @ApiOperation(value = "修改")
    @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header")
    public ResponseEntity update(@RequestBody ActivityComments activityComments,
                                 @ApiParam(hidden = true)@FusionUser Integer userId) {
        return ok(activityCommentsRemoteService.update(activityComments,userId));
    }

    @PostMapping("deleteInBatch")
    @ApiOperation(value = "批量删除")
    @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header")
    public ResponseEntity deleteInBatch(@RequestBody List<ActivityComments> activityCommentsList,
                                        @ApiParam(hidden = true)@FusionUser Integer userId) {
        return ok(activityCommentsRemoteService.deleteInBatch(activityCommentsList,userId));
    }

    @PostMapping("deleteById")
    @ApiOperation(value = "根据主键删除")
    @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header")
    public ResponseEntity deleteGetById(@ApiParam(value = "主键",required = true)@RequestParam(value = "id") Integer id,
                                        @ApiParam(hidden = true)@FusionUser Integer userId) {
        return ok(activityCommentsRemoteService.deleteGetById(id,userId));
    }

    @GetMapping("findOne")
    @ApiOperation(value = "根据主键查询")
    @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header")
    public ResponseEntity findOne(@ApiParam(value = "主键",required = true)@RequestParam(value = "id") Integer id) {
        return ok(activityCommentsRemoteService.findOne(id));
    }

    @PostMapping("pageQuery")
    @ApiOperation(value = "条件分页查询")
    @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header")
    public ResponseEntity pageQuery(@ApiParam(value = "第几页", required = true) @RequestParam(value = "page") Integer page,
                                    @ApiParam(value = "多少条",required = true)@RequestParam(value = "size") Integer size,
                                    @ApiParam(value = "排序字段,暂时未启用,传空串")@RequestParam(value = "sort",required = false) String sort,
                                    @RequestBody ActivityComments activityComments) {
        return ok(activityCommentsRemoteService.pageQuery(page, size, sort, activityComments));
    }
}
