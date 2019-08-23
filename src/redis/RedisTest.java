package redis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * 测试redis连接
 * Redis Java
 * @author zjl
 *
 */
public class RedisTest {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost");
		System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        
        //1. String(字符串) 实例
        //设置redis字符串
        jedis.set("rediskey", "teststring.com");
        //获取存储的数据并输出
        System.out.println("redis存储的字符串为："+jedis.get("rediskey"));
        
        //2. List(列表) 实例
        //存储数据到列表中
        jedis.lpush("site-list", "baidu");
        jedis.lpush("site-list", "google");
        jedis.lpush("site-list", "taobao");
        List<String> list = jedis.lrange("site-list", 0, 2);
        for (String string : list) {
			System.out.println("列表:"+string);
		}
        
        //3. Keys 实例
        Set<String> keys = jedis.keys("*");
        System.out.println(keys.size());
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
        	String key = it.next();
        	System.out.println("keys:"+key);
		}
	}
}
