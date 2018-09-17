package collection.list.basic;
/**
 *@author zjl
 *2018年9月9日 下午9:21:08
 */
public interface ListInte {
	void test();
	
	default void test1() {
		System.out.println("我是接口的方法test1");
	}
}
