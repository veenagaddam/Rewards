package com.rewards.calculator.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rewards.calculator.entity.CustomerRewards;
import com.rewards.calculator.entity.RewardsCalculatorEntity;
import com.rewards.calculator.repository.RewardsCalculatorRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RewardsCalculatorImpl implements RewardsCalculatorService{
	
	@Autowired
	RewardsCalculatorRepository rewardsCalculatorRepository;
	
/*	public List<RewardsCalculatorEntity> calculateRewards() throws URISyntaxException, IOException {
		//List<RewardsCalculatorEntity> transactions = rewardsCalculatorRepository.findAll();
		 Path path = Paths.get(getClass().getClassLoader()
			      .getResource("fileTest.txt").toURI());
			          
			    Stream<String> lines = Files.lines(path);
			    String data = lines.collect(Collectors.joining("\n"));
			    System.out.println("Data ::" + data);
				return null;
		
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
	}*/

	@Override
	public List<CustomerRewards> rewardsCal() throws URISyntaxException, IOException {
		// TODO Auto-generated method stub
		Path path = Paths.get(getClass().getClassLoader()
			      .getResource("Rewards.txt").toURI());
			    List<CustomerRewards> customerRewardsList = new ArrayList<>();
			    Stream<String> lines = Files.lines(path);
			    Set<String> customerIdSet = new HashSet<>();
			    List<RewardsCalculatorEntity> rewardsCalculatorEntityList = new ArrayList<>();
/*			    String data = lines.collect(Collectors.joining("\n"));
			    System.out.println("Data ::" + data);*/
			    lines.forEach(l -> {
				   log.debug(" l ::" + l.toString());
			    	String[] lineSplit = l.split("\\|");
			    	log.debug(" lineSplit ::" + Arrays.toString(lineSplit));
			    	RewardsCalculatorEntity rewardsCalculatorEntity = new RewardsCalculatorEntity();
			    	customerIdSet.add(lineSplit[0]);
			    	rewardsCalculatorEntity.setCustomerId(lineSplit[0]);
			    	rewardsCalculatorEntity.setTransactionId(lineSplit[1]);
			    	rewardsCalculatorEntity.setTransactionDate(lineSplit[2]);
			    	rewardsCalculatorEntity.setAmount(Integer.parseInt(lineSplit[3]));
			    	rewardsCalculatorEntityList.add(rewardsCalculatorEntity);
			    });
			    log.debug("rewardsCalculatorEntityList ::" + rewardsCalculatorEntityList.toString());
			    /*customerIdSet.stream().map(id -> {
			    	List<RewardsCalculatorEntity> transactionList = rewardsCalculatorEntityList.stream().filter(i -> 
			    		i.getCustomerId().equals(id)
			    	).collect(Collectors.toList());
			    	return transactionList;
			    }).collect(collector);*/
			   LocalDate date = LocalDate.now().minusDays(90);
			    customerIdSet.forEach(id -> {
			    	/*List<RewardsCalculatorEntity> transactionList = rewardsCalculatorEntityList.stream().filter(i -> 
		    		(i.getCustomerId().equals(id) && pastThreeMonths.isBefore(i.getTransactionDate()))*/
			    	/*List<RewardsCalculatorEntity> transactionList = rewardsCalculatorEntityList.stream().filter(i -> 
		    		(i.getCustomerId().equals(id))*/
			    	List<RewardsCalculatorEntity> transactionList = rewardsCalculatorEntityList.stream().filter(i -> 
		    		(i.getCustomerId().equals(id) && date.isBefore(LocalDate.parse(i.getTransactionDate())))
		    	).collect(Collectors.toList());
			    	log.debug("transactionList ::" + transactionList.toString());
			    	CustomerRewards rewardsEarned = rewardsCalculator(transactionList,id);
			    	log.debug("rewardsEarned ::" + rewardsEarned.toString());
			    	customerRewardsList.add(rewardsEarned);
			    });
			    /*String[] lineData = lines.map( l -> {
			    	return l.split("|");
			    });*/
			   /* System.out.println("lines ::" + lines.toString());
			    String data = lines.collect(Collectors.joining("\n"));
			    System.out.println("Data ::" + data);*/
				return customerRewardsList;
	}
	
	private CustomerRewards rewardsCalculator(List<RewardsCalculatorEntity> transactionList,String customerId) {
		int rewards = 0;
		log.debug("customerId ::" + customerId);
		for(RewardsCalculatorEntity transaction : transactionList) {
			log.debug("transaction ::" + transaction.toString());
			if (transaction.getAmount() > 100) {
			    int amountForRewards = transaction.getAmount() - 100;
			    rewards += amountForRewards*2 + 50;
			  } else if (transaction.getAmount() > 50) {
		            int amountForRewards = transaction.getAmount() - 50;
			    rewards += amountForRewards;
			  }
		}
		/*transactionList.forEach(transaction -> {
			  if (transaction.getAmount() > 100) {
			    int amountForRewards = transaction.getAmount() - 100;
			    rewardss += amountForRewards*2 + 50;
			  } else if (transaction.getAmount() > 50) {
		            int amountForRewards = transaction.getAmount() - 50;
			    rewardss += amountForRewards;
			  }
			});*/
		return new CustomerRewards(customerId, rewards);
	}

}
 