package peaksoft.config;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class DataBaseConnection {
public  static EntityManagerFactory createEMF(){
    Properties properties=new Properties();
    properties.setProperty(Environment.DRIVER, "org.postgres.Driver");
    properties.setProperty(Environment.URL, "jdbc::postgres://localhost:5433/practice)");
    properties.setProperty(Environment.USER, "postgres");
    properties.setProperty(Environment.PASS, "postgres");

    properties.setProperty(Environment.HBM2DDL_AUTO, "create");
    properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
    properties.setProperty(Environment.SHOW_SQL, "true");
    properties.setProperty(Environment.FORMAT_SQL, "true");

    Configuration configuration = new Configuration();
    configuration.setProperties(properties);

    return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
}
}

