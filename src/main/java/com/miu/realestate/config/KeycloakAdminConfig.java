package com.miu.realestate.config;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;

public class KeycloakAdminConfig {

    static Keycloak keycloak = null;
    @Value("keycloak.auth-server-url")
    static String serverUrl;
    @Value("keycloak.auth-server-url")
    public static String realm = "realestate";
    final static String clientId = "backend";
    final static String clientSecret = "jihfT2WuH0FLzVe1YXJXDGfNsjYsfFta";
    final static String userName = "test";
    final static String password = "admin";

    public  KeycloakAdminConfig() {}

        public static Keycloak getInstance() {
            if(keycloak == null){

                keycloak = KeycloakBuilder.builder()
                        .serverUrl(serverUrl)
                        .realm(realm)
                        .grantType(OAuth2Constants.PASSWORD)
                        .username(userName)
                        .password(password)
                        .clientId(clientId)
                        .clientSecret(clientSecret)
                        .resteasyClient(new ResteasyClientBuilder()
                                .connectionPoolSize(10)
                                .build()
                        )
                        .build();
            }
            return keycloak;
        }



}
