package com.bawei.bwboot.domain.dto.param;

import com.bawei.bwboot.domain.dto.BaseParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * user 参数传输对象
 *
 * @author Tommy
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserParam extends BaseParam {

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码MD5
     */
    private String userPassword;

    /**
     * 用户状态
     */
    private Short userState;

}
