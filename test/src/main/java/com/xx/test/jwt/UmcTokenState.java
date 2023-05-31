package com.xx.test.jwt;

/**
 * 枚举，定义token的三种状态
 *
 */
public enum UmcTokenState {
    /**
     * 过期
     */
    EXPIRED("EXPIRED"),
    /**
     * 无效(token不合法)
     */
    INVALID("INVALID"),
    /**
     * 有效的
     */
    VALID("VALID");

    private String  state;

    private UmcTokenState(String state) {
        this.state = state;
    }

    /**
     * 根据状态字符串获取token状态枚举对象
     * @param tokenState
     * @return
     */
    public static UmcTokenState getTokenState(String tokenState){
        UmcTokenState[] states= UmcTokenState.values();
        UmcTokenState ts=null;
        for (UmcTokenState state : states) {
            if(state.toString().equals(tokenState)){
                ts=state;
                break;
            }
        }
        return ts;
    }
    public String toString() {
        return this.state;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

}
