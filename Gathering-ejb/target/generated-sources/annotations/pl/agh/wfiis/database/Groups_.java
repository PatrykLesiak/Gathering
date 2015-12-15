package pl.agh.wfiis.database;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pl.agh.wfiis.database.OrganizersGroups;
import pl.agh.wfiis.database.ParticipantsGroups;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-15T15:19:39")
@StaticMetamodel(Groups.class)
public class Groups_ { 

    public static volatile SingularAttribute<Groups, Integer> groupId;
    public static volatile SingularAttribute<Groups, String> groupName;
    public static volatile CollectionAttribute<Groups, ParticipantsGroups> participantsGroupsCollection;
    public static volatile CollectionAttribute<Groups, OrganizersGroups> organizersGroupsCollection;

}