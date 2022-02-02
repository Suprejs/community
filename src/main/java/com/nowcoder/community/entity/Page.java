package com.nowcoder.community.entity;

/*
* 用于封装分页的相关信息
* */
public class Page {
    //当前页面
    private int current = 1;

    //单页显示上限
    private int limit = 10;

    //数据的总数，从服务端查询出来，用于计算总的页数
    private int rows;

    //查询路径,复用分页的链接
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if (current > 1) {//当前页面的合法判断
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit >= 1 && limit <= 100) {//页面数据数的合法判断
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if(rows >= 1){//数据总数的合法性判断
            this.rows = rows;
        }

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getOffset(){//获取当前页的起始行
        return (current - 1) * limit;

    }

    public int getTotal(){//获取总的页数
        if(rows % limit == 0) {
            return rows / limit;
        }else
        {
            return rows / limit + 1;
        }
    }

    public int getFrom(){//获取页码显示的起始页，为当前页-2
        int from = current - 2;
        return from < 1 ? 1 : from;
    }

    public int getTo(){//获取页码显示的结束页，为当前页+2
        int to = current + 2;
        int total = getTotal();
        return to > total ? total : to;
    }
}
