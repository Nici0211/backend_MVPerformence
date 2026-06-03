package at.htlkaindorf.backend_mwperformence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BackendMwPerformenceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendMwPerformenceApplication.class, args);
    }

}