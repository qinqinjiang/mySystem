package com.wode;

import redis.clients.jedis.Jedis;

/**
 * java操作Redis
 * @author jiangqinqin
 *
 */
public class TestRedis {
	private Jedis jedis;
	/**
	 * 连接Redis数据库
	 * 
	 * jiangqinqin
	 */
	public void connectionRedis(){
		//参数1：Redis数据库ip地址  参数2：Redis数据库端口号
		jedis = new Jedis("127.0.0.1",6379);
		
		//权限认证
		//jedis.auth("wode");
	}
	/**
	 * redis操作字符串类型
	 * 
	 * jiangqinqin
	 */
	public void testString(){
		//添加数据
		jedis.set("name", "qinqin");
		jedis.append("name", "你好");
		//查询数据
		System.out.println(jedis.get("name"));
		
		//删除数据
		jedis.del("name");
		
		//设置多个数据
		jedis.mset("name","qinqin","age","23","tel","173189");
		jedis.incr("age");
		System.out.println(jedis.get("age"));
	}
	/**
	 * 操作list类型
	 * 
	 * jiangqinqin
	 */
	public void testList(){
		//添加数据
		jedis.lpush("wode", "java oo");
		jedis.lpush("wode", "java web");
		jedis.lpush("wode", "java ee");
		
		//打印数据
		System.out.println(jedis.lrange("wode", 0, -1));
	}
	/**
	 * 操作set类型
	 * 
	 * jiangqinqin
	 */
	public void testSet(){
		//添加数据
		jedis.sadd("name","jiang");
		jedis.sadd("name","qin");
		jedis.sadd("name","qin");
		//查询数据
		System.out.println(jedis.smembers("name"));
	}
	
	public static void main(String[] args) {
		TestRedis testRedis = new TestRedis();
		testRedis.connectionRedis();
		testRedis.testString();
		testRedis.testList();
		testRedis.testSet();
	}
}
