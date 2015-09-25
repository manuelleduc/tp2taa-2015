package testjpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public abstract class ResetAfterEachTest {

	protected static EntityManager manager;
	private static EntityManagerFactory factory;

	@BeforeClass
	public static void setUpClass() throws Exception {
		factory = Persistence.createEntityManagerFactory("mysql");
		manager = factory.createEntityManager();

	}

	@AfterClass
	public static void tearDownClass() throws Exception {
		manager.close();
		factory.close();
	}

	

}
