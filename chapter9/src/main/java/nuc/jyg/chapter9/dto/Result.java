package nuc.jyg.chapter9.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import nuc.jyg.chapter9.enums.ResultEnum;

import java.io.Serializable;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 18:11 2017/9/14.
 * @Descrip
 */
@Data
@NoArgsConstructor
public class Result<T> implements Serializable {

    /**
     * 状态码.
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;

}
