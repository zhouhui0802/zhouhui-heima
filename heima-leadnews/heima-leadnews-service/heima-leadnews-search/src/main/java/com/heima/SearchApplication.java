package com.heima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAsync
public class SearchApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(SearchApplication.class, args);
        System.out.println( "Hello SearchApplication!" );
    }
}
