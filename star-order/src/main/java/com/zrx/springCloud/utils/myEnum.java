package com.zrx.springCloud.utils;

/**
 * @author Administrator
 * @date 2022/7/6
 * @time 10:49
 */
public enum myEnum {
    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);
    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private myEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }



    //覆盖方法
    @Override
    public String toString() {
        return this.index+"_"+this.name;
    }

    public Integer getIndex() {
        return this.index;
    }
}
