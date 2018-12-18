package cn.evilmoon.consolelab.labs;

import cn.evilmoon.consolelab.Lab;
import cn.evilmoon.consolelab.TimeTag;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import org.apache.commons.codec.binary.Hex;

/**
 * SHA256 签名生成工具
 */
@TimeTag("2018-12-18 11:36")
public class SHA256Lab implements Lab {
    @Override
    public void run(String[] args) {
        Map<String, String> params = new HashMap<String, String>();
        // apim auth info
        final String secret = "23b7fbcdcb564e4a9fef6d5f5d333e90";
        params.put("api_key", "digitalcamera");
        params.put("nonce_str", "abc1234");
        params.put("timestamp", "2018-12-18 16:47:01");

        // business params
        //params.put("app", "digitalcamera");
        //params.put("code", "l4ZFvnyr8HkkUbqwPe94K1hvGfunjM6vauYAAAEs");
        //params.put("redirect_uri", "https://transitsharedqaapim0.azure-api.cn/commons-ssofed/v1/auth?app=digitalcamera&subscription-key=3c0b9c448ace43e5a8f20fefa444a1ca");
        try {
            System.out.println("Sign is ----> " + sign(params, secret));
        }
        catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        }
        catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
    }

    private String sign(Map<String, String> params, String secret)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {

        List<String> paramList = new ArrayList<>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            paramList.add(entry.getKey() + "=" + entry.getValue());
        }
        Collections.sort(paramList);
        StringBuilder sb = new StringBuilder();
        sb.append(secret);
        for (String paramStr : paramList) {
            sb.append(paramStr);
            sb.append("&");
        }
        sb.replace(sb.length() - 1, sb.length(), secret);
        System.out.println(sb.toString());
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        byte[] bytes = instance.digest(sb.toString().getBytes("UTF-8"));

        return Hex.encodeHexString(bytes).toUpperCase();
    }
}
