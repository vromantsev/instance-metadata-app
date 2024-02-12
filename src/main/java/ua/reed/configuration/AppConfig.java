package ua.reed.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.imds.Ec2MetadataClient;

@Configuration
public class AppConfig {

    @Bean
    public Ec2MetadataClient ec2MetadataClient() {
        return Ec2MetadataClient.create();
    }
}
