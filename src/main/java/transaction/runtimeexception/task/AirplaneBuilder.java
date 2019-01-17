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

        try {
            LifeJacket lifeJacket = lifeJacketBuilder.build();
            tu134.setLifeJacket(lifeJacket);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            Engine engine = engineBuilder.build();
            tu134.setEngine(engine);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return tu134;
    }
}
