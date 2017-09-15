package nuc.jyg.chapter9.handle;

import nuc.jyg.chapter9.dto.Result;
import nuc.jyg.chapter9.enums.ResultEnum;
import nuc.jyg.chapter9.exception.UserException;
import nuc.jyg.chapter9.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 23:07 2017/9/14.
 * @Descrip
 */
@ControllerAdvice
public class ExceptionHandle {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof UserException) {
            UserException userException = (UserException) e;
            return ResultUtil.error(userException.getCode(), userException.getMessage());
        } else {
            logger.error(" [系统异常] {} ", e);
            return ResultUtil.error(ResultEnum.UNKONW_ERROR.getCode(), e.getMessage());
        }
    }
}
