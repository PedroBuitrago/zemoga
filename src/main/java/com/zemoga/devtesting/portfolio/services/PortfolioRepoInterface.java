package com.zemoga.devtesting.portfolio.services;

import org.springframework.data.repository.CrudRepository;

import com.zemoga.devtesting.portfolio.entitiy.Portfolio;

public interface PortfolioRepoInterface  extends CrudRepository<Portfolio, Integer> {

}
