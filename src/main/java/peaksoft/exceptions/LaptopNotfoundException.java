package peaksoft.exceptions;

public class LaptopNotfoundException extends RuntimeException{
    public LaptopNotfoundException() {
        super();
    }

    public LaptopNotfoundException(String message) {
        super(message);
    }
}
