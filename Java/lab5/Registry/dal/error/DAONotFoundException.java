package Registry.dal.error;

public class DAONotFoundException extends DAOException {
    public DAONotFoundException() {
        super();
    }

    public DAONotFoundException(String s) {
        super(s);
    }

    public DAONotFoundException(String s, Throwable cause) {
        super(s, cause);
    }
}
