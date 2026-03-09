package com.heima.es.config;


import lombok.Getter;
import lombok.Setter;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhouhui
 * @version 1.0
 * @description TODO
 * @date 2026/3/9 9:10
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "elasticsearch")
@ComponentScan("com.heima.es.service.impl")
public class ElasticSearchConfig {
    private String host;
    private int port;

    @Bean
    public RestHighLevelClient client(){
        return new RestHighLevelClient(RestClient.builder(
                new HttpHost(
                        host,
                        port,
                        "http"
                )
        ));
    }
}
