/**
 * Created by sutaiyun on 2016/9/10.
 */
public class LogsPerfQueryJson {
    /*
    curl -XGET 'localhost:9200/logs/perf/_search?pretty' -d'
       {
           "query" : {
               "term" : {
                   "content.result.country" : "canada"
               }
           }
       }'
     */
    public class Term {
        String term;
    }
    public class LogsPerfQuery {
        Term term;
    }
    public LogsPerfQuery query;

    public String ToString(){
        return "term" + query.term.term;
    }
}
