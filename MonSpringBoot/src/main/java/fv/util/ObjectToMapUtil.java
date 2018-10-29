package fv.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ObjectToMapUtil {

    public static Map<String, Object> ObjectToMapUtil(Object obj){
        Map<String,Object> reMap = new HashMap<String,Object>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                Field subField = obj.getClass().getDeclaredField(field.getName());
                subField.setAccessible(true);
                Object o = subField.get(obj);
                reMap.put(field.getName(), o);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return reMap;
    }
}
