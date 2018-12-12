package com.own.microservice.config.server.config;

import org.springframework.cloud.bootstrap.encrypt.KeyProperties;
import org.springframework.cloud.bootstrap.encrypt.RsaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.security.rsa.crypto.RsaAlgorithm;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

@Configuration
public class RsaPropertiesConfigration extends RsaProperties  {
    @Bean
    public RsaProperties rsaProperties(){
        RsaProperties rsaProperties = new RsaProperties();
        rsaProperties.setStrong(true);
        rsaProperties.setSalt("communication");
        rsaProperties.setAlgorithm(RsaAlgorithm.DEFAULT);
        return rsaProperties;
    }

//    @Bean
//    public KeyProperties keyProperties(){
//        Resource.class.c
//
//        KeyProperties.KeyStore keyStore = new KeyProperties.KeyStore();
//        keyStore.setLocation();
//        KeyProperties keyProperties = new KeyProperties();
//        keyProperties.setKeyStore();
//    }
//
//    @Override
//    public boolean exists() {
//        return false;
//    }
//
//    @Override
//    public URL getURL() throws IOException {
//        return null;
//    }
//
//    @Override
//    public URI getURI() throws IOException {
//        return null;
//    }
//
//    @Override
//    public File getFile() throws IOException {
//        return null;
//    }
//
//    @Override
//    public long contentLength() throws IOException {
//        return 0;
//    }
//
//    @Override
//    public long lastModified() throws IOException {
//        return 0;
//    }
//
//    @Override
//    public Resource createRelative(String s) throws IOException {
//        return null;
//    }
//
//    @Override
//    public String getFilename() {
//        return null;
//    }
//
//    @Override
//    public String getDescription() {
//        return null;
//    }
//
//    @Override
//    public InputStream getInputStream() throws IOException {
//        return null;
//    }
}
