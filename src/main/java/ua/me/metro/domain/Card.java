package ua.me.metro.domain;

import org.json.JSONObject;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Cards")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING)
abstract public class Card implements Serializable {
	
	private static final long serialVersionUID = 1L;

    public JSONObject toJson() {
        JSONObject cardJson = new JSONObject(this);
        cardJson.put("cardType", getCardType());
        if (this instanceof TimeCard) cardJson.put("validity", ((TimeCard) this).getValidity());
        return cardJson;
    }

    public static Card fromJson(JSONObject cardJson) {
        CardType cardType = CardType.valueOf(cardJson.getString("cardType"));
        Card card = null;

        Integer id = null;
        try{
            id = cardJson.getInt("id");
        }catch(Exception e){
            //do nothing
        }

        switch(cardType){
            case NUMBER:
                card = new NumberCard(id, cardJson.getBoolean("active"), cardJson.getInt("numberTrip"));
                break;
            case TIME:
                card = new TimeCard();
                break;
            case UNLIM:
                card = new UnlimCard();
                break;
        }

        return card;
    }

    public enum CardType {
		NUMBER, TIME, UNLIM
    }

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name="id")
	private Integer id;
	
	@Column(name="active", nullable=false)
	private boolean active;
	
	@ManyToOne
    @JoinColumn(name="user_id")
	private User user;
	


	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	public Card(){
	}

	abstract public boolean use(Card card);
	abstract public CardType getCardType();
			
}
