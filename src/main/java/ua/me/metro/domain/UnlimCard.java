package ua.me.metro.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("UNLIM")
public class UnlimCard extends Card implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name="name")
	private String name;
	
	@Column(name="lastName")
	private String lastName;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	public UnlimCard() {		
	}
	
	
	public UnlimCard(Integer id, boolean active, String name, String lastName) {
        super(id,active);
		this.name = name;
		this.lastName = lastName;
			
	}

	@Override
	public boolean use(Card card) {
		if (getId() != null && isActive() == true ) { 
			return true; 
			}
		else { 
			return false; 
			}
	}
	
	@Override
	public String toString() {
		return "UnlimCard [ID: " + getId() + ", Name: " + name + ", Last Name: " + lastName + ", Active: " + isActive() + "]";
	}
	
	@Override
	public CardType getCardType() {
		return Card.CardType.UNLIM;
	}
}
