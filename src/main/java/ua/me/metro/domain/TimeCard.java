package ua.me.metro.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue("TIME")
public class TimeCard extends Card implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public enum ValidityTime {
		YEAR,
		MONTH,
		QUARTER;
    }

	@Column(name="expirationDate")
	@Temporal(value = TemporalType.DATE)
	private Date expirationDate = null;
	
	@Column(name="validity")
	@Enumerated(EnumType.STRING)
	private ValidityTime validity;

	public ValidityTime getValidity() {	
		return validity;
	}
	public void setValidity(ValidityTime validity) {
		this.validity = validity;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	
	public TimeCard(){	
	}
	
	public TimeCard(Integer id, boolean active, ValidityTime validity, Date expirationDate) {
        super(id,active);
		this.validity = validity;
		this.expirationDate = expirationDate;
	}
	
	
	@Override
	public boolean use(Card card) {
		if (isActive() == true) {
			if (expirationDate == null) {			
				Calendar calendar = new GregorianCalendar();
				
				switch (validity) {			
				case MONTH: 
					calendar.add(Calendar.MONTH, 1); 
					break;
				case YEAR: 
					calendar.add(Calendar.YEAR, 1);
					break;
				case QUARTER: 
					calendar.add(Calendar.MONTH, 4); 
					break;
				default:
					break;
				}					
				expirationDate = calendar.getTime();
				return true;
			} else {
				if (new Date().before(expirationDate)) {
					return true; 
				} else {
					return false;	
				}	
			}
		}
		return false;
	}
			
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY");
		if (expirationDate!=null) {
			return "Time Card [ID: " + getId() + ", Validity: " + validity +  ", Expiration: " + sdf.format(expirationDate) +
				 ", active=" + isActive() + "]";
		} else {
			return "Time Card [ID: " + getId() + ", Validity: " + validity +  ", Expiration: " + expirationDate +
					", Active: " + isActive() + "]";
		}
			
	}

	@Override
	public CardType getCardType() {
		return Card.CardType.TIME;
	}	
}
