package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import runners.*;

import static org.junit.runners.Suite.*;

@RunWith(Suite.class)
@SuiteClasses({
        LoginRunner.class,
        ShoppingCartRunner.class,
        CheckoutRunner.class
})

public class BakuElectronicsSuite {
}
