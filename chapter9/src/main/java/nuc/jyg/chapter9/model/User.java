package nuc.jyg.chapter9.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 15:39 2017/9/14.
 * @Descrip
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    private int id;
    private String username;
    private String password;

}
