package collection.list.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *@author zjl
 *2018年9月10日 下午9:52:45
 */
public class ArrayListDemo2 {
	public static void main(String[] args) {
		//1.创建,通过构造方法创建对象
		List<String> list = new ArrayList<String>();
		//增加，顺序添加
		list.add("111");
		list.add("222");
		list.add("333");
		System.out.println(list);
		//长度
		System.out.println("size:"+list.size());
		//删除
		list.remove(1);
		//指定位置添加
		list.add(2, "444");
		
		//2.创建
		List<String> list2 = new ArrayList<>(list);
		System.out.println(list2);
		
		//添加集合
		list2.addAll(1,list);
		System.out.println("list2:"+list2);
		
		//3.获取某个元素
		String str = list2.get(0);
		System.out.println("获取list2位置0上的元素："+str);
		
		//4.修改
		String str1 = list2.set(0, "---");
		System.out.println("返回list2位置0上被修改元素："+str1);
		System.out.println("修改list2位置0上的元素后,list2:"+list2);
		
		//遍历
		//a.for
		System.out.println("for遍历");
		for (int i = 0; i < list2.size(); i++) {
			System.out.print(list2.get(i)+",");
		}
		System.out.println();
		//2.foreach
		System.out.println("foreach遍历");
		for (String ele : list2) {
			System.out.print(ele+",");
		}
		System.out.println();
		//3.iterator
		System.out.println("iterator遍历");
		Iterator<String> it = list2.iterator();
		while(it.hasNext()) {
			String nextEle = it.next();
			System.out.print(nextEle+",");
		}
//		System.out.println();
//		for (Iterator iterator = list2.iterator(); iterator.hasNext();) {
//			String string = (String) iterator.next();
//		}
		
		//4.清除集合中所有元素
		list.clear();
		System.out.println(list.size());
		
		
		//5.删除集合中指定范围的元素
		ArrayList<String> list3 = new ArrayList<>(6);
		list3.add("aaaa");
		list3.add("bbbb");
		list3.add("CCCC");
		list3.add("dddd");
		System.out.println("list3:"+list3);
		Object[] objArr = list3.toArray();
		System.out.println("objArr："+Arrays.toString(objArr));
		
		String[] strArr = list3.toArray(new String[list3.size()]);
		System.out.println("strArr:"+Arrays.toString(strArr));
		
		//判断集合中是否有某个元素
		int i = list.indexOf("111");
		System.out.println(i);
		int j = list3.lastIndexOf("bbbb");
		System.out.println(j);
		
		//检查集合是否为空
		System.out.println(list.isEmpty());
		
	}
}
