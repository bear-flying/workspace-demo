package cn.itcast.test;

import cn.itcast.pojo.Brand;
import cn.itcast.pojo.Item;
import cn.itcast.pojo.User;
import cn.itcast.utils.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressWarnings("all")
public class DataTest {

    private static RestTemplate restTemplate = new RestTemplate(new SimpleClientHttpRequestFactory());
/*

    public static void main(String[] args) throws JsonProcessingException {

        ExecutorService executorService = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10000000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        operateUserModule();
                        operateItemModule();
                        operateBrandModule();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
*/

    public static void main(String[] args) {

        

    }





/*

        Random r = new Random();
        int nextInt = r.nextInt();

        User user = new User(null,"username"+nextInt , getNum(000000, 999999)+"","name"+nextInt,new Date(),nextInt%2==0?"1":"0",getEmail(), getTel()+"",getNum(00000000, 999999999)+"");
        restTemplate.postForEntity("http://localhost:8080/user/insert.do", getEntity(user), Object.class);
        System.out.println("--------> insert User");

*/


    }

    public static void operateUserModule() throws JsonProcessingException {

        List<String> urlList = new ArrayList<String>();
        urlList.add("http://localhost:8080/user/insert.do");
        urlList.add("http://localhost:8080/user/update.do");
        urlList.add("http://localhost:8080/user/delete.do");
        urlList.add("http://localhost:8080/user/selectOne.do");
        urlList.add("http://localhost:8080/user/selectList.do");

        String randomUrl = getRandomElementFromList(urlList);

        if(randomUrl.contains("insert")){
            Random r = new Random();
            int nextInt = r.nextInt();

            User user = new User(null,"username"+nextInt , getNum(000000, 999999)+"","name"+nextInt,new Date(),nextInt%2==0?"1":"0",getEmail(), getTel()+"",getNum(00000000, 999999999)+"");
            restTemplate.postForEntity(randomUrl, getEntity(user), Object.class);
            System.out.println("--------> insert User");

        }else if(randomUrl.contains("update")){

            Random r = new Random();
            int nextInt = r.nextInt(100);

            User user = new User();
            user.setId(nextInt);
            user.setUsername("金毛狮王");

            restTemplate.postForEntity(randomUrl, getEntity(user), Object.class);
            System.out.println("--------> update User");

        }else if(randomUrl.contains("delete")){
            Random r = new Random();
            int nextInt = r.nextInt(100000);

            ResponseEntity<Object> forEntity = restTemplate.getForEntity(randomUrl + "?id=" + nextInt, Object.class);
            System.out.println("--------> delete User");

        }else if(randomUrl.contains("selectOne")){
            Random r = new Random();
            int nextInt = r.nextInt(100000);

            restTemplate.getForObject(randomUrl+"?id=" + nextInt , Object.class);
            System.out.println("--------> selectOne User");

        }else if(randomUrl.contains("selectList")){
            restTemplate.getForObject(randomUrl, Object.class);
            System.out.println("--------> selectList User");

        }

    }



    public static void operateItemModule() throws JsonProcessingException {

        List<String> urlList = new ArrayList<String>();
        urlList.add("http://localhost:8080/item/insert.do");
        urlList.add("http://localhost:8080/item/update.do");
        urlList.add("http://localhost:8080/item/delete.do");
        urlList.add("http://localhost:8080/item/selectOne.do");
        urlList.add("http://localhost:8080/item/selectList.do");

        String randomUrl = getRandomElementFromList(urlList);

        if(randomUrl.contains("insert")){
            Random r = new Random();
            int nextInt = r.nextInt(1000);

            Item item = new Item(null,"Title"+getNum(0, 1000000),new Double(nextInt),nextInt/10,new Long(nextInt/100),nextInt/100==0?"1":"0","alibaba",new Date(),new Date());

            restTemplate.postForEntity(randomUrl, getEntity(item), Object.class);
            System.out.println("--------> insert item");

        }else if(randomUrl.contains("update")){

            Random r = new Random();
            int nextInt = r.nextInt(100);

            Item item = new Item();
            item.setId(nextInt);

            restTemplate.postForEntity(randomUrl, getEntity(item), Object.class);
            System.out.println("--------> update item");

        }else if(randomUrl.contains("delete")){
            Random r = new Random();
            int nextInt = r.nextInt(100000);

            ResponseEntity<Object> forEntity = restTemplate.getForEntity(randomUrl + "?id=" + nextInt, Object.class);
            System.out.println("--------> delete item");

        }else if(randomUrl.contains("selectOne")){
            Random r = new Random();
            int nextInt = r.nextInt(100000);

            restTemplate.getForObject(randomUrl+"?id=" + nextInt , Object.class);
            System.out.println("--------> selectOne item");

        }else if(randomUrl.contains("selectList")){
            restTemplate.getForObject(randomUrl, Object.class);
            System.out.println("--------> selectList item");

        }

    }



    public static void operateBrandModule() throws JsonProcessingException {

        List<String> urlList = new ArrayList<String>();
        urlList.add("http://localhost:8080/brand/insert.do");
        urlList.add("http://localhost:8080/brand/update.do");
        urlList.add("http://localhost:8080/brand/delete.do");
        urlList.add("http://localhost:8080/brand/selectOne.do");
        urlList.add("http://localhost:8080/brand/selectList.do");

        String randomUrl = getRandomElementFromList(urlList);

        if(randomUrl.contains("insert")){
            Random r = new Random();
            int nextInt = r.nextInt(1000);

            String randStr = getRandStr(1);

            Brand brand = new Brand(null,randStr+"-Brand"+nextInt , randStr);

            restTemplate.postForEntity(randomUrl, getEntity(brand), Object.class);
            System.out.println("--------> insert brand");

        }else if(randomUrl.contains("update")){

            Random r = new Random();
            int nextInt = r.nextInt(100);

            Brand brand = new Brand();
            brand.setId(nextInt);

            restTemplate.postForEntity(randomUrl, getEntity(brand), Object.class);
            System.out.println("--------> update brand");

        }else if(randomUrl.contains("delete")){
            Random r = new Random();
            int nextInt = r.nextInt(100000);

            ResponseEntity<Object> forEntity = restTemplate.getForEntity(randomUrl + "?id=" + nextInt, Object.class);
            System.out.println("--------> delete brand");

        }else if(randomUrl.contains("selectOne")){
            Random r = new Random();
            int nextInt = r.nextInt(100000);

            restTemplate.getForObject(randomUrl+"?id=" + nextInt , Object.class);
            System.out.println("--------> selectOne brand");

        }else if(randomUrl.contains("selectList")){
            restTemplate.getForObject(randomUrl, Object.class);
            System.out.println("--------> selectList brand");

        }

    }


    public static HttpEntity getEntity(Object obj) throws JsonProcessingException {
        String json = JsonUtils.obj2JsonString(obj);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity entity = new HttpEntity(json, headers);
        return entity;
    }


    public static String getRandomElementFromList(List<String> list){
        Random random = new Random();
        int n = random.nextInt(list.size());
        String s = list.get(n);
        return s;
    }

    private static String getTel() {
        String[] telFirst="134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");
        int index=getNum(0,telFirst.length-1);
        String first=telFirst[index];
        String second=String.valueOf(getNum(1,888)+10000).substring(1);
        String third=String.valueOf(getNum(1,9100)+10000).substring(1);
        return first+second+third;
    }

    public static int getNum(int start,int end) {
        return (int)(Math.random()*(end-start+1)+start);
    }

    public static String getEmail() {
        String[] email_suffix="@gmail.com,@yahoo.com,@msn.com,@hotmail.com,@aol.com,@ask.com,@live.com,@qq.com,@0355.net,@163.com,@163.net,@263.net,@3721.net,@yeah.net,@googlemail.com,@126.com,@sina.com,@sohu.com,@yahoo.com.cn".split(",");
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";

        Integer lMin = 1;
        Integer lMax = 10;
        int length=getNum(lMin,lMax);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = (int)(Math.random()*base.length());
            sb.append(base.charAt(number));
        }
        sb.append(email_suffix[(int)(Math.random()*email_suffix.length)]);
        return sb.toString();
    }


    public static String getRandStr(int num){
        String strs = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuffer buff = new StringBuffer();

        for(int i=1;i<=num;i++){
            char str = strs.charAt((int)(Math.random() * 26));
            buff.append(str);
        }

        return buff.toString();
    }
}
