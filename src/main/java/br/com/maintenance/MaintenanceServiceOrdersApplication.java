
package br.com.maintenance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication(scanBasePackages = "br.com.maintenance")
@EnableMongoAuditing
public class MaintenanceServiceOrdersApplication {

    public static void main(String[] args) {
        SpringApplication.run(
            MaintenanceServiceOrdersApplication.class,
            args
        );
    }
}

