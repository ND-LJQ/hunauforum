package edu.hunau;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author ND_LJQ
 */
@EnableAdminServer
@SpringBootApplication
public class AdminApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(AdminApplication.class,args);
    }
}
