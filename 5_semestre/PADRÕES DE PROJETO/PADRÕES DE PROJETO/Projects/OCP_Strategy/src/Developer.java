
public class Developer implements IEmployee {

    float hourlyRate = 40;

    public float calculateSalary(float hours) {
        return hours * hourlyRate;
    }

}
