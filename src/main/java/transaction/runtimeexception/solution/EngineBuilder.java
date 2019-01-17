package transaction.runtimeexception.solution;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;

@Stateless
public class EngineBuilder {
    @Resource
    EJBContext ejbContext;

    public Engine build() {
        boolean isCurrentTransactionMarkedForRollback = ejbContext.getRollbackOnly();
        if (isCurrentTransactionMarkedForRollback) {
            throw new RuntimeException("Engine building error. Current transaction is marked for rollback.");
        }
        return new Engine();
    }
}
