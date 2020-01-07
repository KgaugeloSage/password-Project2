import java.io.IOException;
import java.util.logging.*;

class Main {
    private final static Logger logCR = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME );
    private static void setupLogger() {
        LogManager.getLogManager().reset();
        logCR.setLevel(Level.ALL);

        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.SEVERE);
        logCR.addHandler(ch);

        try {
            FileHandler fh = new FileHandler("myLogger.log", true);
            fh.setLevel(Level.FINE);
            logCR.addHandler(fh);
        } catch (IOException e) {
            logCR.log(Level.SEVERE, "File logger not working.", e);
        }
    }
    public static void main(String[] args) {
        setupLogger();
        try {
            PasswordChecker Test = new PasswordChecker();
            Test.passwordIsValid("Bello@09");
        }
        catch (Exception e) {
            logCR.log(Level.SEVERE, "This Is an Error message" +e);
        }
    }
    }
