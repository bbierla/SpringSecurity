package bb.configuration;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.sql.DataSource;

import java.util.Properties;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

/**
 * Created by bartosz on 11.07.16.
 */

//@Configuration
//@Profile("dev")
//public class MyDataSourceDev {
//
//
//    @Bean(name = "MojaBaza!!!!!!!!")
//    public SessionFactory sessionFactory() {
//
//        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//        EmbeddedDatabase db = builder.setType(H2).build();
//
//        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
//        localSessionFactoryBean.setDataSource(db);
//        Properties properties = new Properties();
//        properties.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
//        localSessionFactoryBean.setHibernateProperties(properties);
//
//        return localSessionFactoryBean.getObject();
//    }
//
//}
