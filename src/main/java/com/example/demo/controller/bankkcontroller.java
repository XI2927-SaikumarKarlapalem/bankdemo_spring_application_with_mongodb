package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.bankk;
import com.example.demo.service.bankkservice;
import com.example.demo.repository.bankkrepository;

@RestController
@RequestMapping("/api")
public class bankkcontroller {
	@Autowired
	private bankkservice bankkservice;

	
	
	
	@PostMapping("/bankk")
	public String addbankk(@RequestBody bankk bankk)
	{
        bankkservice.addbankk(bankk);
        return "added";
}
	@GetMapping("/bankk")
	public List<bankk> getallbankk()
	{
      List<bankk> allbankk= bankkservice.getallbankk();
        return allbankk;
}
	
	@PutMapping("bankk/{id}")
	public String updatebankk(@RequestBody bankk bankk,@PathVariable("id") int bankkid)
	{
		String message=bankkservice.updatebankk(bankk,bankkid);
		return message;
	}
	
	@DeleteMapping("bankk/{id}")
	public String deletebankk(@PathVariable("id") int id)
	{
		String message=bankkservice.deletebankk(id);
		return message;
	}
	
	@GetMapping("/bankk/countbyname/{name}")
	public int getbankkcountbyname(@PathVariable String name)
	{
	    int count=bankkservice.getbankkcountbyname(name);
	    return count;
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
}