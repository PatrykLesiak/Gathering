package pl.agh.wfiis.database;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pl.agh.wfiis.database.Cathegory;
import pl.agh.wfiis.database.EventsToCathegory;
import pl.agh.wfiis.database.Organizer;
import pl.agh.wfiis.database.ParticipantToEvent;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-10T18:03:46")
@StaticMetamodel(Event.class)
public class Event_ { 

    public static volatile SingularAttribute<Event, Cathegory> cathegory;
    public static volatile SingularAttribute<Event, Organizer> organizer;
    public static volatile SingularAttribute<Event, Integer> eventid;
    public static volatile SingularAttribute<Event, String> picturelink;
    public static volatile SingularAttribute<Event, String> currency;
    public static volatile CollectionAttribute<Event, EventsToCathegory> eventsToCathegoryCollection;
    public static volatile SingularAttribute<Event, String> title;
    public static volatile SingularAttribute<Event, Double> price;
    public static volatile CollectionAttribute<Event, ParticipantToEvent> participantToEventCollection;
    public static volatile SingularAttribute<Event, String> description;
    public static volatile SingularAttribute<Event, Integer> minimalage;
    public static volatile SingularAttribute<Event, Date> eventdate;
    public static volatile SingularAttribute<Event, String> place;
    public static volatile SingularAttribute<Event, Integer> maximalage;
    public static volatile SingularAttribute<Event, Integer> maxamountofparticipants;

}