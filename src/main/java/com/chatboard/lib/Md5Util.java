package com.chatboard.lib;

import java.security.MessageDigest;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 14:07 2019/4/2
 **/
public class Md5Util {

    private static char hexdigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e','f'};

    public static String getMd5(String info){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(info.getBytes("UTF-8"));
            byte[] b = md.digest();
            return byteToHexString(b);
        } catch (Exception ex) {
            return null;
        }
    }

    private static String byteToHexString(byte[] tmp) {
        String s;
        char str[] = new char[16 * 2];
        int k = 0;
        for (int i = 0; i < 16; i++) {
            byte byte0 = tmp[i];
            str[k++] = hexdigits[byte0 >>> 4 & 0xf];
            str[k++] = hexdigits[byte0 & 0xf];
        }
        s = new String(str);
        return s;
    }
}
