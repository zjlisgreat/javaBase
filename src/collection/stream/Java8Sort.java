package collection.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Sort {
	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add("Google ");
		names.add("Runoob ");
		names.add("Taobao ");
		names.add("Baidu ");
		names.add("Sina ");
		
		List<String> names2 = new ArrayList<String>();
		names2.add("Google ");
		names2.add("Runoob ");
		names2.add("Taobao ");
		names2.add("Baidu ");
		names2.add("Sina ");
		
		List<String> names3 = new ArrayList<String>();
		names3.add("Google ");
		names3.add("Runoob ");
		names3.add("Taobao ");
		names3.add("Baidu ");
		names3.add("Sina ");
		
		
		System.out.println("使用java7语法排序:");
		sortJava7(names);
		System.out.println(names);
		
		System.out.println("使用java8语法排序:");
		sortJava8(names2);
		System.out.println(names2);
		
		System.out.println("使用java8语法stream排序:");
		List<String> names4 = sortJava8Stream(names3);
		System.out.println(names4);
	}
	
	public static void sortJava7(List<String> names) {
		//使用工具类
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
			
		});
	}
	
	public static void sortJava8(List<String> names) {
		Collections.sort(names, (s1,s2)->s1.compareTo(s2));
	}
	
	public static List<String> sortJava8Stream(List<String> names) {
		return names.stream().sorted((s1,s2)->s2.compareTo(s1)).collect(Collectors.toList());
	}
}
