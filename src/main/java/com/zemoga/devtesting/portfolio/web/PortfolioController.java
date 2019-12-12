package com.zemoga.devtesting.portfolio.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zemoga.devtesting.portfolio.entitiy.Portfolio;

@Controller
public class PortfolioController {

	@Autowired
	RestController controller;
	
	@Autowired
	private Twitter twitter;
	
	@GetMapping("/info")
	public 	String initialInfo(Model model) {
		
		Iterable<Portfolio> it = controller.findAll();
		
		for (Portfolio p : it) {
			System.out.println(p.getTwitter());			
		}
		model.addAttribute("users", it);
		return "portfolio";
	}
	
	@GetMapping("/viewportfolio")
	public 	String viewUser(@RequestParam(name="id", required=true) String id, Model model) {
	
		Integer idUser = Integer.valueOf(id);
		Portfolio p = controller.getInfo(idUser);
		p.setTweets(getTweets(p.getTwitter(), 5));
		model.addAttribute("ref", p );
		return "viewportfolio";
		
	}
	
	private List<Tweet> getTweets(String twitterUser, int number) {
		
		if (!twitterUser.startsWith("@")) twitterUser="@" + twitterUser;
		
		List<Tweet> tweets = twitter.timelineOperations().getUserTimeline(twitterUser).subList(0, number);
		
		return tweets;
	}
	
	
		
}
