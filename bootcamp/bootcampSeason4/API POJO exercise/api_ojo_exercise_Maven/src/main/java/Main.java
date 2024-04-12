import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {


    ObjectMapper mapper = new ObjectMapper();

    MyPojo myPojo2 = mapper.readValue(new URL("https://ipinfo.io/json"), MyPojo.class);
    System.out.println(myPojo2);


}
}