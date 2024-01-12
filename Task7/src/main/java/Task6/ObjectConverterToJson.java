package Task6;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectConverterToJson {

    public static String convert(Object object) {
        return convertObject(object);
    }

    private static String convertObject(Object object) {
        if (object == null) {
            return "null";
        }

        StringBuilder jsonBuilder = new StringBuilder("{");

        if (object instanceof Address) {
            Address address = (Address) object;
            jsonBuilder.append("\"street\":\"").append(address.getStreet()).append("\",")
                    .append("\"city\":\"").append(address.getCity()).append("\",")
                    .append("\"zip\":").append(address.getZip());
        } else if (object instanceof Id) {
            Id id = (Id) object;
            jsonBuilder.append("\"fname\":\"").append(id.getFname()).append("\",")
                    .append("\"lname\":\"").append(id.getLname()).append("\",")
                    .append("\"address\":").append(convertObject(id.getAddress()));
        }

        jsonBuilder.append("}");

        return jsonBuilder.toString();
    }

}
