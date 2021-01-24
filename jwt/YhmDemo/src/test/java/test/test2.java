package test;

import org.apache.commons.lang.StringUtils;

/**
 * @ClassName test2
 * @Author HaominYang
 * @Date 2019/2/19 10:36
 **/
public class test2 {
    //邮箱校验规则
    public final static String EMAIL_REGEX = "^(\\w?)(\\w+)(\\w)(@\\w+\\.[a-z]+(\\.[a-z]+)?)$";

    //用户名校验规则
    public final static String USERNAME_REGEX = "^(\\w)(\\w+)(\\w)$";

    /**
     * 邮箱名正则使用*号隐藏部分
     */
    public static String hideEmail(String email){
        if(StringUtils.isBlank(email) && email.matches(EMAIL_REGEX)){
            email.replaceAll(EMAIL_REGEX,
                    "$1****$3$4");
        }
        return email;
    }

    /**
     * 用户名正则使用*号隐藏部分
     */
    public static String hideUsername(String username){
        if(StringUtils.isBlank(username) && username.matches(USERNAME_REGEX)){
            username.replaceAll(USERNAME_REGEX,
                    "$1****$3");
        }
        return username;
    }

    public static void main(String[] args) {
        String str1 = "1211285001@qq.com";
        String str2 = "yanghaomin";
        System.out.println(str1.replaceAll(EMAIL_REGEX,
                "$1****$3$4"));
        System.out.println(str2.replaceAll(USERNAME_REGEX,
                "$1****$3"));
        String hideEmail = hideEmail("1211285001@qq.com");
        System.out.println(hideEmail);
        String username = hideUsername("yanghaomin");
        System.out.println(username);
    }
}
