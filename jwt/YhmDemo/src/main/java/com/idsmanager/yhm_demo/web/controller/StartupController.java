package com.idsmanager.yhm_demo.web.controller;

import com.idsmanager.commons.web.WebUtils;
import com.idsmanager.yhm_demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 2016/1/19
 *
 * @author Shengzhao Li
 */
@Controller
public class StartupController {

    private static final Logger LOG = LoggerFactory.getLogger(StartupController.class);


    @Autowired
    private UserService userService;


    @RequestMapping(value = {"/index", "/"})
    public String dashboard(Model model) {

        return "index";
    }


    @RequestMapping("login")
    public String login() {
        return "login";
    }


    /*
 * When the firstly initial system, create a super-admin account
 */
    @RequestMapping(value = "/public/initial_user", method = RequestMethod.GET)
    @ResponseBody
    public String initialUser() {
        LOG.info("Call 'initialUser' from IP: {}", WebUtils.getIp());
        return userService.initialDefaultUser();
    }


}
