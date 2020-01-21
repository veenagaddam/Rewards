package com.rewards.calculator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rewards.calculator.entity.RewardsCalculatorEntity;
import com.rewards.calculator.repository.RewardsCalculatorRepository;

@Service
public class RewardsCalculatorImpl implements RewardsCalculatorService{
	
	@Autowired
	RewardsCalculatorRepository rewardsCalculatorRepository;
	
	public List<RewardsCalculatorEntity> calculateRewards() {
		List<RewardsCalculatorEntity> rewardCalculatorEntity = rewardsCalculatorRepository.findAll();
		
		return null;
		
	}

}
