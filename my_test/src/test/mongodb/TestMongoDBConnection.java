package test.mongodb;

import java.net.UnknownHostException;

import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class TestMongoDBConnection {
    public static void main(String[] args) throws JSONException {
        try {
            Mongo mongo = new Mongo("192.168.2.107", 27017);
            // System.out.println(mongo.getDatabaseNames());
            DB db = mongo.getDB("admin");
            boolean auth = db.authenticate("super", "sup".toCharArray());
            System.out.println(auth);
            // mongo.getDB("test").command("serverStatus");
            CommandResult result = db.command("serverStatus");
            // System.out.println(db.command("serverStatus"));
            System.out.println(result.get("indexCounters").toString());
            System.out.println(new JSONObject(result.get("indexCounters").toString()).getJSONObject("btree").get(
                    "accesses"));
            // // JSONObject jsonObject = new JSONObject(db.command("serverStatus"));
            System.out.println(db.command("dbStats"));
        } catch (UnknownHostException e) {
            System.out.println(e);
            e.printStackTrace();
        } catch (MongoException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
