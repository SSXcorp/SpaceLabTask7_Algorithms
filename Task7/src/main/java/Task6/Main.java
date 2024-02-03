package Task6;

import java.util.HashMap;
import java.util.Map;

import static Task6.ObjectToJsonConverter.convertToJson;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("key1", 33);
        map.put("key2", 42);

        String[] array = {"Hello", "World"};

        Address address = new Address("Street", "Odesa", 65000);
        Id id = new Id("John", "Jonson's", address, array, map);

        String json = convertToJson(id);
        System.out.println(json);
    }
}