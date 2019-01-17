package transaction.runtimeexception.task;

import org.junit.*;
import org.junit.rules.ExpectedException;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class AirplaneBuilderTest {
    private static EJBContainer ejbContainer;
    private static Context ctx;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @BeforeClass
    public static void setUp() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(EJBContainer.MODULES, new File("build/classes/java/main/transaction/runtimeexception/task"));

        ejbContainer = EJBContainer.createEJBContainer(properties);
        ctx = ejbContainer.getContext();
    }

    @AfterClass
    public static void closeContainer() throws Exception {
        if (ejbContainer != null)
            ejbContainer.close();
    }

    @Test
    public void airplaneDontHaveEngineOooops() throws Exception {
        AirplaneBuilder builder = (AirplaneBuilder) ctx.lookup("java:global/task/AirplaneBuilder");

        Airplane tu134 = builder.build();

        Assert.assertNull(tu134.getEngine());
    }
}