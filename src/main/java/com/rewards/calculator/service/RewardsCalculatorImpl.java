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
		List<RewardsCalculatorEntity> transactions = rewardsCalculatorRepository.findAll();
		int rewards = 0;
		transactions.map(transaction => {
		  if (transaction > 100) {
		    int amountForRewards = transaction - 100;
		    rewards += amountForRewards*2 + 50;
		  } else if (transaction > 50) {
	            int amountForRewards = transaction - 50;
		    rewards += amountForRewards;
		  }
		});
		    return rewards;
	}

}
