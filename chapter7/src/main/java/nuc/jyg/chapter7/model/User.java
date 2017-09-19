package nuc.jyg.chapter7.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 16:11 2017/7/17.
 * @Descrip
 */
@Data
@AllArgsConstructor
public class User {

    private long id;
    private String username;
    private String password;
    private String uri;
}
