/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hibernatedemov1;


import com.nhm.pojo.Category;
import com.nhm.pojo.Comment;
import com.nhm.pojo.OrderDetail;
import com.nhm.pojo.ProdTag;
import com.nhm.pojo.Product;
import com.nhm.pojo.SaleOrder;
import com.nhm.pojo.Tag;
import com.nhm.pojo.User;
import java.util.Properties;
import org.hibernate.SessionFactory;


import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author admin
 */
public class HibernateUtils {
    private static final SessionFactory FACTORY;
    static {
        Configuration conf = new Configuration();
        
        Properties props = new Properties();
        props.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        props.put(Environment.JAKARTA_JDBC_DRIVER, "com.mysql.cj.jdbc.Driver");
        props.put(Environment.JAKARTA_JDBC_URL, "jdbc:mysql://localhost/saledb");
        props.put(Environment.JAKARTA_JDBC_USER, "root");
        props.put(Environment.JAKARTA_JDBC_PASSWORD,"root");
        props.put(Environment.SHOW_SQL, "true");
        conf.setProperties(props);
        conf.addAnnotatedClass(Category.class);       
        conf.addAnnotatedClass(Product.class);
        conf.addAnnotatedClass(Comment.class);      
        conf.addAnnotatedClass(OrderDetail.class);
        conf.addAnnotatedClass(ProdTag.class);
        conf.addAnnotatedClass(SaleOrder.class);
        conf.addAnnotatedClass(Tag.class);
        conf.addAnnotatedClass(User.class);

        ServiceRegistry  serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        FACTORY =conf.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }
    
}
