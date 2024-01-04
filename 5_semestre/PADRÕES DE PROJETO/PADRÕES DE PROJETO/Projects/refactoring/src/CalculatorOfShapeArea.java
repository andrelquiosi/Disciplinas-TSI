public class CalculatorOfShapeArea {


    public float ParallelogramArea(float base, float height) {

        return (base * height);
    }

    public float RectangleArea(float width, float height) {

        return (width * height);
    }

    public float TrapeziumArea(float lowerBase, float higherBase, float height) {
        
        return (((lowerBase + higherBase) * height) / 2);
    }
}
