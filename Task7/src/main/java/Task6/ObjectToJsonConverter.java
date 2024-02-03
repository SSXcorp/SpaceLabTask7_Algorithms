package Task6;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Map;

public class ObjectToJsonConverter {

    public static String convertToJson(Object obj) {
        StringBuilder jsonBuilder = new StringBuilder("{");

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true); // to allow access to private fields

            String fieldName = field.getName();
            Object fieldValue;
            try {
                fieldValue = field.get(obj);
            } catch (IllegalAccessException e) {
                System.out.println("Exception Illegal Arg!");
                continue;
            }

            jsonBuilder.append("\"").append(fieldName).append("\":").append(convertFieldValueToJson(fieldValue)).append(",");
        }
        if (fields.length > 0) {
            jsonBuilder.setLength(jsonBuilder.length() - 1); //if map is empty we don't need to print "," so we just delete it
        }
        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }

    private static String convertFieldValueToJson(Object fieldValue) {
        if (fieldValue == null) {
            return "null";
        } else if (fieldValue.getClass().isArray()) {
            return convertArrayToJson(fieldValue);
        } else if (fieldValue instanceof Map) {
            return convertMapToJson((Map<?, ?>) fieldValue);
        } else if (fieldValue.getClass().isPrimitive() || fieldValue instanceof Number || fieldValue instanceof Boolean) {
            return fieldValue.toString();
        } else if (fieldValue.getClass().getName().startsWith("java.lang")) { //instance of Object
            return "\"" + fieldValue.toString() + "\"";
        } else {
            return convertToJson(fieldValue);// to convert not primitive types and not arrays
        }
    }

    private static String convertArrayToJson(Object array) {
        int length = Array.getLength(array);
        StringBuilder arrayBuilder = new StringBuilder("[");

        for (int i = 0; i < length; i++) {
            arrayBuilder.append(convertFieldValueToJson(Array.get(array, i))).append(",");
        }
        if (length > 0) {
            arrayBuilder.setLength(arrayBuilder.length() - 1); //if map is empty we don't need to print "," so we just delete it
        }
        arrayBuilder.append("]");
        return arrayBuilder.toString();
    }

    private static String convertMapToJson(Map<?, ?> map) {
        StringBuilder mapBuilder = new StringBuilder("{");

        for (Map.Entry<?, ?> entry : map.entrySet()) {
            mapBuilder.append("\"").append(entry.getKey()).append("\":").append(convertFieldValueToJson(entry.getValue())).append(",");
        }
        if (!map.isEmpty()) {
            mapBuilder.setLength(mapBuilder.length() - 1); //if map is empty we don't need to print "," so we just delete it
        }
        mapBuilder.append("}");
        return mapBuilder.toString();
    }


}

