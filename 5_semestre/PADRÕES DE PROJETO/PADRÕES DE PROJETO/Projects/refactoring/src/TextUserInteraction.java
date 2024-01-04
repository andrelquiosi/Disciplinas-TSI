import java.util.Scanner;

public class TextUserInteraction {

    private final Scanner scanner = new Scanner(System.in);

    private float promptAndReadFloat(String promptMessage) {

        float number;

        do {

            System.out.println(promptMessage);
            number = scanner.nextFloat();

        } while (number < 0);

        return number;

    }

    public float readWidth() {
        return promptAndReadFloat("informe o valor da largura: ");
    }

    public float readHeight(){
        return promptAndReadFloat("Informe o valor da altura: ");
    }

    public float readBase(){
        return promptAndReadFloat("Informe o valor da base: ");
    }


    public float readLowerBase(){
        return promptAndReadFloat("Informe o valor da base menor: ");
    }


    public float readBiggerBase(){
        return promptAndReadFloat("Informe o valor da base maior: ");
    }

    public void printArea(float area){

        System.out.println("\nA area é de " + area);

    }

    


}
