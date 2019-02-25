package com.bawei.bwboot.domain.dto.result;

import com.bawei.bwboot.domain.dto.BaseResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * user 结果传输对象
 *
 * @author Tommy
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserResult extends BaseResult {

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
