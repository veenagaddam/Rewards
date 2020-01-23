package com.rewards.calculator.entity;

import lombok.Data;

@Data
public class CustomerRewards {
	
	private String customerId;
	
	private int rewards;
	
	public CustomerRewards(String customerId, int rewards) {
		super();
		this.customerId = customerId;
		this.rewards = rewards;
	}

	public CustomerRewards() {
		// TODO Auto-generated constructor stub
	}


}
