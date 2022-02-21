package com.clearlove3.common.exception;

/**
 * @author clearlove3
 * @date 2022/2/21 16:11
 */
public enum BizCodeEnume {
    VALID_EXCEPTION(10001,"参数格式校验失败"),
    UNKNOWN_EXCEPTION(10000,"位置系统异常");

    private String msg;
    private int code;
    BizCodeEnume(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public int getCode(){
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
