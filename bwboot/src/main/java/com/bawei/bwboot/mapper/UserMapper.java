package com.bawei.bwboot.mapper;

import com.bawei.bwboot.domain.dto.param.UserParam;
import com.bawei.bwboot.domain.dto.result.UserResult;
import com.bawei.bwboot.domain.entity.User;
import com.bawei.bwboot.common.base.mapper.BaseMapper;
import com.bawei.bwboot.service.impl.base.PageListParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * UserMapper 用户基础信息表 Mapper
 *
 * @author Tommy
 */
@Mapper
public interface UserMapper extends BaseMapper<User, UserParam> {

    // #####################以下为自动生成的基础模板代码############################################################
    //region >>>自动生成的基础模板代码<<<

    /**
     * 基础模板 取得符合条件的 user 的记录个数
     *
     * @param param 查询条件对象
     * @return 列表数量
     */
    Long getListCount(UserParam param);

    /**
     * 基础模板 取得符合条件的 user 列表手动分页
     *
     * @param param 查询条件对象
     * @return user 列表
     */
    List<UserResult> getListPage(PageListParam param);

    /**
     * 基础模板 取得符合条件的 user 列表
     *
     * @param param 查询条件对象
     * @return user 列表
     */
    List<UserResult> getList(PageListParam param);

    //endregion
    // ^^^^^^^^^^^^^^^^^^^^^以上为自动生成的基础模板代码^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

}
