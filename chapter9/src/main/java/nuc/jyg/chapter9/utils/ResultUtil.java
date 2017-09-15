package nuc.jyg.chapter9.utils;

import nuc.jyg.chapter9.dto.Result;
import nuc.jyg.chapter9.enums.ResultEnum;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 18:08 2017/9/14.
 * @Descrip
 */
public class ResultUtil {

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
