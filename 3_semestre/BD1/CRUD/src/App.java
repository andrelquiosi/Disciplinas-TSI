
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        int menu = 1;

        while (menu != 0) {
            System.out.printf(
                    "Escolha uma das opções abaixo:\n"
                    + "1 - Mostrar a tabela.\n"
                    + "2 - Localizar região.\n"
                    + "3 - Inserir Região na tabela.\n"
                    + "4 - Alterar uma Região na tabela.\n"
                    + "5 - Deletar um valor na tabela informando o ID.\n"
                    + "0 - Sair.\n\n");
            menu = new Scanner(System.in).nextInt();

            switch (menu) {

                case 1:
                    listar();
                    break;
                case 2:
                    localizar();
                    break;
                case 3:
                    inserir();
                    break;

                case 4:
                    alterar();
                    break;

                case 5:
                    remover();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opcao invalida!");
                    break;

            }
        }
    }

    static void localizar() throws IOException {
        System.out.print("Informe o identificador: ");
        int id = new Scanner(System.in).nextInt();

        List<Regiao> registers = LeituraEscritaArquivo.readFile();

        // buscar o objetivo regiao com o id informado
        for (Regiao region : registers) {
            if (id == region.getId()) {
                System.out.println("++++++ Região buscada ++++++");
                System.out.print("Id\tNome\n");
                System.out.printf("%s\t%s\n", region.getId(), region.getNome());
                break;
            }            
        }

        System.out.println();

    }/////////////////////////////ok

    static void listar() throws IOException {
        System.out.println("++++++ Listar as Regiões ++++++");
        System.out.print("Id\tNome\n");

        List<Regiao> registers = LeituraEscritaArquivo.readFile();
        for (Regiao regiao : registers) {
            System.out.printf("%s\t%s\n", regiao.getId(), regiao.getNome());
        }

        System.out.println();
    }///////////////////ok

    static void inserir() throws IOException {
        System.out.println("++++++ Inserir Região ++++++");

        Regiao regiao = new Regiao();

        System.out.print("Informe o identificador: ");
        regiao.setId(new Scanner(System.in).nextInt());
        System.out.print("Informe o nome: ");
        regiao.setNome(new Scanner(System.in).next());

        List<Regiao> registers = LeituraEscritaArquivo.readFile();

        boolean controle = true;

        for (Regiao region : registers) {
            if (regiao.getId() != region.getId()) {
                controle = false;
            } else {
                controle = true;
                break;
            }
        }
        if (controle == false) {

            registers.add(regiao);
            LeituraEscritaArquivo.writeFile(registers);
        }

    }/////////////////////ok

    static void alterar() throws IOException {
        System.out.println("++++++ Alterar Região ++++++");

        System.out.print("Informe o identificador ID: ");
        int id = new Scanner(System.in).nextInt();

        List<Regiao> registers = LeituraEscritaArquivo.readFile();
        Regiao newRegion = null;

        // buscar o objetivo regiao com o id informado
        for (Regiao region : registers) {
            if (id == region.getId()) {
                newRegion = region;
                System.out.println(newRegion.getNome());
                break;
            }
        }

        if (newRegion != null && newRegion.isEmUso() == false) {

            newRegion.setEmUso(true);
            LeituraEscritaArquivo.writeFile(registers);
            // atualizar o objetivo região na lista de regiões
            System.out.print("Informe o novo nome: ");
            newRegion.setNome(new Scanner(System.in).next());

            // grava os registros da lista de regiões no arquivo
            newRegion.setEmUso(false);
            LeituraEscritaArquivo.writeFile(registers);

        } else {
            System.out.println("Região não localizada ou em uso!");
        }

        System.out.println();
    }///////////////////ok

    static void remover() throws IOException {
        System.out.println("++++++ Remover Região ++++++");

        System.out.print("Informe o identificador: ");
        int id = new Scanner(System.in).nextInt();

        List<Regiao> registers = LeituraEscritaArquivo.readFile();
        Regiao newRegion = null;

        // buscar o objetivo regiao com o id informado
        for (Regiao region : registers) {
            if (id == region.getId()) {
                newRegion = region;
                break;
            }
        }

        if (newRegion != null && newRegion.isEmUso() == false) {

            newRegion.setEmUso(true);
            LeituraEscritaArquivo.writeFile(registers);
            System.out.printf("Tem certeza que deseja remover o registro %s ?\n1 = Sim\n0 = Não\nRersposta:",newRegion.getNome());
            int remover = new Scanner(System.in).nextInt();
            if (remover == 1) {
                registers.remove(newRegion);
               
                System.out.printf("Registro removido:\n%s\t%s\n", newRegion.getId(), newRegion.getNome());
                LeituraEscritaArquivo.writeFile(registers);
            }else{
                newRegion.setEmUso(false);
                LeituraEscritaArquivo.writeFile(registers);
            }

        } else {
            System.out.println("Região não localizada ou em uso!");
        }

        System.out.println();
    }//////////////////ok
}
