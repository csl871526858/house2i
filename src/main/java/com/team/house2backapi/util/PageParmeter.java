package com.team.house2backapi.util;

//分页工具类
public class PageParmeter {
    private Integer page=1;  //页码
    private Integer pageSize=5; //页大小

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
