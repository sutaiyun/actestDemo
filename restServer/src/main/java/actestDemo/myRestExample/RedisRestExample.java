package actestDemo.myRestExample;

import actestDemo.common.*;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sutaiyun on 2016/8/17.
 */

@RestController
//@EnableAutoConfiguration
@RequestMapping("/redis")
@SpringBootApplication
public class RedisRestExample {

    //SystemRedis systemRedis = new SystemRedis();
    @Autowired
    private SystemRedis systemRedis;

    @Autowired
    private DemoConfig demoConfig;

    @RequestMapping(value ={"/{key}", "{key}"}, method = {RequestMethod.POST, RequestMethod.GET})
    Response<Object> getValueFromkey(@PathVariable(value = "key") String key)
    {
        systemRedis.init();

        JSONObject obj = new JSONObject();
        if (null != key) {
            obj.put(key, "xiayunlan");
        }
        Response<Object> rsp = Response.makeResponse(obj);
        return rsp;
    }
}
