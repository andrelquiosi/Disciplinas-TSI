import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        int menu = 1;
        Regiao.carregar();

        while (menu != 0) {
            System.out.printf(
                    "Escolha uma das opções abaixo:\n" +
                            "1 - Mostrar a tabela.\n" +
                            "2 - Localizar região.\n" +
                            "3 - Inserir Região na tabela.\n" +
                            "4 - Alterar uma Região na tabela.\n" +
                            "5 - Deletar um valor na tabela informando o ID.\n" +
                            "0 - Sair.\n\n");
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

    static void localizar() {
        System.out.print("Informe o identificador: ");
        String id = new Scanner(System.in).next();
        System.out.println(id);

        // buscar o objetivo regiao com o id informado
        Regiao regiao = Regiao.localizar(id);

        if (regiao == null) {
            System.out.println("Região não localizada!");
        }else{
            System.out.println("++++++ Região buscada ++++++");
            System.out.print("Id\tNome\n");
            System.out.printf("%s\t%s\n", regiao.getId(), regiao.getNome());
        }

          System.out.println();

    }
 
    static void listar() {
        System.out.println("++++++ Listar as Regiões ++++++");
        System.out.print("Id\tNome\n");

        for (Regiao regiao : Regiao.listar()) {
            System.out.printf("%s\t%s\n", regiao.getId(), regiao.getNome());
        }

        System.out.println();
    }

    static void inserir() {
        System.out.println("++++++ Inserir Região ++++++");

        Regiao regiao = new Regiao();

        System.out.print("Informe o identificador: ");
        regiao.setId(new Scanner(System.in).next());
        System.out.print("Informe o nome: ");
        regiao.setNome(new Scanner(System.in).next());

        // adiciona registro na lista de regiões
        Regiao.adicionar(regiao);
        // grava os registros da lista de regiões no arquivo
        Regiao.gravar();

        System.out.println();
    }

    static void alterar() {
        System.out.println("++++++ Alterar Região ++++++");

        System.out.print("Informe o identificador: ");
        String id = new Scanner(System.in).next();

        // buscar o objetivo regiao com o id informado
        Regiao regiao = Regiao.localizar(id);

        if (regiao != null) {
            System.out.print("Informe o novo nome: ");
            regiao.setNome(new Scanner(System.in).next());

            // atualizar o objetivo região na lista de regiões
            Regiao.atualizar(regiao);

            // grava os registros da lista de regiões no arquivo
            Regiao.gravar();
        } else {
            System.out.println("Região não localizada!");
        }

        System.out.println();
    }

    static void remover() {
        System.out.println("++++++ Remover Região ++++++");

        System.out.print("Informe o identificador: ");
        String id = new Scanner(System.in).next();

        // buscar o objetivo regiao com o id informado
        Regiao regiao = Regiao.localizar(id);
        // atualizar o objetivo região na lista de regiões
        Regiao.remover(regiao);
        // grava os registros da lista de regiões no arquivo
        Regiao.gravar();

        System.out.println();
    }
}
