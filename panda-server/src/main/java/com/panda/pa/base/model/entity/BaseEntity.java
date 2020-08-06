package com.panda.pa.base.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: wl
 * @Date: 2020/3/2 10:38
 * @Description: 实体基类
 */
@Data
public class BaseEntity implements Serializable {

    @TableField(value = "create_by", fill = FieldFill.INSERT) // 新增执行
    private String createBy;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE) // 新增和更新执行
    private String updateBy;

    @TableField(value = "update_Time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField(value = "remark")
    private String remark;
}
