package GEntities;

import GEntities.Movie;
import GEntities.Theater;
import GEntities.TimesPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-04T19:26:56")
@StaticMetamodel(Times.class)
public class Times_ { 

    public static volatile SingularAttribute<Times, Movie> movie;
    public static volatile SingularAttribute<Times, Theater> theater;
    public static volatile SingularAttribute<Times, TimesPK> timesPK;

}