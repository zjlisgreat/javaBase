package mongodb;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoTest {
	public static void main(String[] args) {
		MongoClient client = new MongoClient("localhost", 27017);
		//获取数据库
		MongoDatabase database =  client.getDatabase("test");
		//获取集合
		MongoCollection<Document> collection = database.getCollection("test_db");
		
		//插入单个文档
//		Document document = new Document("name","张三").append("sex", "男").append("age", 18);
//		collection.insertOne(document);
		List<Document> docs = new ArrayList<Document>();
		for (int i = 0; i < 4; i++) {
			Document doc = new Document("name","jack"+i).append("sex",i/2==0?"男":"女" ).append("age", 19+i);
			docs.add(doc);
		}
		collection.insertMany(docs);
	}
}
