package com.chatboard.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 17:12 2019/3/28
 **/
public class RandomNumUtil {

    private static List<Integer> integerList = new ArrayList<>();

    static {
        for (int i = 1; i < 8; i++) {
            integerList.add(i);
        }
    }

    public static String shuffleRandom() {
        synchronized (integerList) {
            Collections.shuffle(integerList);
            StringBuilder sb = new StringBuilder();
            for (int i : integerList) {
                sb.append(i);
            }
            return sb.toString();
        }
    }

}
