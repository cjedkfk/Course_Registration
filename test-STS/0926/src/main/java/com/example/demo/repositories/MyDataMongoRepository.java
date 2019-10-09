package com.example.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.MyDataMongo;
import java.util.List;

public interface MyDataMongoRepository extends MongoRepository<MyDataMongo, Long> 
{
	public List<MyDataMongo> findById(String i);
	public List<MyDataMongo> findByName(String s);
}