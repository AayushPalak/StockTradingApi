package com.hackerrank.stocktrade.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.repository.TradeRepository;
import com.hackerrank.stocktrade.repository.UserRepository;

@RestController
@RequestMapping(value = "/trades")
public class TradesController {
 
	@Autowired
	TradeRepository tradeRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@DeleteMapping("/erase")
	public ResponseEntity<?> deleteAllTrades() {
		
		tradeRepository.deleteAll();
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Trade>> getAllTrades() {
		
		List<Trade> tradesList = new ArrayList<>();
		tradeRepository.findAll().forEach(element -> tradesList.add(element));
		Collections.sort(tradesList, new Comparator<Trade>() {
			public int compare(Trade t1, Trade t2) {
				return t1.getId().compareTo(t2.getId());
			}
		});
		
		return new ResponseEntity<>(tradesList, HttpStatus.OK);
	}
	
	
}
