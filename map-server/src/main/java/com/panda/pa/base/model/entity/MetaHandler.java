/*
package com.jjyuan.map.base.model.entity;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.jjyuan.rmcs.config.shiro.service.ShiroService;
import com.jjyuan.rmcs.module.entity.sys.TAdminUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

*/
/**
 * @Auther: wl
 * @Date: 2020/3/2 10:40
 * @Description: 处理新增和更新的基础数据填充，配合BaseEntity和MyBatisPlusConfig使用
 *//*

@Slf4j
@Component
public class MetaHandler implements MetaObjectHandler {


    @Resource
    ShiroService shiroService;
    */
/**
     * 新增数据执行
     * @param metaObject
     *//*

    @Override
    public void insertFill(MetaObject metaObject) {
        TAdminUser user = null;
        try {
            user = shiroService.getCurrentUser();
            this.setInsertFieldValByName("createBy", user.getUsername(), metaObject);

        } catch (Exception e) {
            log.error("获取登录用户失败");
        }
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }

    */
/**
     * 更新数据执行
     * @param metaObject
     *//*

    @Override
    public void updateFill(MetaObject metaObject) {
        TAdminUser user = null;
        try {
            user = shiroService.getCurrentUser();
            this.setInsertFieldValByName("updateBy", user.getUsername(), metaObject);

        } catch (Exception e) {
            log.error("获取登录用户失败");
        }
        this.setFieldValByName("updateTime", new Date(), metaObject);

    }
}
*/
