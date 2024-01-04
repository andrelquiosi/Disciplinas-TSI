public class App {

    private CalculatorOfShapeArea calculatorOfShapeArea = new CalculatorOfShapeArea();
    private TextUserInteraction textUserIterface = new TextUserInteraction();

    public float calculatorOfRectangleShapeArea() {

        float readWidth = this.textUserIterface.readWidth();
        float readHeight = this.textUserIterface.readHeight();

        return this.calculatorOfShapeArea.RectangleArea(readWidth, readHeight);

    }

    private float calculatorOfParalelogramShapeArea() {

        float readBase = this.textUserIterface.readBase();
        float readHeight = this.textUserIterface.readHeight();

        return this.calculatorOfShapeArea.ParallelogramArea(readBase, readHeight);

    }

    public float calculatorOfTrapeziumShapeArea() {

        float readWidth = this.textUserIterface.readWidth();
        float readHeight = this.textUserIterface.readHeight();

        return this.calculatorOfShapeArea.TrapeziumArea(readHeight, readWidth, readHeight);
    }

    public void printAreaCalculated() {

        System.out.println("Calcular a Area do Retangulo: ");
        this.textUserIterface.printArea(calculatorOfRectangleShapeArea());

        System.out.println("Calcular a Area do Paralelograma: ");
        this.textUserIterface.printArea(calculatorOfParalelogramShapeArea());

        System.out.println("Calcilar a Area do Trapezio: ");
        this.textUserIterface.printArea(calculatorOfTrapeziumShapeArea());
    }

    public static void main(String[] args) throws Exception {

        App app = new App();
        app.printAreaCalculated();

    }
}
