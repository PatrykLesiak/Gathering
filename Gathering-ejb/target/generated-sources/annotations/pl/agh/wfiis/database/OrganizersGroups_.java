package pl.agh.wfiis.database;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pl.agh.wfiis.database.Groups;
import pl.agh.wfiis.database.Organizer;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-15T15:19:39")
@StaticMetamodel(OrganizersGroups.class)
public class OrganizersGroups_ { 

    public static volatile SingularAttribute<OrganizersGroups, Integer> id;
    public static volatile SingularAttribute<OrganizersGroups, Groups> groupId;
    public static volatile SingularAttribute<OrganizersGroups, Organizer> organizerId;

}