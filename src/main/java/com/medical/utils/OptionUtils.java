package com.medical.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author: lixiang
 * @date: 2022/5/14
 * @version: 1.0版本
 */
public class OptionUtils {

    //从map中获取optionIDS
    public static String getOptionIds(Map map) {
        Iterator entries = map.entrySet().iterator();
        String ids = "";
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            if (key.split("_")[0].equals("option")) {
                ids += value + ",";
            }
        }
        return ids.substring(0, ids.length() - 1);
    }

    //返回集合
    public static List<Integer> getOptionIds(String ids){
        List<Integer> integerList=new ArrayList<>();
        String[] idrArray=ids.split(",");
        if (idrArray.length==0){
            integerList.add(Integer.parseInt(ids));
            return integerList;
        }else{
            integerList.clear();
            for(String id:idrArray){
                integerList.add(Integer.parseInt(id));
            }
            return integerList;
        }
    }
}
