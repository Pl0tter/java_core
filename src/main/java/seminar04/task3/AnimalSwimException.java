package seminar04.task3;

public class AnimalSwimException extends AnimalActionException {
    public AnimalSwimException(String message, String name, int distance) {
        super(message, name, distance);
    }
}
