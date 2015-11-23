package pl.agh.wfiis.database;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-23T20:58:01")
@StaticMetamodel(Event.class)
public class Event_ { 

    public static volatile SingularAttribute<Event, Date> eventtime;
    public static volatile SingularAttribute<Event, String> cathegory;
    public static volatile SingularAttribute<Event, Integer> eventid;
    public static volatile SingularAttribute<Event, String> picturelink;
    public static volatile SingularAttribute<Event, String> currency;
    public static volatile SingularAttribute<Event, String> title;
    public static volatile SingularAttribute<Event, Double> price;
    public static volatile SingularAttribute<Event, Integer> minimalage;
    public static volatile SingularAttribute<Event, String> description;
    public static volatile SingularAttribute<Event, Date> eventdate;
    public static volatile SingularAttribute<Event, Integer> maximalage;
    public static volatile SingularAttribute<Event, String> place;
    public static volatile SingularAttribute<Event, Integer> maxamountofparticipants;

}