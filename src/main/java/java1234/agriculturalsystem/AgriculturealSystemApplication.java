package java1234.agriculturalsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("java1234.agriculturalsystem.mapper")
public class AgriculturealSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgriculturealSystemApplication.class, args);
    }

}
