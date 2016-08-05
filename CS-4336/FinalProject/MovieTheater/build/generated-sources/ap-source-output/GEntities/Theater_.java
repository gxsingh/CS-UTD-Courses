package GEntities;

import GEntities.Movie;
import GEntities.Purchase;
import GEntities.Times;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-04T19:26:56")
@StaticMetamodel(Theater.class)
public class Theater_ { 

    public static volatile SingularAttribute<Theater, String> tstate;
    public static volatile ListAttribute<Theater, Times> timesList;
    public static volatile SingularAttribute<Theater, String> tphone;
    public static volatile SingularAttribute<Theater, String> tname;
    public static volatile SingularAttribute<Theater, String> tzip;
    public static volatile ListAttribute<Theater, Movie> movieList;
    public static volatile SingularAttribute<Theater, Integer> tid;
    public static volatile SingularAttribute<Theater, String> tcity;
    public static volatile SingularAttribute<Theater, String> taddress;
    public static volatile ListAttribute<Theater, Purchase> purchaseList;

}