package pl.agh.wfiis.database;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pl.agh.wfiis.database.Event;
import pl.agh.wfiis.database.Participant;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-10T18:03:46")
@StaticMetamodel(ParticipantToEvent.class)
public class ParticipantToEvent_ { 

    public static volatile SingularAttribute<ParticipantToEvent, Integer> id;
    public static volatile SingularAttribute<ParticipantToEvent, Event> event;
    public static volatile SingularAttribute<ParticipantToEvent, Participant> participant;

}