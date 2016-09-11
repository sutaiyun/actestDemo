/**
 * Created by sutaiyun on 2016/9/6.
 */

import com.google.gson.Gson;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.json.GsonJsonParser;
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

    /*
     curl -XGET 'localhost:8080/logs/perf/_search?pretty' -d'
       {
           "query" : {
               "term" : {
                   "content.result.country" : "canada"
               }
           }
       }'
     */
    @RequestMapping(value="/logs/perf/{queryType}", method = RequestMethod.GET)
    public String QueryLogsPerfByJson(@PathVariable(value = "queryType") String queryType,
                                      @RequestBody String queryJson) {
        System.out.println("queryType are:" + queryType + " queryJson are:" + queryJson);
        switch (queryType) {
            case "term":
                /*
                 curl -XGET 'localhost:8080/logs/perf/term'  -d '
                                { "content.result.country" : "canada" } '
                 */
                //return client.QueryByTerm("logs", "perf", "content.result.country", "china");
                return client.QueryByTerm("logs", "perf", "content.result.adcode", "220203");
            case "multiSearch":
                /*
                 curl -XGET 'localhost:8080/logs/perf/multiSearch'  -d '
 {["content.result.country" : "canada", "content.result.adcode" : "123456"]}'
                 */
                MultiSearchItem[] items = new MultiSearchItem[2];
                items[0] = new MultiSearchItem("content.result.country", "china");
                items[1] = new MultiSearchItem("content.result.adcode", "220203");

                return client.QueryByMultiSearch("logs", "perf", items);
            default:
                System.out.println("queryType are " + queryType);
                break;
        }
        return "Null";
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
