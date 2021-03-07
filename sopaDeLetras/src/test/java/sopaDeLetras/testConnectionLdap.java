/**
 * 
 */
package sopaDeLetras;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Hashtable;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.*;
import javax.naming.ldap.*;
import javax.naming.directory.*;
/**
 * @author esteb
 *
 */
class testConnectionLdap {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		System.out.println("LDAP Test Connection");


		        Hashtable<String, String> environment = new Hashtable<String, String>();

		        environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		        environment.put(Context.PROVIDER_URL, "ldap://localhost:10389");
		        environment.put(Context.SECURITY_AUTHENTICATION, "simple");
		        environment.put(Context.SECURITY_PRINCIPAL, "uid=admin,ou=system");
		        environment.put(Context.SECURITY_CREDENTIALS, "secret");

		        try 
		        {
		            DirContext context = new InitialDirContext(environment);
		            System.out.println("Connected");
		            System.out.println(context.getEnvironment());
		            context.close();
		        } 
		        catch (AuthenticationNotSupportedException exception) 
		        {
		            System.out.println("The authentication is not supported by the server");
		            fail("Error");
		        }

		        catch (AuthenticationException exception)
		        {
		            System.out.println("Incorrect password or username");
		            fail("Error");
		        }

		        catch (NamingException exception)
		        {
		            System.out.println("Error when trying to create the context");
		            fail("Error");
		        }

		
	}

}
