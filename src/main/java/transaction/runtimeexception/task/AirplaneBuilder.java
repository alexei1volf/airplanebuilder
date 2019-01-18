package transaction.runtimeexception.task;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless(name = "AirplaneBuilder")
public class AirplaneBuilder {
    @EJB
    private EngineBuilder engineBuilder;
    @EJB
    private LifeJacketBuilder lifeJacketBuilder;

    public Airplane build() {
        Airplane tu134 = new Airplane();

        Engine engine = engineBuilder.build();
        tu134.setEngine(engine);

        LifeJacket lifeJacket = lifeJacketBuilder.build();
        tu134.setLifeJacket(lifeJacket);

        return tu134;
    }
}
