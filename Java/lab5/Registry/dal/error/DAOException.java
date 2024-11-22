package Registry.dal.error;

public class DAOException extends Exception {

    public DAOException() {
        super();
    }

    public DAOException(String s) {
        super(s);
    }

    public DAOException(String s, Throwable cause) {
        super(s, cause);
    }
}