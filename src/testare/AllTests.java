package testare;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AdaugareTest.class, CautareTest.class, SortareTest.class,
		StergereTest.class, VerificareTest.class })
public class AllTests {

}
