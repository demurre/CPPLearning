package Registry.dal.error;

public class DAOAllReadyException extends DAOException {
    public DAOAllReadyException() {
        super();
    }

    public DAOAllReadyException(String s) {
        super(s);
    }

    public DAOAllReadyException(String s, Throwable cause) {
        super(s, cause);
    }
}
