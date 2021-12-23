package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import org.springframework.stereotype.Service;


import com.example.demo.entity.custseq;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.springframework.data.mongodb.core.query.Update;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
@Service
public class custseqservice {
	@Autowired
	private MongoOperations mongoop;
	public int getseq(String seqid)
	{
	   custseq count=mongoop.findAndModify(query(where("_id").is(seqid)), new Update().inc("seq",1), options().returnNew(true).upsert(true),custseq.class);
	   return count.getSeq();
	}
	

}
