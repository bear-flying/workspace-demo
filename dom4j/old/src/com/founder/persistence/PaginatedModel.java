package com.founder.persistence;

public class PaginatedModel {

    protected int startNumber = 0;
    protected int endNumber = 0;
    
    public int getEndNumber() {
        return endNumber;
    }
    public void setEndNumber(int end) {
        this.endNumber = end;
    }
    public int getStartNumber() {
        return startNumber;
    }
    public void setStartNumber(int start) {
        this.startNumber = start;
    }
    
    public void setPageInfo(int pageSize, int currentPage) {
        this.startNumber = (currentPage - 1) * pageSize + 1;
        this.endNumber = currentPage * pageSize;
    }
}
