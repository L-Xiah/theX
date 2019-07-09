package com.theArrayListTest;



import com.theType.TypeTools;

import java.util.*;

public class theMain {

    public static void main(String[] args) {




        List<String[]> lists = new ArrayList<>();
        for (int j = 0; j < 3; j++) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add( j + "-000" + i) ;
            }

            String[] tempStr = list.toArray(new String[0]);

            lists.add(tempStr);
        }



        String[] strings = lists.get(0);
        Integer integer = 10;
        System.out.println("++" + TypeTools.getType(integer));

        List<String> list = ArrayToList(strings);

        String[] strings1 = ListToArray(list);

        System.out.println("++" + list.toString());
        System.out.println("++" + Arrays.toString(strings));
        System.out.println("++" + Arrays.toString(strings1));


        Map<String,String> map = new HashMap<String,String>();

        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");




    }




    public static <T> List<T> ArrayToList(T[] arr){

        return new ArrayList<>(Arrays.asList(arr));
    }


    public static <T> T[] ListToArray(List<T> tList){

        if (tList.size()<1){
            return null;
        }

        Map map = TypeTools.getType(tList.get(0));
        if(map.get("type").equals("String")){
            return (T[]) StrListToArray((List<String>) tList);
        }
        else {
            return null;
        }

    }

    private static String[] StrListToArray(List<String> stringList){
        return stringList.toArray(new String[0]);
    }

}
