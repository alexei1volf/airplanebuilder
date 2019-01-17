package transaction.runtimeexception.task;

import javax.ejb.Stateless;

@Stateless
public class LifeJacketBuilder {
    public LifeJacket build() {
        throw new RuntimeException("can not build life jacket");
    }
}
