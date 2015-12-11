package io.netty.channel.group;

import java.util.HashMap;
import java.util.Map;

public class ChannelMatchersTest {

	Map<String,String> map = new HashMap<String,String>();
	
	public void setUp(){
		map.put("aa", "bb");
	}
	
	public void test1(){
		Map<String,String> map1 = map;
		map1.put("bb", "cc");
		
		map.clear();
		System.out.println(map.size());
		System.out.println(map1.size());
	}
	
	public static void main(String[] args) {
		ChannelMatchersTest test = new ChannelMatchersTest();
		test.setUp();
		test.test1();
	}
}
