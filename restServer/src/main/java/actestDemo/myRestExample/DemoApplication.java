package actestDemo.myRestExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {

    @Autowired
    private DemoConfig demoConfig; //1

    @RequestMapping("/DemoApp")
    public String index(){
        return "redis name is "+ demoConfig.getServer()+" and redis port is "+demoConfig.getPort();
    }
}
