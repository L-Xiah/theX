package com.theInterface;

import java.util.HashMap;
import java.util.Map;

public class theMain {

    public static void main(String[] args) {

        System.out.println("---------");
        Cframe cframe = new Cframe();

        cframe.method1();

        CframeE<String> cFrameStr = new CframeE<>();
        String tempStr = "sddvffddff";
        cFrameStr.method1(tempStr);
        cFrameStr.method2(tempStr);

        CframeE<Integer> cFrameInt = new CframeE<>();
        cFrameInt.method2(456);


        Map<String,String> map = new HashMap<String,String>();

        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");




    }
}
