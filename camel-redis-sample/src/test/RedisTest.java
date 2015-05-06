package test;

import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.redis.RedisConfiguration;
import org.apache.camel.component.redis.processor.idempotent.RedisIdempotentRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

public class RedisTest {
    @EndpointInject(uri = "direct:start")
    private static ProducerTemplate template;
    @Autowired
    private static RedisConfiguration redisConfiguration;
    private static StringRedisTemplate redisTemplate;

    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("camelContext.xml");
        RedisTest test = (RedisTest) factory.getBean("test");
        RedisIdempotentRepository idempotentRepository = (RedisIdempotentRepository) factory
                .getBean("idempotentRepository");
        // idempotentRepository.getRedisConfiguration().setSerializer(new
        // GenericToStringSerializer<String>(String.class));
        // ConsumerTemplate consumerTemplate = (ConsumerTemplate) factory.getBean("consumerTemplate");
        // System.out.println(consumerTemplate + "11111111111111111111");
        // System.out.println(factory.getBean("redisTemplate"));
        // redisTemplate = (StringRedisTemplate) factory.getBean("redisTemplate");
        // redisTemplate.setValueSerializer(new GenericToStringSerializer<String>(String.class));
        // redisTemplate.convertAndSend("testChannel", "Message one111111");
        // // String jmsQueue = "redis://192.168.2.21:6379?command=SUBSCRIBE&channels=testChannel";
        // template.send("direct:start", new Processor() {
        // public void process(Exchange exchange) throws Exception {
        // exchange.getIn().setHeader(RedisConstants.COMMAND, "PUBLISH");
        // exchange.getIn().setHeader(RedisConstants.CHANNEL, "testChannel");
        // exchange.getIn().setHeader(RedisConstants.MESSAGE, "Message one");
        // }
        // });
    }

    public void onProcess(String[] hello) {
        System.out.println(hello);
    }

    /**
     * @return the template
     */
    public static ProducerTemplate getTemplate() {
        return template;
    }

    /**
     * @param template the template to set
     */
    public static void setTemplate(ProducerTemplate template) {
        RedisTest.template = template;
    }

    /**
     * @return the redisTemplate
     */
    public static StringRedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    /**
     * @param redisTemplate the redisTemplate to set
     */
    public static void setRedisTemplate(StringRedisTemplate redisTemplate) {
        RedisTest.redisTemplate = redisTemplate;
    }

    /**
     * @return the redisConfiguration
     */
    public static RedisConfiguration getRedisConfiguration() {
        return redisConfiguration;
    }

    /**
     * @param redisConfiguration the redisConfiguration to set
     */
    public static void setRedisConfiguration(RedisConfiguration redisConfiguration) {
        RedisTest.redisConfiguration = redisConfiguration;
    }
}
