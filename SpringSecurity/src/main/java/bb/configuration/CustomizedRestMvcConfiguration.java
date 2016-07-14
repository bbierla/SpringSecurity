package bb.configuration;

import bb.model.Card;
import bb.model.Device;
import bb.model.Person;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

/**
 * Created by bartosz on 07.07.16.
 */
@Configuration
@ComponentScan(basePackages = {"bb"})
@EntityScan(basePackages = "bb.model")
@EnableJpaRepositories(basePackages = "bb.repository")
public class CustomizedRestMvcConfiguration extends RepositoryRestMvcConfiguration {
    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.setReturnBodyOnCreate(true);
        config.exposeIdsFor(Device.class, Person.class, Card.class);
    }
}
