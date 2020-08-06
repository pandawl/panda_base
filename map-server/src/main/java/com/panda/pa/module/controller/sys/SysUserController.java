package com.panda.pa.module.controller.sys;


import com.panda.pa.base.aop.SysLog;
import com.panda.pa.base.model.controller.BaseController;
import com.panda.pa.module.service.sys.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户管理表 前端控制器
 * </p>
 *
 * @author wl
 * @since 2020-08-06
 */
@Slf4j
@RestController
@Api(description = "用户管理")
@RequestMapping("/sysUser")
public class SysUserController extends BaseController {

    @Autowired
    SysUserService userService;

    @ApiOperation(value = "用户列表", notes = "用户列表")
    @SysLog(content = "用户列表")
    @GetMapping("/list")
    public Object selectUserList(String ouCode) {

        //查询电量
        if (StringUtils.isNotEmpty(ouCode)){
            //查询省
            return ok("cha");

        }else {
            //查询市
            return ok("cha");
        }
    }
}
