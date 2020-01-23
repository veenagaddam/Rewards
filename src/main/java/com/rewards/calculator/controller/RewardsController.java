package com.rewards.calculator.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rewards.calculator.entity.CustomerRewards;
import com.rewards.calculator.service.RewardsCalculatorService;

@RestController
@RequestMapping("/rewards")
public class RewardsController {
	
	@Autowired
	RewardsCalculatorService rewardsCalculatorService;
	
	/**
	 * This is controller class. 
	 * Based on the URI mapping request will come to this controller to calculate rewards
	 * 
	 * Controller then invokes service class where all the business logic to calculate rewards is present
	 * 
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	@RequestMapping(value="/initcache",  method = {RequestMethod.GET})
	public List<CustomerRewards> rewards() throws URISyntaxException, IOException {
		List<CustomerRewards> customerRewards = rewardsCalculatorService.rewardsCal();
		return customerRewards;
		
	}
}
