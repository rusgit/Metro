package ua.me.metro.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("NUMBER")
public class NumberCard extends Card implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="numberTrip")
	private int numberTrip;
	
	
	public int getNumberTrip() {
		return numberTrip;
	}
	public void setNumberTrip(int numberTrip) {
		this.numberTrip = numberTrip;
	}

	public NumberCard() {	
	}
	
	public NumberCard(Integer id, boolean active, int numberTrip) {
		setId(id);
		setActive(active);
		this.numberTrip = numberTrip;
		
	}
	
	@Override
	public boolean use(Card card) {
		if (getId() != null && isActive() == true && numberTrip > 0 ) {
		numberTrip--; return true; }
		else {return false;}
	}

	
	@Override
	public CardType getCardType() {
		return Card.CardType.NUMBER;
	}
	@Override
	public String toString() {
		return "Number Card [ID: " + getId() +", Number trip: " + numberTrip + 
				 ", Active: " + isActive() + "]";
	}
}
