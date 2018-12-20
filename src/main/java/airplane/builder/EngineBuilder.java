package airplane.builder;

import javax.ejb.Stateless;

@Stateless
public class EngineBuilder {
    public Engine build() {
        return new Engine();
    }
}
