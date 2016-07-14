package bb.configuration;

/**
 * Created by bartosz on 14.07.16.
 */
import bb.configuration.WebSecurityConfig;
import org.springframework.security.web.context.*;

public class SecurityWebApplicationInitializer
        extends AbstractSecurityWebApplicationInitializer {

    public SecurityWebApplicationInitializer() {
        super(WebSecurityConfig.class);
    }
}
