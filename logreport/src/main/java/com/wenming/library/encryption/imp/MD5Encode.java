package com.wenming.library.encryption.imp;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 不可逆的加密方式
 * Created by wenmingvs on 2016/7/6.
 */
public class MD5Encode {

    /***
     * @param data
     * @return
     */
    public static String encrypt(String data) {
        try {
            // 实例化一个指定摘要算法为MD5的MessageDigest对象
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            // 重置摘要以供再次使用
            algorithm.reset();
            // 使用bytes更新摘要
            algorithm.update(data.getBytes());
            // 使用指定的byte数组对摘要进行最的更新，然后完成摘要计算
            return toHexString(algorithm.digest(), "");
        } catch (NoSuchAlgorithmException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return "";
    }

    // 将字符串中的每个字符转换为十六进制
    private static String toHexString(byte[] bytes, String separator) {
        StringBuilder hexstring = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xFF & b);
            if (hex.length() == 1) {
                hexstring.append('0');
            }
            hexstring.append(hex);
        }
        return hexstring.toString();
    }
}