package com.idsmanager.sso.cas;

import com.idsmanager.sso.cas.common.HttpClientUtils;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.UUID;

/**
 * @ClassName SSOController
 * @Author HaominYang
 * @Date 2018/12/13 14:40
 **/
@Controller
@RequestMapping("/cas/sso/")
public class SSOCASController {


    //Single sign on request SSO
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String IPG2SSO(Model model, HttpServletRequest request){
        //1.接收单点登录请求,并从code参数中接收ticket
        String ticket = request.getParameter("code");
        //2.在这里进行下一步<解析ticket>并验证
        // 2.访问IPG平台去验证此次的ticket是否合法
        // {IPGServer} 为你的IPG服务器地址，例 https://jzyt.idsmanager.com
        // {applicationId} 为你创建的CAS应用的id
        String purchaseId = "jzyt-001cas3";
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        String url = "http://127.0.0.1:8080/public/api/application/cas/callback_"+purchaseId+"?code=" + ticket+"&state="+uuid;
        HttpClientUtils utils = new HttpClientUtils();
        HttpClient client = utils.warpClient();
        HttpGet get = new HttpGet(url);
        try {
            HttpResponse response = client.execute(get);
            HttpEntity entity = response.getEntity();
            InputStream content = entity.getContent();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(content));
            String backMessage = bufferedReader.readLine();
            JSONObject jsonObject = JSONObject.fromObject(backMessage);
            int code = (int) jsonObject.get("error");
            String state = (String) jsonObject.get("state");
            if(code == 0  && uuid.equals(state)){
                //1.代表合法,取出用户名,登录成功
                String username = (String)jsonObject.get("username");
                //2.如果返回的用户名业务系统数据库里的
                if(username.equalsIgnoreCase("dataBaseUsername")){
                    //3.登录成功,返回登录成功后的操作页面
                    return "redirect:/user/get_user_list";
                } else {
                    //4.否则登录失败,详情请见错误码
                    return "index";
                }
            }else {
                return "index";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ticket;
    }
}
