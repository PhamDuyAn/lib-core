package vn.edupiatutor.redis.cluster.core.config;

import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class RedisClusterConfig {
  
  @Value("${spring.redis.host:127.0.0.1}")
  private String host;
  
  @Value("${spring.redis.port:6379}")
  private int port;
  
  @PostConstruct
  public void init() {
    log.info("(init)vn.edupiatutor.redis.cluster.core.config.RedisConfiguration");
  }
  
  @Bean
  @Primary
  @Profile("redis-single")
  JedisConnectionFactory jedisConnectionFactory() {
    log.info("(jedisConnectionFactory)host: {}, port: {}", host, port);
    RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(host, port);
    return new JedisConnectionFactory(configuration);
  }
  
  @Bean
  @Primary
  @Profile("redis-single")
  RedisTemplate<String, Object> redisTemplateSingle() {
    RedisTemplate<String, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(jedisConnectionFactory());
    template.setKeySerializer(new StringRedisSerializer());
    template.setValueSerializer(new GenericToStringSerializer<>(Object.class));
    return template;
  }
  
  @Bean
  @Primary
  @Profile("redis-single")
  public RedisTemplate<String, Integer> redisTemplateIntegerSingle() {
    final RedisTemplate<String, Integer> template = new RedisTemplate<>();
    template.setConnectionFactory(jedisConnectionFactory());
    template.setValueSerializer(new GenericToStringSerializer<>(Integer.class));
    return template;
  }
  
  @Bean
  @Primary
  @Profile("redis-cluster")
  RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
    RedisTemplate<String, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(connectionFactory);
    template.setKeySerializer(new StringRedisSerializer());
    template.setValueSerializer(new GenericToStringSerializer<>(Object.class));
    return template;
  }
  
  @Bean
  @Primary
  @Profile("redis-cluster")
  RedisTemplate<String, Integer> redisTemplateInteger(RedisConnectionFactory connectionFactory) {
    RedisTemplate<String, Integer> template = new RedisTemplate<>();
    template.setConnectionFactory(connectionFactory);
    template.setKeySerializer(new StringRedisSerializer());
    template.setValueSerializer(new GenericToStringSerializer<>(Integer.class));
    return template;
  }
}

