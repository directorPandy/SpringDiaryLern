package ru.director.SpringDiaryLern.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Credential {

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String url;
    String username;
    String password;

    FileInputStream fis;
    Properties property = new Properties();

    public Credential getCredentials(Credential credential) {
        try {

            fis = new FileInputStream("src/main/resources/application.properties");
            property.load(fis);
            credential.setUrl(property.getProperty("spring.datasource.url"));
            credential.setUsername(property.getProperty("spring.datasource.username"));
            credential.setPassword(property.getProperty("spring.datasource.password"));

        } catch (IOException e) {
            System.err.println("Missing file");
        }
        return credential;
    }
}
