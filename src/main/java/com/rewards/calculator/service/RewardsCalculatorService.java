package com.rewards.calculator.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import com.rewards.calculator.entity.CustomerRewards;

public interface RewardsCalculatorService {
	
	public List<CustomerRewards> rewardsCal() throws URISyntaxException, IOException;

}
