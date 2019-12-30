package gg.khatterji.forfun.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:api.properties")
public class RiotAPIKeyConfiguration {

    private final Environment env;

    @Autowired
    public RiotAPIKeyConfiguration(Environment env) {
        this.env = env;
    }

    @Bean
    public RiotAPIKey retrieveApiKey() {
        return new RiotAPIKey(env.getProperty("api.key"));
    }
}
