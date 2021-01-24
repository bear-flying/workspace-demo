package com.idsmanager.sso.tmc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName TMCccontroller
 * @Author HaominYang
 * @Date 2018/12/19 19:08
 **/
@Controller
@RequestMapping("/tmc/sso/")
public class TMCController {
    @RequestMapping("login")
    public String tmcLogin(Model model){
        Date ss = new Date();
        SimpleDateFormat format0 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String time = format0.format(ss);//这个就是把时间戳经过处理得到期望格式的时间
        System.out.println("格式化结果0：" + time);
        String CustomerId = "39573";
        String UserName = "test7";
        String Timestamp =time;
        String Signature = "39573"+"test7"+Timestamp+"d15eced839c94d83a2589a88d812760b";
        String md5Signature = MD5Util.md5(Signature).toLowerCase();
        System.out.println(Timestamp);
        System.out.println(md5Signature);
        model.addAttribute("CustomerId",CustomerId);
        model.addAttribute("UserName",UserName);
        model.addAttribute("Timestamp",Timestamp);
        model.addAttribute("Signature",md5Signature);
        return "tmc_login";
    }
    @RequestMapping("test")
    public void test()throws IOException{
        /*String postParam = "username=yanghaomin";
        URL url = null;
        try {
            url = new URL("https://dbc.idpsso.net:8040/api/application/portal/sms/send_code");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");// 提交模式
            // conn.setConnectTimeout(10000);//连接超时 单位毫秒
            // conn.setReadTimeout(2000);//读取超时 单位毫秒
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data");
            httpURLConnection.setRequestProperty("Authorization", "bearer90858dde-54df-4777-a144-1c0bac56bf09");
            httpURLConnection.setUseCaches(false);
            // 发送POST请求必须设置如下两行
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
            // 发送请求参数
            printWriter.write(postParam);//post的参数 xx=xx&yy=yy
            // flush输出流的缓冲
            printWriter.flush();
            //开始获取数据
            BufferedInputStream bis = new BufferedInputStream(httpURLConnection.getInputStream());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len;
            byte[] arr = new byte[1024];
            while((len=bis.read(arr))!= -1){
                bos.write(arr,0,len);
                bos.flush();
            }
            bos.close();
            String s = bos.toString("utf-8");
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        // Post请求的url，与get不同的是不需要带参数
        URL postUrl = new URL("http://localhost:8080/api/application/portal/sms/send_code");
        // 打开连接
        HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
        // 设置是否向connection输出，因为这个是post请求，参数要放在
        // http正文内，因此需要设为true
        connection.setDoOutput(true);
        // Read from the connection. Default is true.
        connection.setDoInput(true);
        // 默认是 GET方式
        connection.setRequestMethod("POST");
        // Post 请求不能使用缓存
        connection.setUseCaches(false);
        //设置本次连接是否自动重定向
        connection.setInstanceFollowRedirects(true);
        // 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的
        // 意思是正文是urlencoded编码过的form参数
        connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        connection.setRequestProperty("Authorization", "bearer5118893f-0579-4542-bb3a-47ace468b2be");
        // 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成，
        // 要注意的是connection.getOutputStream会隐含的进行connect。
        connection.connect();
        DataOutputStream out = new DataOutputStream(connection
                .getOutputStream());
        // 正文，正文内容其实跟get的URL中 '? '后的参数字符串一致
        String content = "username=" + URLEncoder.encode("yanghaomin", "UTF-8");
        // DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写到流里面
        out.writeBytes(content);
        //流用完记得关
        out.flush();
        out.close();
        //获取响应
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null){
            System.out.println(line);
        }
        reader.close();
        //该干的都干完了,记得把连接断了
        connection.disconnect();
    }

    public static void main(String[] args) {
        String email = "yanghaomin@163.com";
        String hiddenEmail = email.replaceAll("(\\w?)(\\w+)(\\w)(@\\w+\\.[a-z]+(\\.[a-z]+)?)",
                "$1****$3$4");
        System.out.println(hiddenEmail);
        String username = "yanghaomin";
        String hiddenUsername = username.replaceAll("(\\w)(\\w+)(\\w)",
                "$1****$3");
        System.out.println(hiddenUsername);
    }
}
