package com.idsmanager.script;

import com.idsmanager.commons.utils.httpclient.HttpClientPostExecutor;
import com.idsmanager.commons.utils.httpclient.HttpResponseHandler;
import com.idsmanager.commons.utils.httpclient.IDSHttpResponse;
import com.idsmanager.idp.core.dto.api.ApplicationAPIResult;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Iterator;

/**
 * @ClassName TestController
 * @Author HaominYang
 * @Date 2019/2/25 9:54
 **/
@Controller
@RequestMapping("/test/")
public class TestController {

    @RequestMapping("script")
    public void scriptTest(){
        String ehr_api_url = "https://qyapi.weixin.qq.com/cgi-bin/department/list";
        //String access_token = "3g2-i2ri2VMRaLjRBqEPFqd2j-MDOjDZt9OZ8UQJHswC3Up1NgJHrd7cQVjdA7MCMzAofch4y9tFU2zmOV6-yjyngDLkh4oXPQ9NS9MOvX6nuSfThPZDO1FDBfMSu9__oFyvzbsJXT2B6mHfIBsk7hzLTsG7XCYS_zjzqYaP-18m4J5OvpJNFX6gpx1JyMTzXn4uq5vCjgds9bxhK-keUA";
        String access_token = getToken();
        HttpClientPostExecutor postExecutor = new HttpClientPostExecutor(ehr_api_url+"?access_token="+access_token);
        postExecutor.execute(new HttpResponseHandler<ApplicationAPIResult>() {
            @Override
            public ApplicationAPIResult handleResponse(IDSHttpResponse idsHttpResponse) {
                if (!idsHttpResponse.isResponse200()) {
                    return null;
                }
                JSONObject object = JSONObject.fromObject(idsHttpResponse.responseAsString());
                if (!object.getString("errcode").equals("0")) {
                    System.out.println(object.toString());
                }
                try {
                    JSONArray jsonArray = JSONArray.fromObject(object.get("department"));
                    Iterator department_list = jsonArray.iterator();
                    EnterpriseWeChatOrganizationSCIM enterpriseWeChatOrganizationSCIM = new EnterpriseWeChatOrganizationSCIM();
                    while(department_list.hasNext()){
                        Object next = department_list.next();
                        JSONObject jsonObject = JSONObject.fromObject(next);
                        Department department = (Department)JSONObject.toBean(jsonObject, Department.class);
                            enterpriseWeChatOrganizationSCIM.setOrganization(department.getName());
                            enterpriseWeChatOrganizationSCIM.setOrganizationUuid(department.getId());
                            if(!department.getParentid().equals("0")){
                                enterpriseWeChatOrganizationSCIM.setParentUuid(department.getParentid());
                            }
                            JSONObject jsonObject1 = JSONObject.fromObject(enterpriseWeChatOrganizationSCIM);
                            pushDepartment(jsonObject1);
                    }
                } catch (Exception e) {
                    return null;
                }
                return null;
            }
        });
    }

    public void pushDepartment(JSONObject jsonObject){
            String oauthToken = getOauthToken();
            HttpClientPostExecutor postExecutor = new HttpClientPostExecutor("http://localhost:8080/api/application/scim/organization");
            postExecutor.addHeader("Content-Type", "application/json");
            postExecutor.addHeader("Authorization", oauthToken);
            HttpEntity entity = new StringEntity(jsonObject.toString(), "UTF-8");
            postExecutor.httpEntity(entity);
            postExecutor.execute(new HttpResponseHandler<ApplicationAPIResult>() {
                @Override
                public ApplicationAPIResult handleResponse(IDSHttpResponse idsHttpResponse) {
                    if (!idsHttpResponse.isResponse200()) {
                        System.out.println("");
                    }
                    JSONObject object = JSONObject.fromObject(idsHttpResponse.responseAsString());
                    if (!object.getString("errorNumber").equals("0")) {
                        System.out.println(idsHttpResponse.responseAsString());
                    }
                    return null;
                }
            });
    }

    public String getOauthToken(){
        HttpClientPostExecutor postExecutor = new HttpClientPostExecutor("http://localhost:8080/oauth/token?client_id=0d42e1b20b655a8a67aeaae4deb536aa0fYbBGNGmwo&client_secret=pkhH2Rkd7XpqDSfZXIkUcYGqVLa2yJYrqadKryp8R8&scope=read&grant_type=client_credentials");
        return postExecutor.execute(new HttpResponseHandler<String>() {
            @Override
            public String handleResponse(IDSHttpResponse idsHttpResponse) {
                if (!idsHttpResponse.isResponse200()) {
                    return null;
                }
                JSONObject object = JSONObject.fromObject(idsHttpResponse.responseAsString());
                String access_token = object.getString("token_type") + object.getString("access_token");
                return access_token;
            }
        });
    }

    public String getToken(){
        //String corpid="wwcbb98dbdfc68dbf2";
        //String corpsecret="S-Ff2lz_ghU2Z3f6VcnchkfodAlqhp7ItC7dkliIb84";
        String corpid="wwcbb98dbdfc68dbf2";
        String corpsecret="S-Ff2lz_ghU2Z3f6VcnchkfodAlqhp7ItC7dkliIb84";
        String ehr_api_url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken";
        HttpClientPostExecutor postExecutor = new HttpClientPostExecutor(ehr_api_url+"?corpid="+corpid+"&corpsecret="+corpsecret);
        return postExecutor.execute(new HttpResponseHandler<String>() {
            @Override
            public String handleResponse(IDSHttpResponse idsHttpResponse) {
                if (!idsHttpResponse.isResponse200()) {
                    return null;
                }
                JSONObject object = JSONObject.fromObject(idsHttpResponse.responseAsString());
                return object.getString("access_token");
            }
        });
    }
}
