package com.bawei.bwboot.service.impl;

import com.bawei.bwboot.common.base.pageresult.BasePageList;
import com.bawei.bwboot.common.base.pageresult.PageList;
import com.bawei.bwboot.common.enums.UserStateEnum;
import com.bawei.bwboot.common.enums.response.UserResponseEnum;
import com.bawei.bwboot.common.exception.response.ResponseException;
import com.bawei.bwboot.common.utils.CachedBeanCopier;
import com.bawei.bwboot.domain.entity.User;
import com.bawei.bwboot.mapper.UserMapper;
import com.bawei.bwboot.domain.dto.param.UserParam;
import com.bawei.bwboot.domain.dto.result.UserResult;
import com.bawei.bwboot.service.UserService;

import com.bawei.bwboot.service.impl.base.PageListByCustom;
import com.bawei.bwboot.service.impl.base.PageListByPageHelper;
import com.bawei.bwboot.service.impl.base.PageListParam;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * UserServiceImpl 用户基础信息表 Service 实现
 *
 * @author Tommy
 */
@Service("UserBaseService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    // #####################以下为自动生成的基础模板代码############################################################
    //region >>>自动生成的基础模板代码<<<

    /**
     * 基础模板 取得符合条件的记录个数
     *
     * @param param 条件dto
     * @return 符合条件的记录个数
     */
    @Override
    public Long getListCount(UserParam param) {
        return userMapper.getListCount(param);
    }

    /**
     * 基础模板 取得符合条件的记录列表不分页，但仍然被PAGE_SIZE_MAX限制
     *
     * @param param 条件dto
     * @return 符合条件的记录列表
     */
    @Override
    public List<UserResult> getList(UserParam param) {
        //虽然不分页，但必须避免请求巨大的结果集，由PAGE_SIZE_MAX限制
        param.setPageNum(BasePageList.PAGE_NUM_MIN);
        param.setPageSize(BasePageList.PAGE_SIZE_MAX);
        PageListParam<UserParam> pageListParam = new PageListParam<>(param);
        return userMapper.getList(pageListParam);
    }

    /**
     * 基础模板 取得 user 分页列表
     *
     * @param param 条件对象
     * @return 分页列表对象
     */
    @Override
    public PageList<UserResult> getListPageByCustom(UserParam param) {
        /*
        使用PageListByCustom创建分页对象，
        第一个参数：传递查询条件对象，如果需要分页，必须设置pageNum和pageSize参数；
        可以不分页，则pageNum和pageSize参数必须为空，且返回记录总数必须小于BasePageList.PAGE_SIZE_MAX，则返回符合条件的全部；
        第二个参数：设置返回符合条件记录总数的方法；
        第三个参数：设置返回符合条件列表的方法；
        上述两个方法会在PageListByCustom.Builder.builder中，根据实际需要执行。
         */
        return new PageListByCustom<>(param,
                t -> userMapper.getListCount(t),
                t -> userMapper.getListPage(t));
    }

    /**
     * 基础模板 取得 user 分页列表，通过 PageHelper
     *
     * @param param 条件对象
     * @return 分页列表对象
     */
    @Override
    public PageList<UserResult> getListPageByPageHelper(UserParam param) {
        /*
        使用PageListByPageHelper创建分页对象，
        第一个参数：传递查询条件对象，必须设置pageNum和pageSize参数；
        第二个参数：设置返回符合条件列表的方法；
        此方法自动调用PageHelper完成分页，并自动填充分页结果。
         */
        return new PageListByPageHelper<>(param, t -> userMapper.getList(t));
    }

    /**
     * 基础模板 添加 user
     * 本项目不使用数据库自增字段，因此避免使用任何与自增相关的方法
     * 本项目必须使用snowflakeId生产全局ID
     * 此方法自动生成 id、gmtCreate、gmtModified
     * 传入的添加对象应该确保 id、gmtCreate、gmtModified 为空
     *
     * @param param 要添加的对象
     * @return 影响行数
     */
    @Override
    public int insertSelective(UserParam param) {
        if (param.getUserPassword() != null) {
            param.setUserPassword(DigestUtils.md5Hex(param.getUserPassword()));
        }
        return userMapper.insertSelectiveGenerate(param, User.class);
    }

    /**
     * 基础模板 添加 user
     * 本项目不使用数据库自增字段，因此避免使用任何与自增相关的方法
     * 本项目必须使用 snowflakeId 生产全局ID
     * 此方法要求传入主键 id 值，自动生成 gmtCreate、gmtModified
     * 使用场景：对于某类信息的扩展表，主键id和主表的id保持一致，则不用生成id，直接拿主表id值来添加
     * 传入的添加对象应该确保 id 有值，gmtCreate、gmtModified 为空
     *
     * @param param 要添加的对象
     * @return 影响行数
     */
    @Override
    public int insertWithIdSelective(UserParam param) {
        if (param.getUserPassword() != null) {
            param.setUserPassword(DigestUtils.md5Hex(param.getUserPassword()));
        }
        return userMapper.insertWithIdSelectiveGenerate(param, User.class);
    }

    /**
     * 基础模板 编辑 user 利用Weekend传递条件参数，此处传主键id
     * 这是一个例子，主要是演示Weekend条件用法，具体业务请仿照此例子添加新方法
     *
     * @param param 要更新的记录
     * @param id    要更新的主键id值
     * @return 数据库执行完毕影响的行数
     */
    @Override
    public int updateSelective(UserParam param, long id) {
        if (param.getUserPassword() != null) {
            param.setUserPassword(DigestUtils.md5Hex(param.getUserPassword()));
        }
        Weekend<User> weekend = new Weekend<>(User.class);
        WeekendCriteria<User, Object> criteria = weekend.weekendCriteria();
        criteria.andEqualTo(User::getId, id);
        /// 如果需要更复杂的带括号的逻辑条件，可以用如下方式组合条件
        /// WeekendCriteria<User, Object> criteria1 = weekend.createCriteriaAddOn();
        /// criteria1.andEqualTo(User::getId, id).orGreaterThan(User::getId, id);
        /// weekend.and(criteria1);
        return userMapper.updateByWeekendSelectiveGenerate(param, User.class, weekend);
    }

    /**
     * 基础模板 编辑 user 通过主键id，id直接包含在传参对象内
     *
     * @param param 要更新的记录
     * @return 数据库执行完毕影响的行数
     */
    @Override
    public int updateByIdSelective(UserParam param) {
        if (param.getUserPassword() != null) {
            param.setUserPassword(DigestUtils.md5Hex(param.getUserPassword()));
        }
        return userMapper.updateByPrimaryKeySelectiveGenerate(param, User.class);
    }

    //endregion
    // ^^^^^^^^^^^^^^^^^^^^^以上为自动生成的基础模板代码^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

    /**
     * 解开 user token 后，检查用户是否有效
     *
     * @param id         userId
     * @param createTime Token创建时间
     * @return 用户是否有效
     */
    @Override
    public boolean isUserEnable(long id, Date createTime) {
        Weekend<User> weekend = new Weekend<>(User.class);
        WeekendCriteria<User, Object> criteria = weekend.weekendCriteria();
        // id必须存在
        criteria.andEqualTo(User::getId, id);
        // 用户状态为有效
        criteria.andEqualTo(User::getUserState, UserStateEnum.ENABLE.code());
        return userMapper.selectCountByExample(weekend) == 1;
    }

    /**
     * 用户登录
     *
     * @param loginName 登录名，可能为手机号码、用户名、用户email
     * @param password 用户密码
     * @return 用户Id
     * @throws ResponseException 用户操作相关异常
     */
    @Override
    public long getIdByLoginWithPassword(String loginName, String password) throws ResponseException {
        Weekend<User> weekend = new Weekend<>(User.class);
        WeekendCriteria<User, Object> criteria = weekend.weekendCriteria();
        criteria.orEqualTo(User::getMobile, loginName);
        criteria.orEqualTo(User::getUserName, loginName);
        List<User> userList = userMapper.selectByExample(weekend);
        User user;
        if (userList.size() == 0) {
            // 用户不存在
            throw new ResponseException(UserResponseEnum.USER_NOT_EXIST);
        } else {
            user = userList.get(0);
            // 用户被禁用
            if (user.getUserState().equals(UserStateEnum.DISABLE.code())) {
                throw new ResponseException(UserResponseEnum.USER_DISABLE);
            }
            // 密码错误
            String pd = DigestUtils.md5Hex(password);
            if (!pd.equals(user.getUserPassword())) {
                throw new ResponseException(UserResponseEnum.PASSWORD_ERROR);
            }
        }
        return user.getId();
    }

    /**
     * 通过 id 获取用户信息
     * @param id 用户id
     * @return 用户信息
     */
    @Override
    public UserResult getUserById(long id) {
        User ub = userMapper.selectByPrimaryKey(id);
        if (ub == null) {
            return null;
        } else {
            // 去掉敏感信息
            ub.setUserPassword(null);
            return CachedBeanCopier.copyToNew(ub, UserResult.class);
        }
    }

}
