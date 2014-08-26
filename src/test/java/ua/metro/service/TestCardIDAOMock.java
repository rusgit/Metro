package ua.metro.service;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import ua.me.metro.dao.ICardDAO;
import ua.me.metro.domain.NumberCard;
import ua.me.metro.exceptions.NotFoundException;
import ua.me.metro.exceptions.IllegalParameterException;
import ua.me.metro.service.impl.CardService;

public class TestCardIDAOMock {
	
	 private static final Integer ID = 1;
	 private static final Integer MINUS_ID = -1;
	 private static final Integer NOTEXIST_ID = 1000;

	 private CardService cardService;
	 private ICardDAO iCardDAOMock;
	  
	 @Before
	 public void setUp() throws Exception {
		cardService = new CardService();
		iCardDAOMock = createMock(ICardDAO.class);
		cardService.setiCardDAO(iCardDAOMock);
	  }
	 
	 @After
	 public void tearDawn() throws Exception {
		cardService = null;
		iCardDAOMock = null;
	  }

	  
///////////////////////// GET CARD ////////////////////////////////////////
	@Test 
	public void testCardDAOMockGetCardById() throws SQLException, 
						IllegalParameterException, NotFoundException {

		NumberCard nc = new NumberCard(1,true,20);
		expect(iCardDAOMock.getCardById(ID)).andReturn(nc).times(1);
		replay(iCardDAOMock);
		
		assertEquals(nc, cardService.getCardById(ID));
		verify(iCardDAOMock);
	}
	
	@Test
	public void testCardDAOMockGetCardByIdMinus() throws SQLException, 
						IllegalParameterException, NotFoundException {
		
		expect(iCardDAOMock.getCardById(MINUS_ID)).andThrow(new IllegalParameterException()).times(1);
		replay(iCardDAOMock);
		
		cardService.getCardById(MINUS_ID);
		verify(iCardDAOMock);
	}
	
	@Test
	public void testCardDAOMockGetCardByIdNull() throws SQLException, 
						IllegalParameterException, NotFoundException {

		expect(iCardDAOMock.getCardById(null)).andThrow(new IllegalParameterException()).times(1);
		replay(iCardDAOMock);
		
		cardService.getCardById(null);
		verify(iCardDAOMock);
	}
	
	@Test
	public void testCardDAOMockGetCardByIdNotFound() throws SQLException, 
						IllegalParameterException, NotFoundException {

		expect(iCardDAOMock.getCardById(NOTEXIST_ID)).andThrow(new NotFoundException()).times(1);
		replay(iCardDAOMock);
	
		cardService.getCardById(NOTEXIST_ID);	
		verify(iCardDAOMock);
	}
	
 ///////////////////////// ADD CARD ////////////////////////////////////////
	
	@Test //
	public void testCardDAOMockAddCard() throws SQLException, 
						IllegalParameterException {

		NumberCard nc = new NumberCard(1,true,20);
		iCardDAOMock.addCard(nc);
		expectLastCall().times(1);
		replay(iCardDAOMock);

	    cardService.addCard(nc);	   	
		verify(iCardDAOMock);
	}
	
	@Test
	public void testCardDAOMockAddCardNull() throws SQLException, 
						IllegalParameterException {

		iCardDAOMock.addCard(null);
	    expectLastCall().andThrow(new IllegalParameterException()).times(1);
		replay(iCardDAOMock);
	
	    cardService.addCard(null);
		verify(iCardDAOMock);
	}
	
 //////////////////////// UPDATE CARD ///////////////////////////////////////
	
	@Test //
	public void testCardDAOMockUpdateCard() throws SQLException, 
						IllegalParameterException {

		NumberCard nc = new NumberCard(1,true,20);
		iCardDAOMock.updateCard(nc);
		expectLastCall().times(1);
		replay(iCardDAOMock);

	    cardService.updateCard(nc);	   	
		verify(iCardDAOMock);
	}
	
	@Test
	public void testCardDAOMockUpdateCardNull() throws SQLException, 
						IllegalParameterException {

		
		iCardDAOMock.updateCard(null);
		expectLastCall().andThrow(new IllegalParameterException()).times(1);
		replay(iCardDAOMock);

		cardService.updateCard(null);
		verify(iCardDAOMock);
	}
	

}
