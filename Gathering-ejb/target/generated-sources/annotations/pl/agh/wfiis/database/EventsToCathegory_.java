package pl.agh.wfiis.database;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pl.agh.wfiis.database.Cathegory;
import pl.agh.wfiis.database.Event;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-10T18:03:46")
@StaticMetamodel(EventsToCathegory.class)
public class EventsToCathegory_ { 

    public static volatile SingularAttribute<EventsToCathegory, Integer> id;
    public static volatile SingularAttribute<EventsToCathegory, Event> event;
    public static volatile SingularAttribute<EventsToCathegory, Cathegory> cathegory;

}