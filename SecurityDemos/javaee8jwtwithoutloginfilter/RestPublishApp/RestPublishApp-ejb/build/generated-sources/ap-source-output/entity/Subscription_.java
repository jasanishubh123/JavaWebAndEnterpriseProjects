package entity;

import entity.Customer;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-06T14:49:31")
@StaticMetamodel(Subscription.class)
public class Subscription_ { 

    public static volatile CollectionAttribute<Subscription, Customer> customerCollection;
    public static volatile SingularAttribute<Subscription, Integer> subscriptionId;
    public static volatile SingularAttribute<Subscription, String> title;
    public static volatile SingularAttribute<Subscription, String> type;

}