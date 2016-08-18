package actestDemo.myRestExample;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 * Created by sutaiyun on 2016/8/18.
 */

@Component
@ConfigurationProperties(prefix = "demo") //1
public class DemoConfig {
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
}
