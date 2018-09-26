package demo;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MongoDBTest {
    @Test
    public void test01() {
        //创建连接
        MongoClient mongoClient = new MongoClient("127.0.0.1");
        //打开数据库
        MongoDatabase spitdb = mongoClient.getDatabase("spitdb");
        //获取集合
        MongoCollection<Document> spit = spitdb.getCollection("spit");
        //查询记录获取文档集合
        FindIterable<Document> documents = spit.find();
        for (Document document : documents) {
            System.out.println(document.getString("content"));
            System.out.println(document.getString("userid"));
            //System.out.println(document.getString("visits"));
        }
        mongoClient.close();
    }

    /**
     * 条件查询
     */
    @Test
    public void test02(){
        //创建连接
        MongoClient client = new MongoClient("127.0.0.1");
        //打开数据库
        MongoDatabase spitdb = client.getDatabase("spitdb");
        //获取集合
        MongoCollection<Document> spit = spitdb.getCollection("spit");
        //构建查询条件
        BasicDBObject basicDBObject = new BasicDBObject("userid","1011");
        //查询记录，获取结果集合
        FindIterable<Document> documents = spit.find(basicDBObject);
        for (Document document : documents) {
            System.out.println(document.getString("content"));
        }
        client.close();
    }

    /**
     * 查询浏览量大于1000的记录
     */
    @Test
    public void test03(){
        //创建连接
        MongoClient client = new MongoClient("127.0.0.1");
        //打开数据库
        MongoDatabase spitdb = client.getDatabase("spitdb");
        //获取集合
        MongoCollection<Document> spit = spitdb.getCollection("spit");
        //构造查询条件
        BasicDBObject bson = new BasicDBObject("userid", new BasicDBObject("$gt", 1000));
        //查询记录，获取结果集合
        FindIterable<Document> documents = spit.find(bson);
        //遍历结果集
        for (Document document : documents) {
            System.out.println(document.getString("content"));
        }
        //关闭资源
        client.close();
    }

    /**
     * 插入数据
     */
    @Test
    public void test04(){
        //创建连接
        MongoClient mongoClient = new MongoClient("127.0.0.1");
        //打开数据库
        MongoDatabase spitdb = mongoClient.getDatabase("spitdb");
        //获取集合
        MongoCollection<Document> spit = spitdb.getCollection("spit");
        Map<String,Object> map = new HashMap<>();
        map.put("content","我要吐槽");
        map.put("userid","1234");
        map.put("visits",1234);
        map.put("publishtime",new Date());
        Document document = new Document(map);
        spit.insertOne(document);
        mongoClient.close();
    }
}