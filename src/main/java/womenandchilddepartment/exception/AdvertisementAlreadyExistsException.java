package womenandchilddepartment.exception;

public class AdvertisementAlreadyExistsException extends  RuntimeException{
    public AdvertisementAlreadyExistsException() {
        super();
    }

    public AdvertisementAlreadyExistsException(String message) {
        super(message);
    }

    public AdvertisementAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

}
