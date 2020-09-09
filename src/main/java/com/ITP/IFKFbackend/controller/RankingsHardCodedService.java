package com.ITP.IFKFbackend.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ITP.IFKFbackend.model.Rankings;

@Service
public class RankingsHardCodedService {
	
	private static List<Rankings> rankings = new ArrayList<Rankings>();
	private static long idCounter = 0;
	
	static {
		rankings.add(new Rankings(++idCounter, "ST001", "1st Dan Black Belt", new Date()));
		rankings.add(new Rankings(++idCounter, "ST002", "1st Kyu Brown Belt", new Date()));
		rankings.add(new Rankings(++idCounter, "ST003", "10th Kyu White Belt", new Date()));
	}
	
	//get all rankings of a particular student
	public List<Rankings> findAll() {
		return rankings;
	}
	
	
	//delete a ranking recode
	public Rankings deleteById(long rankingsId) {
		Rankings rankRecorde = findById(rankingsId);
		
		if(rankRecorde == null) return null;
		
		if(rankings.remove(rankRecorde)) {
			return rankRecorde;
		}
		
		return null;
	}

	
	//find a ranking record
	public Rankings findById(long rankingsId) {

		for(Rankings rank:rankings) {
			if(rank.getRankingsId() == rankingsId) {
				return rank;
			}
		}
		
		return null;
	}
	
	
	//update and insert ranking record
	public Rankings save(Rankings rank) {
		if(rank.getRankingsId() == -1 || rank.getRankingsId() == 0) {
			rank.setRankingsId(++idCounter);
			rankings.add(rank);
		}else {
			deleteById(rank.getRankingsId()); 
			rankings.add(rank);
		}
		return rank;
	}

}
