// class DateUtil{
//     boolena isAfter(int year1, int month1, int day1, int year2, int month2, int day2){
//         //implementation
//     }

//     int differenceInDays(int year1, int month1, int day1, int year2, int month2, int day2){
//         // implementation
//     }
// }


// ======================

class DateUtil {
    public bool IsAfter(DateTime date1, DateTime date2) {
        return date1 > date2;
    }

    public int DifferenceInDays(DateTime date1, DateTime date2) {
        return (date1 - date2).Days;
    }
}
