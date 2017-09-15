package nuc.jyg.chapter9.controller;

import nuc.jyg.chapter9.dto.Result;
import nuc.jyg.chapter9.enums.ResultEnum;
import nuc.jyg.chapter9.model.User;
import nuc.jyg.chapter9.utils.ResultUtil;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 15:40 2017/9/14.
 * @Descrip
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    // 创建线程安全的Map
    static Map<Integer, User> users = Collections.synchronizedMap(new HashMap<Integer, User>());

    @GetMapping(value = "/")
    public Result<List<User>> getUserList() {
        List<User> userList = new ArrayList<User>(users.values());
        return ResultUtil.success(userList);
    }

    @GetMapping(value = "/{id}")
    public Result<User> getUser(@PathVariable Integer id) {
        return ResultUtil.success(users.get(id));
    }

    @PostMapping(value = "/")
    public Result<User> saveUser(@Valid User user, BindingResult bindingResult) throws Exception{
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(ResultEnum.UNKONW_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(users.put(user.getId(), user));
    }

    @PutMapping(value = "/{id}")
    public Result<User> updateUser(@PathVariable Integer id, @ModelAttribute User user) {
        User u = new User();
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        return ResultUtil.success(users.put(id, u));
    }

    @DeleteMapping(value = "/{id}")
    public Result<User> removeUser(@PathVariable Integer id) {
        return ResultUtil.success(users.remove(id));
    }
}
