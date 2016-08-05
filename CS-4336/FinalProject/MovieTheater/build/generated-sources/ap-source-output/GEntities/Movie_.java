package GEntities;

import GEntities.Purchase;
import GEntities.Theater;
import GEntities.Times;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-04T19:26:56")
@StaticMetamodel(Movie.class)
public class Movie_ { 

    public static volatile ListAttribute<Movie, Theater> theaterList;
    public static volatile SingularAttribute<Movie, Integer> myear;
    public static volatile ListAttribute<Movie, Times> timesList;
    public static volatile SingularAttribute<Movie, Integer> mduration;
    public static volatile SingularAttribute<Movie, String> mrating;
    public static volatile SingularAttribute<Movie, String> mdescription;
    public static volatile SingularAttribute<Movie, Integer> mId;
    public static volatile SingularAttribute<Movie, String> mname;
    public static volatile SingularAttribute<Movie, String> mgenre;
    public static volatile SingularAttribute<Movie, String> mactors;
    public static volatile SingularAttribute<Movie, String> mimgloc;
    public static volatile ListAttribute<Movie, Purchase> purchaseList;

}