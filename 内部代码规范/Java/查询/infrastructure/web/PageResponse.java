

package lol.redScarf.yjdf.openapi.infrastructure.web;


import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 分页响应对象基类，定义了所有有关分页的信息。<br/>
 * 所有的分页响应对象都需要继承该类。
 */

public class PageResponse<T> implements Serializable {
    private List<T> list;

    public PageResponse() {
        super();
    }

    public PageResponse(List<T> list, long pageIndex, long pageSize, long pages, long count) {
        this.list = list;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.pages = pages;
        this.count = count;
    }

    public List<T> getList() {
        return list;
    }

    public PageResponse<T> setList(List<T> list) {
        this.list = list;
        return this;
    }

    /**
     * 当前页码
     */
    private long pageIndex;

    /**
     * 当前页的真实记录数
     */
    private long pageSize;

    /**
     * 总页数
     */
    private long pages;

    /**
     * 总记录数
     */
    private long count;

    /**
     * 获取当前页码
     *
     * @return 当前页码
     */
    public long getPageIndex() {
        return pageIndex;
    }

    /**
     * 设置当前页码
     *
     * @param pageIndex 当前页面
     */
    public void setPageIndex(long pageIndex) {
        this.pageIndex = pageIndex;
    }

    /**
     * 获取当前页的真实记录数
     *
     * @return 当前页的真实记录数
     */
    public long getPageSize() {
        return pageSize;
    }

    /**
     * 设置当前页的真实记录数
     *
     * @param pageSize 当前页的真实记录数
     */
    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取总页数
     *
     * @return 总页数
     */
    public long getPages() {
        return pages;
    }

    /**
     * 设置总页数
     *
     * @param pages 总页数
     */
    public void setPages(long pages) {
        this.pages = pages;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public <R> PageResponse<R> convert(Function<? super T, ? extends R> mapper) {
        if (CollectionUtils.isEmpty(this.getList())) {
            return ((PageResponse<R>) this);
        }
        List<R> collect = (List) this.getList().stream().map(mapper).collect(Collectors.toList());
        return ((PageResponse<R>) this).setList(collect);
    }

    public static <R> PageResponse<R> fromIPage(IPage<R> ipage) {
        return new PageResponse<R>(ipage.getRecords(), ipage.getCurrent(), ipage.getSize(), ipage.getPages(), ipage.getTotal());
    }

}
