package nuc.jyg.chapter9.controller;

import nuc.jyg.chapter9.Chapter9ApplicationTests;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @Author Nuc YongGuang Ji.
 * @Date 1:35 2017/9/16.
 * @Descrip
 */
@AutoConfigureMockMvc
public class UserControllerTest extends Chapter9ApplicationTests{

    private MockMvc mockMvc;

    @Test
    public void getUserList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("user"));
    }

}