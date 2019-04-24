package com.chatboard.util;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 17:03 2019/3/28
 **/
public class RandomHeadPicUtil {

    public static String getRandomHeadPic(){
        String headPic = "http://192.168.0.23:8080/FileServer/headPic/"+(int)(Math.random() * 8)+".png";
        return headPic;
    }
}
