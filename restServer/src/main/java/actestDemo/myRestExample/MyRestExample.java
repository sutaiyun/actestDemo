package actestDemo.myRestExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import net.minidev.json.JSONObject;

import actestDemo.common.*;
/**
 * Created by sutaiyun on 2016/8/10.
 */

@RestController
//@EnableAutoConfiguration
@SpringBootApplication
public class MyRestExample {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    //    @RequestMapping("/session/login")
//    String login () {
//        return "{\"msg\":\"success\", {\"bizData\":{\"userName\": \"admin\" ,\"password\":\"admin\"}}}" ;
//    }
    @RequestMapping("/session/login")
    public Response<Object> login () {
        //systemRedis.init();

        JSONObject obj = new JSONObject();
        Response<Object> rsp = Response.makeResponse(obj);
        return rsp;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MyRestExample.class, args);
    }
}
