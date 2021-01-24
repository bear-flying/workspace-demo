package com.idsmanager.yhm_demo.web.controller;

import com.idsmanager.yhm_demo.service.UserService;
import com.idsmanager.yhm_demo.service.dto.user.UserDto;
import com.idsmanager.yhm_demo.service.dto.user.UserFormDto;
import com.idsmanager.yhm_demo.service.dto.user.UserPaginated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user/")
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "get_user_list", method = RequestMethod.GET)
    public String getUserList(UserPaginated userPaginated, Model model) {
        UserPaginated paginated = userService.getUserList(userPaginated);
        model.addAttribute("user", paginated);
        return "user_list";
    }

    @RequestMapping(value = "to_add_user")
    public String toSave(Model model) {
        model.addAttribute("userFormDto",new UserFormDto());
        return "do_add_user";
    }

    @RequestMapping(value = "do_add_user", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("userFormDto") @Valid UserFormDto userFormDto, BindingResult bindingResult) throws IOException {
        if(bindingResult.hasErrors()){
            return "do_add_user";
        }
        userService.saveUser(userFormDto);
        return "redirect:/user/get_user_list";
    }

    @RequestMapping(value = "to_update_user", method = RequestMethod.GET)
    public String toUpdate(UserDto userDto, Model model) {
        userDto = userService.toUpdate(userDto);
        model.addAttribute("userDto", userDto);
        return "do_update_user";
    }

    @RequestMapping(value = "do_update_user", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("userDto") @Valid UserDto userDto, BindingResult bindingResult) throws IOException {
        if(bindingResult.hasErrors()){
            return "do_update_user";
        }
        userService.updateUser(userDto);
        return "redirect:/user/get_user_list";
    }

    @RequestMapping(value = "reset_user", method = RequestMethod.POST)
    @ResponseBody
    public String resetPwd(UserDto userDto) {
        return userService.resetPwd(userDto);
    }

    @RequestMapping(value = "del_user", method = RequestMethod.GET)
    public String deleteUser(UserDto userDto) throws IOException {
        userService.deleteUser(userDto);
        return "redirect:/user/get_user_list";
    }


}
