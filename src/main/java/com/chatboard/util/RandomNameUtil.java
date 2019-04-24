package com.chatboard.util;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 16:56 2019/3/28
 **/
public class RandomNameUtil {

    private static String [] name = {"张三","李四","王五","八神庵","不知火舞","大蛇","景天","唐雪见","李逍遥","赵灵儿"};

    public static String getRandomName(){
        int num = (int)(Math.random() * 1000);
        while (num>name.length-1) {
            if (num<=name.length-1) {
                break;
            }
            num = (int)(Math.random() * 1000);
        }
        return name[num];
    }

}
