package pl.agh.wfiis.database;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pl.agh.wfiis.database.UsersGroups;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-03T22:09:22")
@StaticMetamodel(Participant.class)
public class Participant_ { 

    public static volatile SingularAttribute<Participant, String> sex;
    public static volatile SingularAttribute<Participant, Integer> participantid;
    public static volatile SingularAttribute<Participant, String> email;
    public static volatile CollectionAttribute<Participant, UsersGroups> usersGroupsCollection;
    public static volatile SingularAttribute<Participant, String> name;
    public static volatile SingularAttribute<Participant, Integer> age;
    public static volatile SingularAttribute<Participant, String> surname;
    public static volatile SingularAttribute<Participant, String> password;

}