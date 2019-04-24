package com.chatboard.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 14:15 2019/3/28
 **/
public class JsonUtils {

    public static JsonArray readJsonFile(String path){
        try{
            FileInputStream stream = new FileInputStream(path);
            InputStreamReader reader = new InputStreamReader(stream);
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(reader);
            if(element != null){
                return element.getAsJsonArray();
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    public static String getStringFromProperty(JsonObject properties, String name){
        JsonElement property = properties.get(name);
        if(property != null){
            try{
                return property.getAsString();
            }catch(Exception e){
                return null;
            }
        }
        return null;
    }
}
