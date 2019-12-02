package utils.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 * 这4个JSON类库分别为：Gson，FastJson，Jackson，Json-lib。
 * @author zjl
 *https://blog.csdn.net/zl1zl2zl3/article/details/85536515
 */
public class JSONUtilDemo {

	public static void main(String[] args) {
		List<Map<String,Object>> list  = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("order", "1111");
		map.put("create_time", new Date());
		list.add(map);
		Map<String,Object> map1 = new HashMap<String,Object>();
		map1.put("order", "2222");
		map1.put("create_time", new Date());
		list.add(map1);
		System.out.println(JSONObject.toJSONString(list,true));
		
		System.out.println(JSONObject.toJSONString(null));
	}
}
