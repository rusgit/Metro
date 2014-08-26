package ua.me.metro.card;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import ua.me.metro.domain.Card;
import ua.me.metro.domain.UnlimCard;
public class TestUnlimCard {

	private UnlimCard unlimCard;

	@After
	public void tearDown() throws Exception {
		unlimCard = null;
	}
		
	@Test
	public void testUnlimCardCorrectParam() {
		
		int id = 1;
		boolean active = true;
		String name = "Ruslan";
		String lastName = "Borisov";
		
		unlimCard = new UnlimCard(id, active, name, lastName);
	
		assertEquals(id, (int) unlimCard.getId());
		assertTrue(unlimCard.isActive());
		assertEquals(name, unlimCard.getName());
		assertEquals(lastName, unlimCard.getLastName());
				
	}
	
	@Test
	public void testUnlimCardCorrectUse() {	
		
		unlimCard = new UnlimCard(1,true,"Ruslan", "Borisov");	
		assertTrue(unlimCard.use(unlimCard));	
	}
	

	@Test
	public void testUnlimCardGetType() {
		unlimCard = new UnlimCard(1,true,"Ruslan", "Borisov");
		assertEquals(Card.CardType.UNLIM, 
				unlimCard.getCardType()); 
	
	}
}
