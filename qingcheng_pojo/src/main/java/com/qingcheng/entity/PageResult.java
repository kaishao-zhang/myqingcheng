package com.qingcheng.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author 凯少
 * @create 2019-11-18 20:49
 */
public class PageResult<T> implements Serializable {
    private Long total;
    private List<T> rows;

    public PageResult() {
    }

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
