package com.example.demo;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	UserRepository ur;
	
	@GetMapping
	
	public User getId(@PathVariable int id)
	{
		return ur.findById(id).orElse(null);	}
	
	@PostMapping
	public User saveAll(@RequestBody User u)
	{
		User ue = new User();
		ue.setFirst_name(u.getFirst_name());
		ue.setLast_name(u.getLast_name());
		List<Vechicle> list=new ArrayList<>();
		
		for(Vechicle v:u.getVechicle())
		{
			Vechicle ve =new Vechicle();
			ve.setVechicle(ue);
			ve.setUser(u);
			
			list.add(ve);
			
		}
		ue.setVechicle(list);
		return u.save(ue);
		
	}

	
	@PutMapping("/{id}")
	
	public User putId(@PathVariable int id,@RequestBody User u)
	{
		User ue =ur.findById(id).orElseThrow();
		return ur.save(u);
		
	}
	
@DeleteMapping("/{id}")
	
	public void User deleteId(@PathVariable int id)
	{
	ur.deleteById(id);
	
		 
		
	}


}
