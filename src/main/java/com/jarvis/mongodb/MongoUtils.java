package com.jarvis.mongodb;

import org.bson.Document;

import com.mongodb.ConnectionString;
import com.mongodb.async.SingleResultCallback;
import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoClients;
import com.mongodb.async.client.MongoCollection;
import com.mongodb.async.client.MongoDatabase;

public class MongoUtils {
	
	MongoClient c;
	MongoDatabase db;
	static MongoCollection<Document> collection;
	boolean isConnected = false;
	
	public void establishConnection(ConnectionString s, SimpleSettings n) {
		if (c == null) {
			c = MongoClients.create(s);
			db = c.getDatabase(n.db);
			collection = db.getCollection(n.col);
			isConnected = true;
		}
	}
	
	public static void insertElement() {
			Document doc = new Document("Data", "Data")
					.append("This is a", "Test")
					.append("Is this a boolean?", true)
					.append("How many?", 1);
			collection.insertOne(doc, new SingleResultCallback<Void>() {

				@Override
				public void onResult(Void result, Throwable t) {
					// TODO Auto-generated method stub
					System.out.println("Inserted!");
					if (t != null) {
						t.printStackTrace();
					}
				}
			} 
		);
	}
}
