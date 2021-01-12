import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        Yaml yaml = new Yaml();
        InputStream inputStream = Client.class
                .getClassLoader()
                .getResourceAsStream("example.yaml");
        Map<String, List<String>> obj = yaml.load(inputStream);
        System.out.println(obj.get("endpoint"));

    }
}
