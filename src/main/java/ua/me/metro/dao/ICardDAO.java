package ua.me.metro.dao;

import java.sql.SQLException;
import java.util.List;

import ua.me.metro.domain.Card;
import ua.me.metro.domain.User;
import ua.me.metro.exceptions.NotFoundException;
import ua.me.metro.exceptions.IllegalParameterException;

public interface ICardDAO {
	
		/**
		 * Add card to DB
		 * @param card : Card
		 * @throws SQLException, IllegalParameterException
		 */
	    public void addCard(Card card) throws SQLException, IllegalParameterException;
	    
	    /**
	     * Get card by ID from DB
	     * @param id : int (Card.id)
	     * @return Card by id
	     * @throws SQLException, IllegalParameterException, CardNotFoundException
	     */
	    public Card getCardById(Integer id) throws SQLException, IllegalParameterException, NotFoundException;
	    
	    /**
	     * Update card from DB
	     * @param card : Card
	     * @throws SQLException, IllegalParameterException  
	     */
	    public void updateCard(Card card) throws SQLException, IllegalParameterException;
	    
	    /**
	     * Get list of cards by range of id 
	     * @param fromId
	     * @param toId
	     * @return List<Card>
	     */
	    public List<Card> getCards(Integer fromId, Integer toId)  throws SQLException, IllegalParameterException, NotFoundException;
	    
         
	    /**
	     * 
	     * @param user
	     * @return
	     * @throws SQLException
	     * @throws IllegalParameterException
	     * @throws NotFoundException
	     */
	    public List<Card> getUserCards(User user)  throws SQLException, IllegalParameterException, NotFoundException;

        /**
         *
         * @param id
         * @throws SQLException
         * @throws IllegalParameterException
         * @throws NotFoundException
         */
        public void deleteCard(Integer id) throws SQLException, IllegalParameterException, NotFoundException;
	}
	

