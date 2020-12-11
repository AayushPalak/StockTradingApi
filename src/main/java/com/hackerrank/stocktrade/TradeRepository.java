package com.hackerrank.stocktrade.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hackerrank.stocktrade.model.Trade;

@Repository
public interface TradeRepository extends CrudRepository<Trade, Integer> {

}
