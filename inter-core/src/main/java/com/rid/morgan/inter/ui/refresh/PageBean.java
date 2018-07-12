package com.rid.morgan.inter.ui.refresh;

/**
 * Create by Morgan on 2018/7/10 0010
 * 存储分页数据
 */
public final class PageBean {

    //当前页数
    private int mPageIndex = 0;
    //总数据条数
    private int mTotal = 0;
    //一页显示的条数
    private int mPageSize = 0;
    //当前已经显示的条数
    private int mCurrentCount = 0;
    //加载延迟
    private int mDelayed = 0;

    public int getPageIndex() {
        return mPageIndex;
    }

    public PageBean setPageIndex(int mPageIndex) {
        this.mPageIndex = mPageIndex;
        return this;
    }

    public int getTotal() {
        return mTotal;
    }

    public PageBean setTotal(int mTotal) {
        this.mTotal = mTotal;
        return this;
    }

    public int getPageSize() {
        return mPageSize;
    }

    public PageBean setPageSize(int mPageSize) {
        this.mPageSize = mPageSize;
        return this;
    }

    public int getCurrentCount() {
        return mCurrentCount;
    }

    public PageBean setCurrentCount(int mCurrentCount) {
        this.mCurrentCount = mCurrentCount;
        return this;
    }

    public int getDelayed() {
        return mDelayed;
    }

    public PageBean setDelayed(int mDelayed) {
        this.mDelayed = mDelayed;
        return this;
    }

    PageBean addIndex(){
        mPageIndex++;
        return this;
    }
}
