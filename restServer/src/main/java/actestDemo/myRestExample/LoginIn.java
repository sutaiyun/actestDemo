package actestDemo.myRestExample;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sutaiyun on 2016/8/14.
 */

@RestController
@EnableAutoConfiguration
@RequestMapping("/login")
@SpringBootApplication
public class LoginIn {

    @RequestMapping(value ={"/", ""}, method = {RequestMethod.POST, RequestMethod.GET})
    String Login() { return "msg"; }
}
