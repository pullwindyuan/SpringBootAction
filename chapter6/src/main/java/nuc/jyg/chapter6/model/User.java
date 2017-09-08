package nuc.jyg.chapter6.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 13:23 2017/8/23.
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
