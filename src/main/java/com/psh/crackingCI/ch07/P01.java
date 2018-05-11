package com.psh.crackingCI.ch07;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;

/**
 * Created by Naver on 2018. 5. 11..
 */
public class P01 {
}

enum Suit {
	HEART,
	SPADE,
	CLUB,
	DIAMOND;
}

abstract class Card {
	protected Suit suit;
	/* 1: Ace, 11:Jack, 12: Queen, 13:King */
	protected int number;

	public Card(Suit suit, int number) {
		this.suit = suit;
		this.number = number;
	}

}

class BlackJackCard extends Card {

	public BlackJackCard(Suit suit, int number) {
		super(suit, number);
	}

	public static Set<Integer> getSum(List<Card> cards) {
		Set<Integer> sums = new HashSet<>();
		for(Card card : cards) {
			if (card.number == 1) {
				for (Integer s : sums) {
					sums.add(s + 1);
					sums.add(s + 11);
				}
			} else {
				for (Integer s : sums) {
					sums.add(s + card.number);
				}
			}
		}
		return sums;
	}
}