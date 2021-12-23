package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.bankk;
import com.example.demo.repository.bankkrepository;
@Service
public class bankkservice {
	
	@Autowired
	private bankkrepository bankkrepository;
	
	@Autowired
	private custseqservice custseqservice;

	public void addbankk(bankk bankk) {
		int bankkid=custseqservice.getseq("bankkseq");
		bankk.setId(bankkid);
	     bankkrepository.save(bankk);
		
	}

	public List<bankk> getallbankk() {
		return bankkrepository.findAll();
		
	}
	public String updatebankk(bankk bankk, int bankkid) {
		Optional<bankk> bank1=bankkrepository.findById(bankkid);
		if(bank1.isPresent()) {
			bank1.get().setName(bankk.getName());
			bank1.get().setLocation(bankk.getLocation());
		
			bankkrepository.save(bank1.get());
			return "bank updated successfully";
		
		}
		else
		{
			return "bank not found";
		}
	}
		
		public String deletebankk(int id) {
			Optional<bankk> bankk1=bankkrepository.findById(id);
			if(bankk1!=null) {
				
				bankkrepository.deleteById(id);
				return "bank deleted successfully";
			}
			else {
				return "bankk not found";
			}
			
		}
		
     	public int getbankkcountbyname(String name)
	    {
	      int count=bankkrepository.getbankkcountbyname(name);
              return count;
		}

		
		
}