package com.idsmanager.coremail;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName CoreMailController
 * @Author HaominYang
 * @Date 2019/3/8 13:45
 **/
@RequestMapping("/coremail/")
@Controller
public class CoreMailController {
    @RequestMapping("login")
    public void test(){
        UserAPIDemo userAPIDemo = new UserAPIDemo("http://coremail.cn");
        try {
            userAPIDemo.userLogin("yanghaomin@idsmanager.com","");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
