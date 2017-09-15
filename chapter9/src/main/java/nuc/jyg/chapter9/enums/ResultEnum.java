package nuc.jyg.chapter9.enums;

import lombok.Data;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 0:18 2017/9/15.
 * @Descrip
 */
public enum ResultEnum {

    UNKONW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    USERNAME_ILLEGALITY(100, "用户名非法"),
    PASSWORD_ILLEGALITY(101, "密码非法");

    private int code;

    private String msg;

    ResultEnum(int code, String mas) {

    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
