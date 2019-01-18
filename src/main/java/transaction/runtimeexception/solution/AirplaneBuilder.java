package transaction.runtimeexception.solution;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
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

        Engine engine = engineBuilder.build();
        tu134.setEngine(engine);

        return tu134;
    }
}
