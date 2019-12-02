package jfinal;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.CaseInsensitiveContainerFactory;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.dialect.PostgreSqlDialect;
import com.jfinal.plugin.druid.DruidPlugin;

public class JFinalDemo {
	public static void main(String[] args) {
		PropKit.use("db.properties");
		DruidPlugin dp = new DruidPlugin(PropKit.get("jdbc.url"), PropKit.get("jdbc.username"), PropKit.get("jdbc.password"));
		System.out.println("url="+PropKit.get("jdbc.url"));
		ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
		arp.setDialect(new PostgreSqlDialect());
		arp.setContainerFactory(new CaseInsensitiveContainerFactory(true));
		dp.start();
		arp.start();
		List<Record> allRecords = Db.find("select * from user");
		System.out.println(JSONObject.toJSONString(allRecords));
		
		
		
//		String modelPack = "com.glyh.yoao.model.api";
//		System.out.println(packetToPath(modelPack));
	}
	
	/**
	 * 包名转目录名
	 * @param packet
	 * @return
	 */
	public static String packetToPath(String packet) {
		String path = packet.replaceAll("\\.", "\\\\\\\\");
		return path;
	}
	
	 //名称转骆驼法
    public static String toCamelName(String name,boolean type){
        //首字母转换为大写
        if(type){
            name = name.substring(0,1).toUpperCase()+name.substring(1);
        }else{
            name = name.substring(0,1).toLowerCase()+name.substring(1);
        }

        int k=name.length()-1;
        for(int i=0;i<k;i++){
            if(name.substring(i,i+1).equals("_")){
                if(i+2<=name.length()){
                    name=name.substring(0,i)+name.substring(i+1,i+2).toUpperCase()+name.substring(i+2);
                    k--;
                }
            }
        }
        return name;
    }

}
