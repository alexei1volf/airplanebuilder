package airplane.builder;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AirplaneBuilder {

    @EJB
    private EngineBuilder engineBuilder;

    public Airplane build() {
        Engine engine = engineBuilder.build();
        Airplane tu134 = new Airplane();
        tu134.setEngine(engine);
        return tu134;
    }
}
