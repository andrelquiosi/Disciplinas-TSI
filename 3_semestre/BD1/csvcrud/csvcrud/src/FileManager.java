import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class FileManager {

    public static List<Region> readFile() throws IOException {
        File file = new File("src/Regions.csv");
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<Region> registers = new ArrayList<>();
        String line;

        br.readLine();
        while ((line = br.readLine()) != null) {
            String[] params = line.split(",");
            registers.add(
                    new Region(
                            Integer.parseInt(params[0]),
                            params[1],
                            Boolean.parseBoolean(params[2])));
        }

        br.close();
        return registers;
    }

    public static void writeFile(List<Region> registers) throws IOException {
        File file = new File("src/Regions.csv");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write("\"Id\",\"Name\",\"IsOpen\"");
        for (Region register : registers) {
            bw.newLine();
            bw.write(register.getId() + ",");
            bw.write(register.getName() + ",");
            bw.write(String.valueOf(register.isOpen()));
        }
        bw.flush();
        bw.close();
    }
}
