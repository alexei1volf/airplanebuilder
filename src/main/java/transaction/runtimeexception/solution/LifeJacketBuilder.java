package transaction.runtimeexception.solution;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
public class LifeJacketBuilder {
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public LifeJacket build() throws LifeJacketBuildException {
        throw new LifeJacketBuildException("can not build life jacket");
    }
}
