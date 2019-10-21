
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import service.Traitement;

public class OuputResltTest { 
	

	@Test
	public void CompaireResultsOK() {
		Traitement tr = new Traitement();
		StringBuilder sb = Traitement.replaceNumber("303");
		assertEquals("FooFoo*Foo", sb.toString());
		sb = tr.replaceNumber("53");
		assertEquals("BarFoo", sb.toString());
	}

	@Test
	public void CompaireResultsKO() {
		Traitement tr = new Traitement();
		StringBuilder sb = tr.replaceNumber("3*03");
		assertEquals("nombre faux", sb.toString());

	}
}
