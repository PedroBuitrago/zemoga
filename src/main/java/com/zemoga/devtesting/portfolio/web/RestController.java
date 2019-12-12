package com.zemoga.devtesting.portfolio.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zemoga.devtesting.portfolio.entitiy.Portfolio;
import com.zemoga.devtesting.portfolio.services.PortfolioRepoInterface;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	PortfolioRepoInterface portfolioService;
	
	@GetMapping(path="/zemoga_portfolio_api/userinfo/{id}", produces = "application/json")
	public Portfolio getInfo(@PathVariable Integer id) {
		 
		Optional<Portfolio> user = portfolioService.findById(id);
		
		if (user.isPresent()) {
			return user.get();
		}
		 
		return null;
	 }
	
	@PostMapping(path="/zemoga_portfolio_api/modify_user_info/{id}", produces = "application/json", 
			consumes = "application/json")
	public Portfolio setInfo(@PathVariable Integer id, @RequestBody(required = false) ObjectNode node) {
		
		Portfolio p = getInfo(id);
		boolean flag = false;
		
		
		if (p != null) {
			JsonNode nameJN = node.get("name");
			JsonNode imageUrl = node.get("image");
			JsonNode description = node.get("description");
		
			if (imageUrl != null && ! imageUrl.asText().isEmpty() ) {
				flag = true;
				p.setImageURL(imageUrl.asText());
			}
			if ( nameJN!= null && !nameJN.asText().isEmpty()) {
				flag = true;
				p.setTitle(nameJN.asText());
				
			}
			if ( description !=null && ! description.asText().isEmpty() ) {
				flag = true;
				p.setDescription(description.asText());
			}
			
			if (  flag )try {
				p =  portfolioService.save(p);
			}catch(Exception e) {e.printStackTrace();}
			
			return p;
		}
		else
			return null;
		
		
		
	}
	
	public Iterable<Portfolio> findAll(){
		return portfolioService.findAll();
	}
}
