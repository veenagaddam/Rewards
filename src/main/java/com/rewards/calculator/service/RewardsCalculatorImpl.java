package com.rewards.calculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rewards.calculator.repository.RewardsCalculatorRepository;

@Service
public class RewardsCalculatorImpl implements RewardsCalculatorService{
	
	@Autowired
	RewardsCalculatorRepository rewardsCalculatorRepository;

}
