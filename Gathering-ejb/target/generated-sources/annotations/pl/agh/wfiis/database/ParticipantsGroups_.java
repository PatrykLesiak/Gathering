package pl.agh.wfiis.database;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pl.agh.wfiis.database.Groups;
import pl.agh.wfiis.database.Participant;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-10T18:03:46")
@StaticMetamodel(ParticipantsGroups.class)
public class ParticipantsGroups_ { 

    public static volatile SingularAttribute<ParticipantsGroups, Integer> id;
    public static volatile SingularAttribute<ParticipantsGroups, Groups> groupId;
    public static volatile SingularAttribute<ParticipantsGroups, Participant> participantId;

}