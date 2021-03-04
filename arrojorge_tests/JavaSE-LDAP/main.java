package conect;
import java.util.*;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
//import javax.naming.ldap;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

public class main {

public static void main (String[]args) {
    LdapContext ctx = null;
    Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "uoc/user1");//esto te lo dice el administrados de LDAP
        env.put(Context.SECURITY_CREDENTIALS, "Usuario1");
        env.put(Context.PROVIDER_URL, "ldap://192.168.1.14:389");//esto tambien te lo da el administrados del LDAP
    System.out.println("empieza try");
    try {
        ctx = new InitialLdapContext(env,null);

        SearchControls searchControls = new SearchControls();
        searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);

        String searchFilter = "(&(objectClass=user)(sAMAccountName=user1))";
        String ldapSearchBase = "DC=uoc,DC=p7j2e,DC=com";
        NamingEnumeration<SearchResult> results = ctx.search(ldapSearchBase, searchFilter, searchControls);
        SearchResult searchResult = null;
        while (results.hasMoreElements()) {
            searchResult = (SearchResult) results.nextElement();
            NamingEnumeration<String> var = searchResult.getAttributes().getIDs();
            String prop;
            while (var.hasMoreElements()) {
                prop = var.next();
                System.out.println(prop + " %" + searchResult.getAttributes().get(prop).get());

            }


            Attribute memberOf = searchResult.getAttributes().get("memberOf");

            for (int i = 0; i < memberOf.size(); i++) {
                Attributes atts = ctx.getAttributes(memberOf.get(i)
                        .toString(), new String[]{"CN"});
                Attribute att = atts.get("CN");
                System.out.println(att.get().toString());
            }

            System.out.println((String) searchResult.getAttributes().get("memberOf").get());

        }

    } catch (NamingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }


}
    // RetrieveUserAttributes retrieveUserAttributes = new RetrieveUserAttributes();
    //retrieveUserAttributes.getUserBasicAttributes("ncabrales", retrieveUserAttributes.getLdapContext());
    // retrieveUserAttributes.getLdapContext();
}