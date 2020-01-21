package com.rewards.calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rewards.calculator.entity.RewardsCalculatorEntity;

@Repository
public interface RewardsCalculatorRepository extends JpaRepository<RewardsCalculatorEntity,String>{

}
