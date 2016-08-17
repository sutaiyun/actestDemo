package actestDemo.myRestExample;

import actestDemo.common.*;
import net.minidev.json.JSONObject;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sutaiyun on 2016/8/17.
 */

@RestController
@EnableAutoConfiguration
@RequestMapping("/redis")
@SpringBootApplication
public class RedisRestExample {
    @RequestMapping(value ={"/{key}", ""}, method = {RequestMethod.POST, RequestMethod.GET})
    Response<Object> getValueFromkey(@PathVariable(value = "key") String key)
    {
        JSONObject obj = new JSONObject();
        obj.put("sutaiyun", "xiayunlan");
        Response<Object> rsp = Response.makeResponse(obj);
        return rsp;
    }
}
