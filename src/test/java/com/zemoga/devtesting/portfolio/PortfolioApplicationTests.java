package com.zemoga.devtesting.portfolio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
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
	
	public static Integer id;
	
	@Test
	@Order(1)
	void test1() {
		
		Iterable<Portfolio> it = controller.findAll();
		//Prueba tribual obtención de todos los registros				
		assertEquals(true, true);
	}
	
	@Test
	@Order(2)
	void test2() {
		Portfolio p = new Portfolio();
		p.setDescription("Testing Desc");
		p.setTitle("Testing Name");
		p.setTwitter("pbuitrag");
		p = portfolioService.save(p);
		id = p.getId();
		System.out.println("##########################");
		System.out.println("Nuevo id: " + id);
		System.out.println("##########################");
		
		assertNotEquals(p.getId(), null);
		
	}
	
	@Test
	@Order(3)
	void test3() {
		System.out.println("##########################");
		System.out.println("##########################");
		System.out.println(id);
		System.out.println("##########################");
		System.out.println("##########################");
		Optional<Portfolio> p = portfolioService.findById(id);
		assertTrue(p.isPresent());
	}

	@Test
	@Order(4)
	void test4() {
		System.out.println("##########################");
		System.out.println("##########################");
		System.out.println(id);
		System.out.println("##########################");
		System.out.println("##########################");
		portfolioService.deleteById(id);
		assertEquals(true, true);
	}
}
