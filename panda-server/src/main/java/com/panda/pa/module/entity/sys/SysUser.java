package com.panda.pa.module.entity.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户管理表
 * </p>
 *
 * @author wl
 * @since 2020-08-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 账号名称
     */
    private String userName;

    /**
     * 真实姓名
     */
    private String userRelName;

    /**
     * 密码 操作员用户密码为空
     */
    private String userPwd;

    /**
     * 电话
     */
    private String accTel;

    /**
     * 电子邮件
     */
    private String accEmail;

    /**
     * 手机号
     */
    private String accPhone;

    /**
     * 生日
     */
    private String accBirthday;

    /**
     * 性别（1男 2女）
     */
    private Integer accSex;

    /**
     * 登录错误次数 最多尝试5次
     */
    private Integer accErrLogNum;

    /**
     * 登录错误时间
     */
    private Long accErrLogTime;

    /**
     * 用户类型
     */
    private Integer userType;

    /**
     * 用户来源 1.内部自建用户 2.外部用户
     */
    private Integer userSource;

    /**
     * 组织机构编码
     */
    private String ouCode;

    /**
     * 组织机构名称
     */
    private String ouName;

    /**
     * 用户状态 0.未冻结 1.冻结
     */
    private Integer userStatus;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 删除标记 0.未删除 1.删除
     */
    private Integer del;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 修改人
     */
    private String updatedBy;

    /**
     * 修改时间
     */
    private LocalDateTime updatedTime;

    /**
     * 最后登录时间
     */
    private LocalDateTime lastLoginTime;


}
