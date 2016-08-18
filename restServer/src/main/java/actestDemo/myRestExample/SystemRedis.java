package actestDemo.myRestExample;

import actestDemo.Redis.RedisUtil;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import redis.clients.jedis.ShardedJedisPool;

/**
 * Created by sutaiyun on 2016/8/18.
 */

@Component
@ConfigurationProperties(prefix = "redis") //1
public class SystemRedis {
    private String server;
    private Long port;

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

    private ShardedJedisPool shardedJedisPool;

    public RedisUtil init() {
        //System.out.println("redis.server " + redisServer + " redis.port " + redisPort);
        System.out.println("redis.server " + server + " redis.port " + port);
        return new RedisUtil();
    }
}
