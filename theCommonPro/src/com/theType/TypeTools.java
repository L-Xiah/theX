package com.theType;

import java.util.HashMap;
import java.util.Map;

/** 类型识别工具
 * @author cxy @ www.cxyapi.com
 */
public class TypeTools
{
    //获得类型
    public static Map<String,String> getType(Object o)
    {
        Map<String,String> typeInfo=new HashMap<String,String>();
        typeInfo.put("type", o.getClass().getSimpleName());
        typeInfo.put("info", "引用类型");
        return typeInfo;
    }

    public static Map<String,String> getType(int i)
    {
        Map<String,String> typeInfo=new HashMap<String,String>();
        typeInfo.put("type", "int");
        typeInfo.put("info", "整形");
        return typeInfo;
    }

    public static Map<String,String> getType(long l)
    {
        Map<String,String> typeInfo=new HashMap<String,String>();
        typeInfo.put("type", "long");
        typeInfo.put("info", "长整型");
        return typeInfo;
    }

    public static Map<String,String> getType(boolean b)
    {
        Map<String,String> typeInfo=new HashMap<String,String>();
        typeInfo.put("type", "boolean");
        typeInfo.put("info", "布尔类型");
        return typeInfo;
    }

    public static Map<String,String> getType(char b)
    {
        Map<String,String> typeInfo=new HashMap<String,String>();
        typeInfo.put("type", "char");
        typeInfo.put("info", "字符");
        return typeInfo;
    }

    public static Map<String,String> getType(float f)
    {
        Map<String,String> typeInfo=new HashMap<String,String>();
        typeInfo.put("type", "float");
        typeInfo.put("info", "单精度浮点型");
        return typeInfo;
    }

    public static Map<String,String> getType(double d)
    {
        Map<String,String> typeInfo=new HashMap<String,String>();
        typeInfo.put("type", "double");
        typeInfo.put("info", "双精度浮点型");
        return typeInfo;
    }

    public static Map<String,String> getType(String s)
    {
        Map<String,String> typeInfo=new HashMap<String,String>();
        typeInfo.put("type", "String");
        typeInfo.put("info", "字符串类型");
        return typeInfo;
    }

}