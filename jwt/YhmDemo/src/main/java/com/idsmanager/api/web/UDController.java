package com.idsmanager.api.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @ClassName UDController
 * @Author HaominYang
 * @Date 2018/12/14 15:25
 **/
@Controller
@RequestMapping("/api/scim/")
public class UDController{

    @RequestMapping(value = "account", method = RequestMethod.POST)
    public void account() {

    }
}
