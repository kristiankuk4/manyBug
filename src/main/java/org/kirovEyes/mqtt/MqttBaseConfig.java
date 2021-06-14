package org.kirovEyes.mqtt;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;

@Configuration
@ConditionalOnProperty(value = "mqtt.enabled", havingValue = "true")
public class MqttBaseConfig {
    @Value("${mqtt.host}")
    private String mqttHost;

    @Value("${mqtt.username:}")
    private String mqttUserName;

    @Value("${mqtt.pwd:}")
    private String mqttPwd;

    @Bean
    public MqttPahoClientFactory factory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        MqttConnectOptions options = new MqttConnectOptions();
        //如果配置了用户密码这里需要对应设置
        //options.setUserName();
        //options.setPassword();
        options.setServerURIs(new String[]{mqttHost});
        factory.setConnectionOptions(options);
        return factory;
    }
}
