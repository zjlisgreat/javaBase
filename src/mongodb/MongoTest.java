package mongodb;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoTest {
	public static void main(String[] args) {
		MongoClient client = new MongoClient("localhost", 27017);
		//获取数据库连接对象
		MongoDatabase database =  client.getDatabase("test");
		
		//获取集合
		MongoCollection<Document> collection = database.getCollection("test_db");
		
		//新增单个文档
//		Document document = new Document("name","张三").append("sex", "男").append("age", 18);
//		collection.insertOne(document);
		
		//新增多个文档
//		List<Document> docs = new ArrayList<Document>();
//		for (int i = 0; i < 4; i++) {
//			Document doc = new Document("name","rose"+i).append("sex",i/2==0?"女":"男" ).append("age", 18+i);
//			docs.add(doc);
//		}
//		collection.insertMany(docs);
		
		//删除文档
		//申明删除条件
//		Bson bson = Filters.eq("age", 19);
//		collection.deleteOne(bson);
		
		//删除多个文档 TODO
		
		//更新单个文档 TODO
		
		//更新多个文档 TODO
		
		//查询
		//查全部
//		MongoCursor<Document>  cursor = it.iterator();
//		while (cursor.hasNext()) {
//			System.out.println(cursor.next());
//		}
		//查第一个
		FindIterable<Document> it = collection.find().limit(1).skip(2);
		Document doc = it.first();
		System.out.println(doc);
		
		
		client.close();
	}
}
