package Task6;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectConverterToJson {

    public static void convert(Id idObj){
        ObjectMapper mapper = new ObjectMapper();

        //Object to JSON in String
        try {
            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(idObj);
            System.out.println(jsonInString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
