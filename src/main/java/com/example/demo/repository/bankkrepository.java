package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.bankk;


public interface bankkrepository extends MongoRepository<bankk, Integer> {



	@Query(value= "{name:?0}",count=true)
	Integer getbankkcountbyname(String name);


	

}
