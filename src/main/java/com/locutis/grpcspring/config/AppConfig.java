package com.locutis.grpcspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

@Configuration
public class AppConfig {

    public AppConfig() {
        // Explicit declaration to prevent this class from inadvertently being made instantiable
    }

//    /**
//     * Bean indicating the format of the message string
//     * @param appProperties properties that contain the message format.
//     * @return String providing the format.
//     */
//    @Bean
//    @Description("Demonstration on how to document a bean.")
//    public String format(AppProperties appProperties) {
//        return appProperties.getFormat();
//    }
}
