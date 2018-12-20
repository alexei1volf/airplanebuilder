package airplane.builder;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import static org.assertj.core.api.Assertions.assertThat;

public class AirplaneBuilderTest {
    private static EJBContainer ejbContainer;
    private static Context ctx;

    @BeforeClass
    public static void setUp() {
        ejbContainer = EJBContainer.createEJBContainer();
        ctx = ejbContainer.getContext();
    }

    @AfterClass
    public static void closeContainer() throws Exception {
        if (ejbContainer != null)
            ejbContainer.close();
    }

    @Test
    public void shouldBuildTheAirplane() throws Exception {
        AirplaneBuilder builder = (AirplaneBuilder) ctx.lookup("java:global/production/AirplaneBuilder");

        Airplane tu134 = builder.build();

        assertThat(tu134.getEngine().getPower()).isEqualTo(15000000);
    }
}