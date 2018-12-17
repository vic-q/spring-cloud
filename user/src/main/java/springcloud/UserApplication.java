package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangqing
 */
@SpringCloudApplication
@RestController
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @RequestMapping(value = "/helloUser")
    public String hello() {
        return "helloUser";
    }

    @RequestMapping(value = "/api/helloUser")
    public String api() {
        return "api/helloUser";
    }
}
