package com.book.my.show.bookmyshowonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class BookMyShowOnlineApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowOnlineApplication.class, args);
    }

}
