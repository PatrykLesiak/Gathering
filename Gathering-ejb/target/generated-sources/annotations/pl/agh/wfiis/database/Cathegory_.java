package pl.agh.wfiis.database;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pl.agh.wfiis.database.EventsToCathegory;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-16T20:23:22")
@StaticMetamodel(Cathegory.class)
public class Cathegory_ { 

    public static volatile SingularAttribute<Cathegory, Integer> cathegoryid;
    public static volatile CollectionAttribute<Cathegory, EventsToCathegory> eventsToCathegoryCollection;
    public static volatile SingularAttribute<Cathegory, String> name;

}