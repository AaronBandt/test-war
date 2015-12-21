package com.aaronbandt.operations;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

@Configuration
public class UiConfiguration {

    private static final String PROPERTIES_PATH_PROPERTY = "PROPERTIES_PATH";
    private static final String SECRETS_PATH_PROPERTY = "SECRETS_PATH";

    private static final String LOCAL_PROPERTIES_PATH = "properties";
    private static final String LOCAL_SECRETS_PATH = "secrets";

    private static final String PROPERTIES_FILE_NAME = "test.properties";
    private static final String SECRETS_FILE_NAME = "test.properties";

    @Value("${healthcheck.in.rotation.file}")
    private String healthcheckFilePath;

    public String getHealthcheckFilePath() {
        return healthcheckFilePath;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        PropertySourcesPlaceholderConfigurer propHolder = new PropertySourcesPlaceholderConfigurer();
        propHolder.setLocations(new Resource[]{
                new ClassPathResource(LOCAL_PROPERTIES_PATH + System.getProperty("file.separator")
                        + PROPERTIES_FILE_NAME),
                new ClassPathResource(LOCAL_SECRETS_PATH + System.getProperty("file.separator") + SECRETS_FILE_NAME),
                new FileSystemResource(System.getProperty(PROPERTIES_PATH_PROPERTY)
                        + System.getProperty("file.separator") + PROPERTIES_FILE_NAME),
                new FileSystemResource(System.getProperty(SECRETS_PATH_PROPERTY) + System.getProperty("file.separator")
                        + SECRETS_FILE_NAME)});
        propHolder.setIgnoreResourceNotFound(true);
        return propHolder;
    }

}
