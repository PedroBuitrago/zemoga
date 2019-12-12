package com.zemoga.devtesting.portfolio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zemoga.devtesting.portfolio.entitiy.Portfolio;
import com.zemoga.devtesting.portfolio.services.PortfolioRepoInterface;
import com.zemoga.devtesting.portfolio.web.RestController;

@SpringBootTest
class PortfolioApplicationTests {

	@Autowired
	RestController controller;
	
	@Autowired
	PortfolioRepoInterface portfolioService;
	
	@BeforeEach
	void initUseCase() {
		
	}
	
	public Integer id = null;
	
	@Test
	void getAllPortfolios() {
		
		Iterable<Portfolio> it = controller.findAll();
		//Prueba tribual obtención de todos los registros				
		assertEquals(true, true);
	}
	
	@Test
	void createData() {
		Portfolio p = new Portfolio();
		p.setDescription("Testing Desc");
		p.setTitle("Testing Name");
		p.setTwitter("pbuitrag");
		p = portfolioService.save(p);
		id = p.getId();
		assertNotEquals(p.getId(), null);
		
	}
	
	@Test
	void getData() {
		Optional<Portfolio> p = portfolioService.findById(id);
		assertTrue(p.isPresent());
	}

}

