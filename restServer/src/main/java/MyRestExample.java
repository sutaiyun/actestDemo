package actestDemo.myRestExample;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sutaiyun on 2016/8/10.
 */

@RestController
@EnableAutoConfiguration
public class MyRestExample {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MyRestExample.class, args);
    }

}
