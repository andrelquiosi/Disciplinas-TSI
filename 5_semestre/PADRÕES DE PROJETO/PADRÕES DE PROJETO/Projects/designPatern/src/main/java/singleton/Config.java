package singleton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Config {

    private static Config singleton = null;

    private Config() throws IOException {

        readFromFile();

    }

    public static final Config getInstance() throws IOException {

        if (singleton == null)
            singleton = new Config();

        return singleton;
    }

    private Map<String, String> propertiesMap = new HashMap<>();

    public final String getPropertyValue(String key) {

        return this.propertiesMap.get(key);

    }

    private void readFromFile() throws IOException {

        try(BufferedReader reader = openConfigFile()){
           
            String line = null;

            while ((line = reader.readLine()) != null) {
                
                String[] tokens = extractTokens(line);

                validateTokens(tokens);

                addProperty(tokens);

            }
        }
        catch (IOException e) {
            throw new RuntimeException("Fatal error: Could not read 'config.cfg");
        }
    }

    private BufferedReader openConfigFile(){

        final String path = System.getProperty("user.dir") + "/config.cfg";

        try{

            return new BufferedReader(new FileReader(new File(path)));

        }catch (FileNotFoundException e) {

            throw new RuntimeException("Fatal error: fileNotFound 'config.cfg");
        }

    }

    private String[] extractTokens(String line) {

        if(line.trim().length() == 0)
            return null;

        String[] tokens = line.split(":");

        for(int i = 0; i < tokens.length; i++)
            tokens[i]=tokens[i].trim();

        return tokens;
    }

    private void validateTokens(String[] tokens) {

        String erroMessage = String.format("Error: '%s' is not a valid pair 'Key : value'", Arrays.toString(tokens));


        boolean isValidTokens = ((tokens[0].length() > 0 && (tokens[1].length() > 0 )));
        if (!isValidTokens)

            throw new RuntimeException(erroMessage);

        if (tokens.length != 2) {

            throw new RuntimeException(erroMessage);
        }
    }

    private void addProperty(String[] tokens){

        String key = tokens[0];
        String value = tokens[1];

        this.propertiesMap.put(key, value);

    }

}
