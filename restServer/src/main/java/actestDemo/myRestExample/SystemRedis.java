package actestDemo.myRestExample;

import actestDemo.Redis.RedisUtil;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.comparator.BooleanComparator;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by sutaiyun on 2016/8/18.
 */

@Component
@ConfigurationProperties(prefix = "redis") //1
public class SystemRedis {

    public static RedisUtil redisUtil;
    private String server;
    private Long port;

    private String redisLists;
    private static volatile int redisMaxTotal = 128;
    private static volatile int redisMaxIdle = 16;
    private static volatile int redisMaxWait = 100;
    private static volatile boolean redisTestOnBorrow = true;

    private ShardedJedisPool shardedJedisPool;

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public Long getPort() {
        return port;
    }

    public void setPort(Long port) {
        this.port = port;
    }

    public String getRedisLists() {
        return redisLists;
    }

    public void setRedisLists(String redisLists) {
        this.redisLists = redisLists;
    }

    public static volatile String redisAddressList="[{'host':'localhost', 'port':6379, 'pwd':'', 'timeout':1000, 'weight':1}]";

    public RedisUtil init() {
        System.out.println("redis.server " + server + " redis.port " + port);
        System.out.println("redisLists " + this.redisLists);
        System.out.println("redisMaxTotal: " + redisMaxTotal);
        System.out.println("redisMaxIdle: " + redisMaxIdle);
        System.out.println("redisMaxWait: " + redisMaxWait);
        System.out.println("redisTestOnBorrow: " + redisTestOnBorrow);

        String redisLists = this.redisLists;
        List<JedisShardInfo> shardInfoList = new LinkedList<>();

        System.out.println("redisLists " + redisLists);
        System.out.println("cache_redis_address_list: " + redisAddressList);

        //JSONArray jsonArray = (JSONArray) JSONValue.parse(redis_address_list);
        JSONArray jsonArray = (JSONArray) JSONValue.parse(redisLists);
        //for (JSONObject jsonObject : jsonArray) {
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);

            JedisShardInfo jedisShardInfo = new JedisShardInfo(
                    (String)jsonObject.get("host"),
                    (Integer)jsonObject.get("port"),
                    (Integer)jsonObject.get("timeout"),
                    (Integer)jsonObject.get("weight"));

            String pwd = (String) jsonObject.get("psd");
            if (pwd != null) {
                jedisShardInfo.setPassword(pwd);
            }

            shardInfoList.add(jedisShardInfo);
        }

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(this.redisMaxTotal);
        config.setMaxIdle(this.redisMaxIdle);
        config.setMaxWaitMillis(1000 * redisMaxWait);
        config.setTestOnBorrow(true);

        shardedJedisPool = new ShardedJedisPool(config, shardInfoList);
        this.redisUtil = new RedisUtil();
        redisUtil.setShardedJedisPool(shardedJedisPool);
        return redisUtil;
    }
}
