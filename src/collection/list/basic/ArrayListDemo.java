package collection.list.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *@author zjl
 *2018年9月7日 下午11:15:33
 */
public class ArrayListDemo implements ListInte{
	
	private Object[] objArr;
	
	private static final Object[] EMPTY_DATA = {};
	
	public ArrayListDemo() {
		this.objArr = EMPTY_DATA;
	}
	
	public ArrayListDemo(int capacity) {
		if(capacity > 0) {
			this.objArr = new Object[capacity];
		}else if (capacity == 0) {
			this.objArr = EMPTY_DATA;
		}else {
			throw new IllegalArgumentException("Illegal Capacity: "+
					capacity);
		}
	}
	/**
	 *  2018-08-30 YYYY-MM-DD
	 * @param date
	 * @param fmt
	 * @return
	 * @throws Exception
	 */
	public static Date strToDate(String dateStr,String fmt) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		return sdf.parse(dateStr);
	}
	
	public static String dateToStr(Date date,String fmt) {
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		return sdf.format(date);
	}
	
	public static void main(String[] args) throws Exception{
		// 2018/09/09
		// 2018-08-30
		Date nowDate = strToDate("2018/09/09", "YYYY/MM/dd");
		
		
		
		//Date date = new Date();
		System.out.println(dateToStr(nowDate,"YYYY-MM-dd"));
		
		List<String> list =  new ArrayList<String>();
		list.add("aaa");
		list.add("ccc");
		
		//迭代器遍历元素
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String string = (String) it.next();
			System.out.println(string+",");
		}
		
//		System.out.println("size:"+list.size());
//		System.out.println(list);
//		list.add(1, "bbb");
//		System.out.println(list);
		//list.clear();
		//System.out.println(Arrays.asList(list));
		
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.add("111");
		arrList.add("222");
		arrList.add("333");
//		System.out.println(arrList);
//		Object arrListClone = arrList.clone();
//		System.out.println(arrListClone);
//		
		Object[] arrLists = arrList.toArray();
//		System.out.println(arrLists);
		
//		System.out.println(arrList.size());
//		arrList.ensureCapacity(10);
//		System.out.println(arrList.size());
//		
//		arrList.trimToSize();
//		System.out.println(arrList.size());
		
		System.out.println(arrLists.length);
		arrLists = Arrays.copyOf(arrLists, 10);
		System.out.println(arrLists.length);
		
		//System.arraycopy(src, srcPos, dest, destPos, length);
		
		/*List vector = new Vector<>();
		vector.add("123");
		System.out.println(list);*/
		
//		ArrayListDemo listDemo = new ArrayListDemo(0);
//		System.out.println(listDemo);
//		
//		System.out.println(4>>2);
		ArrayListDemo demo = new ArrayListDemo();
		demo.test1();
		demo.test();
		
	}

	@Override
	public void test() {
		System.out.println("我是test");
	}
}
