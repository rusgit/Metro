package ua.me.metro.service.impl;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.me.metro.dao.ICardDAO;
import ua.me.metro.domain.Card;
import ua.me.metro.domain.NumberCard;
import ua.me.metro.domain.User;
import ua.me.metro.exceptions.NotFoundException;
import ua.me.metro.exceptions.IllegalParameterException;
import ua.me.metro.service.ICardService;

@Service("cardService")
public class CardService implements ICardService {	
	private static final Logger LOG = Logger.getLogger(CardService.class);
	
	@Inject
	private ICardDAO iCardDAO;

	public void setiCardDAO(ICardDAO iCardDAO) {
		this.iCardDAO = iCardDAO;
	}

	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean addCard(Card card) {

        try {
            LOG.debug("START ADDING CARD...");
            iCardDAO.addCard(card);
            LOG.info("Add Card successfully");
            return true;

        } catch (SQLException e) {
            LOG.error(e);
        } catch (IllegalParameterException e) {
            LOG.error(e);
        }

        return false;
	}
	
	@Transactional()
	public Card getCardById(Integer id) {

        try {
            LOG.debug("START GET CARD...");
            Card card = iCardDAO.getCardById(id);
            LOG.info("Get Card successfully");
            return card;

        } catch (SQLException e) {
            LOG.error(e);
        } catch (IllegalParameterException e) {
            LOG.error(e);
        } catch (NotFoundException e) {
            LOG.error(e);
        }

        return null;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean updateCard(Card card) {

        try {
            LOG.debug("START UPDATE CARD...");
            iCardDAO.updateCard(card);
            LOG.info("Update card successfully");
            return true;

        } catch (SQLException e) {
            LOG.error(e);
        } catch (IllegalParameterException e) {
            LOG.error(e);
        }

        return false;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Card> getCards(Integer fromId, Integer toId) {

        try {
            LOG.debug("START GET CARDs...");
            List<Card> cards = iCardDAO.getCards(fromId, toId);
            int rez = toId - fromId;
            if(cards.size()!=rez) {
                LOG.info("Get Cards successfully, but only " + cards.size() + " results are exist:");
            } else {
                LOG.info("Get Cards successfully");
            }
            return cards;

        } catch (SQLException e) {
            LOG.error(e);
        } catch (IllegalParameterException e) {
            LOG.error(e);
        } catch (NotFoundException e) {
            LOG.error(e);
        }

        return null;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Card> getUserCards(User user) {

        try {
            LOG.debug("START GET CARDs...");
            List<Card> cards = iCardDAO.getUserCards(user);
            LOG.info("Get Cards successfully");
            return cards;

        } catch (SQLException e) {
            LOG.error(e);
        } catch (IllegalParameterException e) {
            LOG.error(e);
        } catch (NotFoundException e) {
            LOG.error(e);
        }

        return null;
	}

    @Transactional(propagation=Propagation.REQUIRED)
    public boolean deleteCard(Integer id) {

        try {
            LOG.debug("START DELETE CARDs...");
            iCardDAO.deleteCard(id);
            LOG.info("Delete Card successfully");
            return true;

        } catch (SQLException e) {
            LOG.error(e);
        } catch (IllegalParameterException e) {
            LOG.error(e);
        } catch (NotFoundException e) {
            LOG.error(e);
        }

        return false;
    }

}
