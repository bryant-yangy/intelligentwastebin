package com.yyd.intelligentwastebin.utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yyd.intelligentwastebin.domain.User;
import jdk.nashorn.internal.parser.Token;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class FaceUtil {
     private   static String token =getAuth();


    public static synchronized String getAuth() {
        if(token==null){
            String clientId = "3RO8Pl9DYhIGrtdyIg0VA3qq";
            // 官网获取的 Secret Key 更新为你注册的
            String clientSecret = "oN7IraQ4sd2FcVTjWB1sMIUYZBtX6NsG";
            return getAuth(clientId, clientSecret);
        }
        // 官网获取的 API Key 更新为你注册的
        return token;
    }

    /**
     * 获取API访问token
     * 该token有一定的有效期，需要自行管理，当失效时需重新获取.
     * @param ak - 百度云官网获取的 API Key
     * @param sk - 百度云官网获取的 Securet Key
     * @return assess_token 示例：
     * "24.460da4889caad24cccdb1fea17221975.2592000.1491995545.282335-1234567"
     */
    public static String getAuth(String ak, String sk) {
        System.out.println("*************************\nfacetoken");
        // 获取token地址
        String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
        String getAccessTokenUrl = authHost
                // 1. grant_type为固定参数
                + "grant_type=client_credentials"
                // 2. 官网获取的 API Key
                + "&client_id=" + ak
                // 3. 官网获取的 Secret Key
                + "&client_secret=" + sk;
        try {
            URL realUrl = new URL(getAccessTokenUrl);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
//            for (String key : map.keySet()) {
//                System.err.println(key + "--->" + map.get(key));
//            }
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            /**
             * 返回结果示例
             */
            //System.err.println("result:" + result);
            JSONObject jsonObject = new JSONObject(result);
            String access_token = jsonObject.getString("access_token");
            return access_token;
        } catch (Exception e) {
            System.err.printf("获取token失败！");
            e.printStackTrace(System.err);
        }
        return null;
    }


    public static boolean  isFace(String imgStr) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/detect";
        try {

            Map<String, Object> map = new HashMap<>();
            map.put("image", imgStr);
            map.put("face_field", "age,beauty");
            map.put("image_type", "BASE64");
            String param = GsonUtils.toJson(map);
            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。


            String result = HttpUtil.post(url, token, "application/json", param);
            ObjectMapper om = new ObjectMapper();
            LinkedHashMap hashmap = om.readValue(result, LinkedHashMap.class);
            if(hashmap.get("error_msg").equals("SUCCESS")){
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public static HashMap addFace(User user, MultipartFile multipartFile){
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add";
        try {
            byte[] imgData = multipartFile.getBytes();
            String imgStr = Base64Util.encode(imgData);
            Map<String, Object> map = new HashMap<>();
            map.put("image", imgStr);
            map.put("group_id", "1");
            map.put("user_id", user.getId());
            map.put("user_info", user.getUsername());
            map.put("liveness_control", "NONE");
            map.put("image_type", "BASE64");
            map.put("quality_control", "LOW");

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = token;
            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            ObjectMapper om = new ObjectMapper();
            LinkedHashMap hashMap = om.readValue(result, LinkedHashMap.class);
            return hashMap;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    public static int identUser(MultipartFile multipartFile) throws IOException {

        String url = "https://aip.baidubce.com/rest/2.0/face/v3/search";
        try{
            byte[] imgData = multipartFile.getBytes();
            String imgStr = Base64Util.encode(imgData);
            Map<String, Object> map = new HashMap<>();
            map.put("image", imgStr);
            map.put("liveness_control", "NONE");
            map.put("group_id_list", "1");
            map.put("image_type", "BASE64");
            map.put("quality_control", "LOW");

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = token;
            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            ObjectMapper om = new ObjectMapper();
            LinkedHashMap hashmap = om.readValue(result, LinkedHashMap.class);
            if(hashmap.get("error_msg").equals("SUCCESS")){
                HashMap resultmap = (HashMap) hashmap.get("result");
                ArrayList usermap = (ArrayList) resultmap.get("user_list");
                LinkedHashMap oneuser =(LinkedHashMap) usermap.get(0);
                if(new Double(String.valueOf(oneuser.get("score")))<10){
                    return -1;
                }
                return new Integer((String)oneuser.get("user_id"));
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    public static int identUser(String multipartFile) throws IOException {

        String url = "https://aip.baidubce.com/rest/2.0/face/v3/search";
        try{
            byte[] imgData = multipartFile.getBytes();
            String imgStr = Base64Util.encode(imgData);
            Map<String, Object> map = new HashMap<>();
            map.put("image",imgStr);
            map.put("liveness_control", "NONE");
            map.put("group_id_list", "1");
            map.put("image_type", "BASE64");
            map.put("quality_control", "LOW");

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = token;
            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            ObjectMapper om = new ObjectMapper();
            LinkedHashMap hashmap = om.readValue(result, LinkedHashMap.class);
            if(hashmap.get("error_msg").equals("SUCCESS")){
                HashMap resultmap = (HashMap) hashmap.get("result");
                ArrayList usermap = (ArrayList) resultmap.get("user_list");
                LinkedHashMap oneuser =(LinkedHashMap) usermap.get(0);
                if(new Double(String.valueOf(oneuser.get("score")))<10){
                    return -1;
                }
                return new Integer((String)oneuser.get("user_id"));
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }




    public static String getFaceList(){
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/group/getusers";
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("group_id", "1");

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = token;

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        String auth = getAuth();
        System.out.println(auth);
    }
}
