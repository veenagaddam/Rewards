package com.rewards.calculator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;


import lombok.Data;

@Data
@Table
@Entity(name = "CUSTOMER_REWARDS")
public class RewardsCalculatorEntity {
	
	@Id
	@Column(name = "TRANSACTION_ID")
	private String transactionId;
		
	@Column(name = "CUSTOMER_ID")
	private String customerId;
	
	@Column(name = "AMOUNT")
	private String amount;
	
	@Column(name= "TRANS_DATE")
	private String transactionDate;
	
	@Column(name = "REWARDS_EARNED")
	private String rewardsEarned;
}
