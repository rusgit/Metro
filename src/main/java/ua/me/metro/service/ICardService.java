package ua.me.metro.service;

import java.util.List;
import ua.me.metro.domain.Card;
import ua.me.metro.domain.User;

public interface ICardService {

		public boolean addCard(Card card);
	    public Card getCardById(Integer id);
	    public boolean updateCard(Card card);
	    public List<Card> getCards(Integer fromId, Integer toId);
	    public List<Card> getUserCards(User user);
        public boolean deleteCard(Integer id);


}
