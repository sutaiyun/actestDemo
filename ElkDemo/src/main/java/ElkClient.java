import org.apache.lucene.queryparser.xml.FilterBuilder;
import org.apache.lucene.queryparser.xml.FilterBuilderFactory;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.*;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.bucket.filters.FiltersAggregationBuilder;
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

    public String Save(String index, String type, Integer id, String contentJson) {
        IndexRequest indexRequest = new IndexRequest(index, type, id.toString());
        indexRequest.source(contentJson);

        IndexResponse indexResponse = client.index(indexRequest).actionGet();
        return indexRequest.toString();
    }

    public String QueryByTerm(String index, String type, String termKey, String termValue) {
        String resultString = "";
        SearchResponse response = client.prepareSearch(index)
                                        .setTypes(type)
                                        .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                                        .setQuery(QueryBuilders.termQuery(termKey, termValue))
                                        //.setPostFilter(QueryBuilders.rangeQuery("conten-len").from(0).to(100))
                                        .setFrom(0)
                                        .setSize(3)
                                        .setExplain(true)
                                        .execute()
                                        .actionGet();

        for (SearchHit hit : response.getHits().getHits()) {
            resultString += hit.getSourceAsString();
        }
        return resultString;
    }

    public String QueryByMultiSearch(String index, String type, MultiSearchItem[] multiSearchItems) {
        String resultString = "";

        MultiSearchRequestBuilder multiSearchRequestBuilder = client.prepareMultiSearch();
        for( MultiSearchItem item : multiSearchItems)
        {
            SearchRequestBuilder srb = client.prepareSearch(index)
                .setTypes(type)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.termQuery(item.term, item.value));
            multiSearchRequestBuilder.add(srb);
        }
        MultiSearchResponse searchResponse = multiSearchRequestBuilder.execute().actionGet();

        for( MultiSearchResponse.Item item :searchResponse.getResponses())
        {
            SearchResponse response = item.getResponse();

            for (SearchHit hit : response.getHits().getHits()) {
                resultString += hit.getSourceAsString();
            }
        }
        return resultString;
    }
}
