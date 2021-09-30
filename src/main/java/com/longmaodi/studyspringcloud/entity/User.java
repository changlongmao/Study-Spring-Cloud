package com.longmaodi.studyspringcloud.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

/**
 *
 * @author Chang
 * @date 2021/9/5 16:22
 **/
@Data
public class User implements java.io.Serializable {

    /** 版本号 */
    private static final long serialVersionUID = -921063982228618853L;

    /** id */
    private String id;

    private String username;

    /** rearName */
    private String rearName;

    private String password;

    private Date createTime;

    private Date updateTime;

    /** isDelete */
    private Byte isDelete;

}