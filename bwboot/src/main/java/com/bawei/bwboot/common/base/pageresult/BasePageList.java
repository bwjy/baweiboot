package com.bawei.bwboot.common.base.pageresult;

import java.util.List;

/**
 * 实现了 PageList 接口，同时定义了分页用到的的基本常量
 * 详情见 PageList 接口
 *
 * @param <R> 结果类型
 * @author Tommy
 */
public abstract class BasePageList<R> implements PageList<R> {

    /**
     * 请求页码的最小值
     */
    public static final int PAGE_NUM_MIN = 1;

    /**
     * 请求页码的最大值
     */
    public static final int PAGE_NUM_MAX = 100000;

    /**
     * 每页请求数量的最小值
     */
    public static final int PAGE_SIZE_MIN = 1;

    /**
     * 每页请求数量的最大值
     */
    public static final int PAGE_SIZE_MAX = 1000;

    /**
     * 请求的页码
     */
    @Override
    public Integer getRequestPageNum() {
        return requestPageNum;
    }

    /**
     * 请求的每页数量
     */
    @Override
    public Integer getRequestPageSize() {
        return requestPageSize;
    }

    /**
     * 分页数据
     */
    @Override
    public List<R> getList() {
        return list;
    }

    /**
     * 符合条件的记录总数
     */
    @Override
    public Long getTotal() {
        return total;
    }

    /**
     * 当前的页码
     */
    @Override
    public Integer getPageNum() {
        return pageNum;
    }

    /**
     * 总页数
     */
    @Override
    public Integer getPages() {
        return pages;
    }

    /**
     * 请求的页码
     */
    protected Integer requestPageNum;

    /**
     * 请求的每页数量
     */
    protected Integer requestPageSize;

    /**
     * 分页数据
     */
    protected List<R> list;

    /**
     * 符合条件的记录总数
     */
    protected Long total;

    /**
     * 当前的页码
     */
    protected Integer pageNum;

    /**
     * 总页数
     */
    protected Integer pages;

}
