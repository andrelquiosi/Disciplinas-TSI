// public class FileLogger {
//     public bool IsLogMessageValid(String message){
//         return (!isString.IsNullOrEmpty(message));
//     }

//     public bool DoLog(string message){
//         return true;
//     }

// }


// public class DbLogger {
//     public bool IsLogMessageValid(String message){
//         return (!isString.IsNullOrEmpty(message));
//     }

//     public bool DoLog(string message){
//         return true;
//     }

// }

// ===============================================
public abstract class Logger {
    public bool IsLogMessageValid(String message){
        return (!isString.IsNullOrEmpty(message));
    }

    public abstract bool DoLog(string message);
}

public class FileLogger : Logger {
    public override bool DoLog(string message){
        // Implementação específica do FileLogger
        return true;
    }
}

public class DbLogger : Logger {
    public override bool DoLog(string message){
        // Implementação específica do DbLogger
        return true;
    }
}
