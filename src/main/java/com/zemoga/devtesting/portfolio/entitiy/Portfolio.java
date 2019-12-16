package com.zemoga.devtesting.portfolio.entitiy;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.social.twitter.api.Tweet;

@Entity
@Table(name="portfolio")
public class Portfolio {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@SequenceGenerator(name="seq", sequenceName = "hibernate_sequence", allocationSize=50)
	@Column(name = "idportfolio", updatable = false, nullable = false)
	private Integer id;
	@Column(name="image_url")
	private String imageURL;
	private String title;
	private String description;
	
	@Column(name="twitter_user_name")
	private String twitter;
	
	@Transient
	private List<Tweet> tweets; 
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Tweet> getTweets() {
		return tweets;
	}
	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	@Override
	public String toString() {
		return "Portfolio [id=" + id + ", imageURL=" + imageURL + ", title=" + title + ", description=" + description
				+ ", twitter=" + twitter + "]";
	}
	
	
	
}
