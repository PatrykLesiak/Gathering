package pl.agh.wfiis.database;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pl.agh.wfiis.database.Groups;
import pl.agh.wfiis.database.Participant;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-03T22:09:22")
@StaticMetamodel(UsersGroups.class)
public class UsersGroups_ { 

    public static volatile SingularAttribute<UsersGroups, Integer> id;
    public static volatile SingularAttribute<UsersGroups, Groups> groupId;
    public static volatile SingularAttribute<UsersGroups, Participant> participantId;

}