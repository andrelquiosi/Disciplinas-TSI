
public class TeamLeader implements IEmployee {

    float hourlyRate = 35;

    public float calculateSalary(float hours) {
        return hours * hourlyRate;
    }

}
