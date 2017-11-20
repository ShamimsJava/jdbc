package com.shamim.domain;

public class Students {
    private int stId;
    private String stName;

    public Students(int stId, String stName) {
        this.stId = stId;
        this.stName = stName;
    }

    public int getStId() {
        return stId;
    }

    public String getStName() {
        return stName;
    }
}
