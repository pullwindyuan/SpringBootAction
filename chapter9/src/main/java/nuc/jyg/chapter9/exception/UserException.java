package nuc.jyg.chapter9.exception;

import lombok.Data;
import nuc.jyg.chapter9.enums.ResultEnum;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 23:37 2017/9/14.
 * @Descrip
 */
@Data
public class UserException extends RuntimeException {

    private Integer code;

    public UserException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

}
