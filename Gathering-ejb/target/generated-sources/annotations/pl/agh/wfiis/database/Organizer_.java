package pl.agh.wfiis.database;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pl.agh.wfiis.database.Event;
import pl.agh.wfiis.database.OrganizersGroups;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-04T21:23:23")
@StaticMetamodel(Organizer.class)
public class Organizer_ { 

    public static volatile SingularAttribute<Organizer, Integer> phonenumber;
    public static volatile CollectionAttribute<Organizer, OrganizersGroups> organizersGroupsCollection;
    public static volatile SingularAttribute<Organizer, String> email;
    public static volatile SingularAttribute<Organizer, Integer> companyidentificationnumber;
    public static volatile SingularAttribute<Organizer, Integer> organizerid;
    public static volatile SingularAttribute<Organizer, String> accountnumber;
    public static volatile SingularAttribute<Organizer, String> companyname;
    public static volatile SingularAttribute<Organizer, String> representativesurname;
    public static volatile SingularAttribute<Organizer, String> password;
    public static volatile SingularAttribute<Organizer, String> representativename;
    public static volatile CollectionAttribute<Organizer, Event> eventCollection;

}