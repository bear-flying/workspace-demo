package com.idsmanager.yhm_demo.infrastructure.company;


import com.idsmanager.yhm_demo.service.dto.user.UserFormDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
class UserFormDtoValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return UserFormDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        UserFormDto userFormDto = (UserFormDto) o;

        if (userFormDto.getUsername().length() < 6) {
            errors.rejectValue("username", null, "用户名长度至少6位！");
        }
        if (userFormDto.getPassword() == null) {
            errors.rejectValue("password", null, "密码不能为空！");
        }
        if (userFormDto.getPassword().length() < 8) {
            errors.rejectValue("password", null, "密码长度至少8位!");
        }
        if (!userFormDto.getRePassword().equals(userFormDto.getPassword())) {
            errors.rejectValue("rePassword", null, "确认密码必须跟密码保持一致!");
        }
        if (userFormDto.getPrivileges() == null || userFormDto.getPrivileges().size() == 0) {
            errors.rejectValue("privileges", null, "权限至少勾选一个！");
        }
    }
}
