package collection.cases;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * https://blog.csdn.net/qq_33110175/article/details/80705842
 * @author Administrator
 * 
 * https://blog.csdn.net/qq_33429968/article/details/75212326#comments
 */

public class CollectionTest {
	/**
	 * 应用场景（一）：
	 * 1.对list<map>中map中某个指定的key的value的去重，得到新的list：去除了重复出现指定key的value值得
	 * map示例：要求：过滤掉电话相同的map    
	 */
	public static void main(String[] args) {
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		Map<String, Object> mapStr1 = new HashMap<String, Object>();
		mapStr1.put("name", "丽丽");
		mapStr1.put("sex", "女");
		mapStr1.put("age", 22);
		mapStr1.put("tel", "110");
		Map<String, Object> mapStr2 = new HashMap<String, Object>();
		mapStr2.put("name", "丽丽");
		mapStr2.put("sex", "女");
		mapStr2.put("age", 23);
		mapStr2.put("tel", "120");
		Map<String, Object> mapStr3 = new HashMap<String, Object>();
		mapStr3.put("name", "丽丽");
		mapStr3.put("sex", "女");
		mapStr3.put("age", 24);
		mapStr3.put("tel", "110");
		mapList.add(mapStr1);
		mapList.add(mapStr2);
		mapList.add(mapStr3);
		
		//过滤掉电话相同的map数据
		List<Map<String,Object>> filterTel = mapList.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(
				() -> new TreeSet<>(new Comparator<Map<String,Object>>() {
					@Override
					public int compare(Map<String, Object> o1, Map<String, Object> o2) {
						if(o1.get("tel").equals(o2.get("tel"))){
							return 0;
						}else {
							return 1;
						}
					}
				})
			), ArrayList::new));
		filterTel.forEach(m-> {
			System.out.println("======map=======");
			m.keySet().forEach(n->System.out.println(n+"-->"+m.get(n)));
		});
	}
}
