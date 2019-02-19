package transaction.runtimeexception.solution;

public class LifeJacketBuildException extends Exception {

    public LifeJacketBuildException(String message) {
        super(message);
    }
}

/*@ApplicationException
public class LifeJacketBuildException extends RuntimeException {

    public LifeJacketBuildException(String message) {
        super(message);
    }
}*/
