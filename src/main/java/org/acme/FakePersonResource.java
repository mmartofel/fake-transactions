package org.acme;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import io.quarkus.logging.Log;
import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

@Path("/api")
public class FakePersonResource {

    @Inject
    SecurityIdentity securityIdentity;

    @ConfigProperty(name="faker.locale")
    private String fakerLocale;

    Logger l = Logger.getLogger(FakePersonResource.class);

    String userName = "unidentified";

    public String getAuthenticatedUserName(){

        if (securityIdentity.getPrincipal().getName().isEmpty()){
            return this.userName;
        } else {
            this.userName = securityIdentity.getPrincipal().getName();
            return this.userName;   
        }
    }

    @GET
    @Path("fakeperson")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public FakePerson generateFakePerson() {
        FakePerson fakePerson = new FakePerson();    
        Log.info("Request from user: "+ getAuthenticatedUserName() + " , new person added is : "+ fakePerson.name +" "+ fakePerson.surname);
        fakePerson.persist();
        return 
            fakePerson;
    }

    @GET
    @Path("fakeperson/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FakePerson> listFakePersons() {
        Log.info("List of all " + FakePerson.count() + " persons returned");
        return 
            FakePerson.listAll();
    }

    @GET
    @Path("fakeperson/count")
    @Produces(MediaType.APPLICATION_JSON)
    public long countFakePersons() {
        Log.info("Actual amount of records found : " + FakePerson.count());
        return 
            FakePerson.count();
    }

    @GET
    @Path("fakeperson/auth")
    @Produces(MediaType.TEXT_PLAIN)
    public String getAuthFakePersonsData() {
        Log.info("Authenticated as : " + getAuthenticatedUserName());
        return 
            getAuthenticatedUserName();
    }

    @GET
    @Path("fakeperson/locale")
    @Produces(MediaType.APPLICATION_JSON)
    public String getLocaleFakePersons() {
        Log.info("Locale set to : " + fakerLocale);
        return 
            fakerLocale;
    }

}