import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.search.SearchHit;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by sutaiyun on 2016/9/6.
 */
public class ElkClient implements CommandLineRunner {
    public Client client;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("client init");
        client = TransportClient
                .builder()
                .build()
                .addTransportAddress(
                        new InetSocketTransportAddress(InetAddress
                                .getByName("localhost"), 9300));
    }

    public void stop() throws Exception {
        System.out.println("client stop!!!!!!!!!!!!");
        client.close();
    }

    public String Query(String index, String type) {
        SearchResponse searchResponse = client.prepareSearch(index).setTypes(type).execute().actionGet();
        SearchHit[] hits = searchResponse.getHits().getHits();
        Map<String, Object> hitsMap = new HashMap<>();

        for (SearchHit hit : hits) {
            //System.out.println("id:" + hit.getId() + " content:" + hit.sourceAsString());
            hitsMap.put(hit.getId(), hit.sourceAsString());
        }
        return hitsMap.toString();
    }

    public String Save(String index, String type, Integer id, String contentJson ) {
        IndexRequest indexRequest = new IndexRequest(index, type, id.toString());
        indexRequest.source(contentJson);

        IndexResponse indexResponse = client.index(indexRequest).actionGet();
        return indexRequest.toString();
    }

    public String QueryByJson(String logs, String perf, String queryJson) {
        //TODO:
        return "TODO";
    }
}
