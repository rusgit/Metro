package ua.me.metro.card;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import ua.me.metro.domain.Card;
import ua.me.metro.domain.NumberCard;

public class TestNumberCard {

	private NumberCard numberCard;
	
	@After
	public void tearDown() throws Exception {
		numberCard = null;
	}
		
	@Test
	public void testNumberCardCorrectParam() {			
		int id = 1;
		boolean active = true;
		int numberTrip = 20;	
		numberCard = new NumberCard(id,active,numberTrip);
		
		assertEquals(id, (int) numberCard.getId());
		
		assertTrue(numberCard.isActive());
		
		assertEquals(numberTrip, numberCard.getNumberTrip());
		
	}
	
	@Test
	public void testNumberCardCorrectUse() {		
		numberCard = new NumberCard(1,true,20);
		
		assertTrue(numberCard.use(numberCard));
		
		assertEquals(19, numberCard.getNumberTrip());
		
		
	}
	@Test
	public void testNumberCardGetType() {
		numberCard = new NumberCard(1,true,20);
		
		assertEquals(Card.CardType.NUMBER, numberCard.getCardType()); 
	
	}

}
