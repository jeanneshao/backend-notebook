package com.jeanne.lowcode.searchservice.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description
 * @author: muse
 **/
@Configuration
public class ESClientConfig {
    private final static String HOST_NAME = "110.42.204.86";
    private final static int PORT = 9200;
    private final static String SCHEME = "http";

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        HttpHost httpHost = new HttpHost(HOST_NAME, PORT, SCHEME);
        RestClientBuilder builder = RestClient.builder(httpHost);
        RestHighLevelClient client = new RestHighLevelClient(builder);
        return client;
    }
}
