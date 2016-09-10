/**
 * Created by sutaiyun on 2016/9/6.
 */

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.CharacterEncodingFilter;

@RestController
@EnableAutoConfiguration
public class ElkDemo {
    static ElkClient client;

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/logs/perf")
    public String QueryLogsPerf() {
        return client.Query("logs", "perf");
    }

    @RequestMapping(value="/logs/perf/{queryJson}", method = RequestMethod.GET)
    public String QueryLogsPerfByJson(@PathVariable(value = "queryJson") String queryJson) {
        return client.QueryByJson("logs", "perf", queryJson);
    }

    @RequestMapping(value="/logs/perf/{Id}", method = RequestMethod.POST)
    public String SaveLogsPerf(@PathVariable(value = "Id") Integer id,
                               @RequestBody String perfJson) {
        return client.Save("logs", "perf", id, perfJson);
    }

    @Bean
    public ElkClient createElkClient() {
        System.out.println("This is createElkClient!!!!");
        client = new ElkClient();
        return client;
    }

    @Bean
    public CharacterEncodingFilter initializeCharacterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ElkDemo.class, args);
        System.out.println("after run!!!!");
    }
}
