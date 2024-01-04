package singleton;

import java.io.IOException;

public class AppTest {

    public static void main(String[] args) throws IOException {
        Config config = Config.getInstance();

        String[] keys = { "nome", "idade" };
        String[] values = { "André", "25" };

        testCreateSingletonInstace(config);
        testNullValues(config, keys);
        testKeyAndValue(config, keys, values);
    }

    private static void testKeyAndValue(Config config, String[] keys, String[] values) {
        
        for (int i = 0; i < values.length; i++) {
            String value = config.getPropertyValue(keys[i]);
            if (values[i].equals(value)) {

                System.out.print("OK, Property value and key is OK | ");
                System.out.printf("Key: '%s' Value: '%s'\n", keys[i], value);

            } else {

                System.out.print("ERROR, Property value and key is not ok |  ");
                System.out.printf("Key: '%s' Value: '%s' is different than '%s'\n", keys[i], value, values[i]);

            }
        }

    }

    public static void testCreateSingletonInstace(Config config) {

        if (config != null) {
            System.out.println("OK, Singleton Instance created.");
        } else {
            System.out.println("ERROR, Fail create Singleton Instance.");
        }
    }

    public static void testNullValues(Config config, String[] keys) {

        for (String key : keys) {
            String value = config.getPropertyValue(key);
            if (value != null) {
                System.out.printf("OK, Property '%s' is not null: '%s'\n", key, value);
            } else {
                System.out.printf("Error, property '%s' is null.\n", key);
            }
        }

    }

}
