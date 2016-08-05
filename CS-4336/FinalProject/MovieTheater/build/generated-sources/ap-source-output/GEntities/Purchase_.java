package GEntities;

import GEntities.Movie;
import GEntities.Theater;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-04T19:26:56")
@StaticMetamodel(Purchase.class)
public class Purchase_ { 

    public static volatile SingularAttribute<Purchase, Integer> pnumTickets;
    public static volatile SingularAttribute<Purchase, String> pphone;
    public static volatile SingularAttribute<Purchase, String> pname;
    public static volatile SingularAttribute<Purchase, Date> pdatecur;
    public static volatile SingularAttribute<Purchase, Movie> mId;
    public static volatile SingularAttribute<Purchase, Integer> pid;
    public static volatile SingularAttribute<Purchase, String> pemail;
    public static volatile SingularAttribute<Purchase, Theater> tid;
    public static volatile SingularAttribute<Purchase, Date> pmoviedate;

}