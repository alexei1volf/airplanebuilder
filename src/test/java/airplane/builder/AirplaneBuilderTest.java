package airplane.builder;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnit4.class)
public class AirplaneBuilderTest {
    private static EJBContainer ejbContainer;
    private static Context context;

    @BeforeClass
    public static void setUp() {
        Properties p = new Properties();
        p.put("openejb.deployments.classpath.exclude", "");
        p.put("openejb.deployments.classpath.include", ".*");
        ejbContainer = EJBContainer.createEJBContainer(p);
    }

    @AfterClass
    public static void closeContainer() throws Exception {
        if (ejbContainer != null)
            ejbContainer.close();
    }

    @Test
    public void shouldBuildTheAirplane() throws Exception {
        AirplaneBuilder builder = (AirplaneBuilder) context.lookup("AirplaneBuilder");

        Airplane tu134 = builder.build();

        assertThat("vvv").isNotNull();
    }
}