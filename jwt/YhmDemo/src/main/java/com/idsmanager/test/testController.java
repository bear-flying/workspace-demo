package com.idsmanager.test;

import com.idsmanager.commons.utils.httpclient.HttpClientPostExecutor;
import com.idsmanager.commons.utils.httpclient.HttpResponseHandler;
import com.idsmanager.commons.utils.httpclient.IDSHttpResponse;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @ClassName testController
 * @Author HaominYang
 * @Date 2019/1/8 18:17
 **/
@RequestMapping("/api")
public class testController implements HttpResponseHandler<String> {
    @RequestMapping("/list")
    public void getOrgList(){
        String corp_name = "IDaas";
        String app_id = "3";
        String app_secret = "bf5d3a47cd66fd7c974b1285694aac88";
        Date date = new Date();
        long timestamp = date.getTime();
        System.out.println(timestamp);
        String str = corp_name + app_id + app_secret + timestamp;
        String token = SHA256Util.getSHA256Str(str);
        System.out.println(token);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("app_id", app_id);
        jsonObject.put("corp_name", corp_name);
        jsonObject.put("timestamp", timestamp);
        jsonObject.put("token", token);


        HttpClientPostExecutor postExecutor = new HttpClientPostExecutor("https://dev015.cxyhr.cn/org/list");
        postExecutor.contentType("application/json");
        HttpEntity entity = new StringEntity(jsonObject.toString(), "UTF-8");
        postExecutor.httpEntity(entity);
        String result = postExecutor.execute(this);
    }
    @Override
    public String handleResponse(IDSHttpResponse idsHttpResponse) {
        if(idsHttpResponse.isResponse200()){
            String resultMsg = idsHttpResponse.responseAsString();
            return resultMsg;
        }
        return null;
    }
}
