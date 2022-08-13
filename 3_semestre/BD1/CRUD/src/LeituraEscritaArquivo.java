import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class LeituraEscritaArquivo {

    public static List<Regiao> readFile() throws IOException {
        File file = new File("src/Regions.csv");
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<Regiao> registers = new ArrayList<>();
        String line;

        br.readLine();
        while ((line = br.readLine()) != null) {
            String[] params = line.split(",");
            registers.add(
                    new Regiao(
                            Integer.parseInt(params[0]),
                            params[1],
                            Boolean.parseBoolean(params[2])));
        }

        br.close();
        return registers;
    }

    public static void writeFile(List<Regiao> registers) throws IOException {
        File file = new File("src/Regions.csv");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write("\"Id\",\"Name\",\"IsOpen\"");
        for (Regiao register : registers) {
            bw.newLine();
            bw.write(register.getId() + ",");
            bw.write(register.getNome() + ",");
            bw.write(String.valueOf(register.isEmUso()));
        }
        bw.flush();
        bw.close();
    }
}
