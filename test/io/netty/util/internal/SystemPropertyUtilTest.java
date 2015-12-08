package io.netty.util.internal;


public class SystemPropertyUtilTest {

	public void test1(){
		System.out.println(SystemPropertyUtil.getInt("sun.arch.data.model", 0));
		System.out.println(System.getenv("TEMP"));
		System.out.println(PlatformDependent.maxDirectMemory());
		System.out.println(Runtime.getRuntime().maxMemory());
	}
	
	public static void main(String[] args) {
		SystemPropertyUtilTest test = new SystemPropertyUtilTest();
		test.test1();
	}
}

