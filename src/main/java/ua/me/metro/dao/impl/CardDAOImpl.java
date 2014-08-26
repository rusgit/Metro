package ua.me.metro.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import org.springframework.stereotype.Repository;
import ua.me.metro.dao.ICardDAO;
import ua.me.metro.domain.Card;
import ua.me.metro.domain.NumberCard;
import ua.me.metro.domain.UnlimCard;
import ua.me.metro.domain.User;
import ua.me.metro.domain.Card.CardType;
import ua.me.metro.exceptions.NotFoundException;
import ua.me.metro.exceptions.IllegalParameterException;

@Repository("cardDAOImpl")
public class CardDAOImpl implements ICardDAO {

	@Inject
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public void addCard(Card card) throws SQLException, IllegalParameterException {  
		if (card==null) { 
			throw new IllegalParameterException("ADD CARD FAILED: You are trying to add a null card");
		}
		if ((card.getCardType()==CardType.NUMBER)) {
			NumberCard nc = (NumberCard) card;
			if (nc.getNumberTrip()<=0) {
				throw new IllegalParameterException("ADD CARD FAILED: You are trying to add Number Card with number trip 0 or less 0");
			}
		}
		
		if ((card.getCardType()==CardType.UNLIM)) {
			UnlimCard uc = (UnlimCard) card;
			if (uc.getName().length()<=0||uc.getLastName().length()<=0) {
				throw new IllegalParameterException("ADD CARD FAILED: You are trying to add Unlim Card with out Name or LastName");
			}
		}
		
		
		sessionFactory.getCurrentSession().save(card);
	}
	
	public Card getCardById(Integer id) throws SQLException, IllegalParameterException, NotFoundException, NullPointerException {
		if (id==null) {
			throw new IllegalParameterException("GET CARD FAILED: Id cannot be null");
		}
		if (id<=0) {
			throw new IllegalParameterException("GET CARD FAILED: Id cannot be 0 or less 0!");	
		}
		
		Card card = (Card) sessionFactory.getCurrentSession().get(Card.class, id);
			
		if (card==null) {
			throw new NotFoundException("GET CARD FAILED: Card by " + id + " not found");
		} 
			
		return card;
	}
	
	public void updateCard(Card card) throws SQLException, IllegalParameterException {
		if (card==null) { 
			throw new IllegalParameterException("UPDATE CARD FAILED: You are trying to update a null card");
		}
		if ((card.getCardType()==CardType.NUMBER)) {
			NumberCard nc = (NumberCard) card;
			if (nc.getNumberTrip()<0) {
				throw new IllegalParameterException("UPDATE CARD FAILED: You are trying to update Number Card with number trip 0 or less 0");
			}
		}
		if ((card.getCardType()==CardType.UNLIM)) {
			UnlimCard uc = (UnlimCard) card;
			if (uc.getName().length()<=0||uc.getLastName().length()<=0) {
				throw new IllegalParameterException("UPDATE CARD FAILED: You are trying to update Unlim Card with out Name or LastName");
			}
		}
		
		sessionFactory.getCurrentSession().update(card); 

	}

	public List<Card> getCards(Integer fromId, Integer toId)  throws SQLException, IllegalParameterException, NotFoundException {
		if (fromId==null || toId==null) {
			throw new IllegalParameterException("GET CARD FAILED: Id cannot be null");
		}
		if (fromId<=0 || toId<=0) {
			throw new IllegalParameterException("GET CARD FAILED: Id cannot be 0 or less 0!");	
		}
		
		if (fromId.compareTo(toId) == 1) {
			Integer tmp = fromId;
			fromId = toId;
			toId = tmp;
		}
	
		@SuppressWarnings("unchecked")
		List<Card> list = sessionFactory.getCurrentSession().createCriteria(Card.class)
			    .add(Restrictions.between("id", fromId, toId)).addOrder( Order.asc("id")).list();


			
		if (list==null) {
			throw new NotFoundException("GET CARDs FAILED: Cards on range " + fromId + " to " + toId + " not found");
		} 
		
		return list;
	}
	@Override
	public List<Card> getUserCards(User user) throws SQLException, IllegalParameterException, NotFoundException {
		if (user==null) {
			throw new IllegalParameterException("GET CARDs FAILED: user cannot be null");
		}
	
		Query query = sessionFactory.getCurrentSession().
				createQuery("from Card where user =:user");
				query.setParameter("user", user);
				
				@SuppressWarnings("unchecked")
				List<Card> cards = (List<Card>) query.list();
			
		if (cards==null) {
			throw new NotFoundException("GET CARDs FAILED: Cards by user id " + user + " not found");
		} 
		
		return cards;
	}

    @Override
    public void deleteCard(Integer id) throws SQLException, IllegalParameterException, NotFoundException {
        if (id==null) {
            throw new IllegalParameterException("DELETE CARD FAILED: Id cannot be null");
        }
        if (id<=0) {
            throw new IllegalParameterException("DELETE CARD FAILED: Id cannot be 0 or less 0!");
        }

        Card card = (Card) sessionFactory.getCurrentSession().get(Card.class,id);

        if (card==null) {
            throw new NotFoundException("DELETE CARD FAILED: Card by " + id + " not found");
        }
        sessionFactory.getCurrentSession().delete(card);
    }

		          
}


	
