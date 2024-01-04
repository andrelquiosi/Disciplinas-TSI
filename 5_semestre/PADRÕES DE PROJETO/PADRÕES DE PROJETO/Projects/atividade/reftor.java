// var miles = 0.0;

// if (car.HasFuel){
//     if (car.EngineWorks){
//         var startingMiles = car.Miles;
//         car.Drive();
//         var endingMiles = car.Miles;
//         miles = endingMiles - startingMiles
//     }
// }


// ========================
class reftor(){

    final double MILES_PER_GALLON = 20.0;

    public double getMilesDriven(Car car) {

        if (!car.hasFuel() || !car.engineWorks()) {
        return 0.0;
        }
    
    double startingMiles = car.getMiles();
    car.drive();
    double endingMiles = car.getMiles();
    
    return endingMiles - startingMiles;
    }

    double miles = getMilesDriven(car) ?? 0.0;
    double gallons = miles / MILES_PER_GALLON;

}