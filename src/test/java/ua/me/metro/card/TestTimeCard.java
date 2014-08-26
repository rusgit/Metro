package ua.me.metro.card;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Test;

import ua.me.metro.domain.Card;
import ua.me.metro.domain.TimeCard;
import ua.me.metro.domain.TimeCard.ValidityTime;

public class TestTimeCard {

	private TimeCard timeCard;
	private Date expirationDate = new Date();

	@After
	public void tearDown() throws Exception {
		timeCard = null;
	}
		
	@Test
	public void testTimeCardCorrectParam() {
		
		int id = 1;
		boolean active = true;
		ValidityTime validity = ValidityTime.MONTH;
		
		timeCard = new TimeCard(id, active, validity, expirationDate);
	
		assertEquals(id, (int) timeCard.getId());
		assertTrue(timeCard.isActive());
		assertEquals(validity, timeCard.getValidity());
		assertEquals(expirationDate, timeCard.getExpirationDate());
				
	}
	
	@Test
	public void testTimeCardCorrectUse() {
	
		timeCard = new TimeCard(1,true,ValidityTime.MONTH, null);		
		
		assertTrue(timeCard.use(timeCard));
		
		Calendar calendar = new GregorianCalendar();
		calendar.add(Calendar.MONTH, 1);
		expirationDate = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY");
		
		assertEquals(sdf.format(expirationDate), sdf.format(timeCard.getExpirationDate()));
	
		
	}
	

	@Test
	public void testTimeCardGetType() {
		timeCard = new TimeCard(1,true,ValidityTime.MONTH, expirationDate);	
		assertEquals(Card.CardType.TIME, 
				timeCard.getCardType()); 
	
	}
}
