package ua.me.metro.controller;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.me.metro.domain.Card;
import ua.me.metro.domain.NumberCard;
import ua.me.metro.domain.Card.CardType;
import ua.me.metro.service.ICardService;

@Controller
public class UpdateController {

    @Inject
    ICardService cardService;
	
	@RequestMapping(value="update", method = RequestMethod.GET)
	public ModelAndView update() {
	
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("menu", "update");
		modelAndView.setViewName("home");
		return modelAndView;
	
	}

    @RequestMapping(value="/update/card", method = RequestMethod.GET)
    public String updateCardRedirect() {
        return "redirect:/update";
    }
	
	@RequestMapping(value="/update/card", method = RequestMethod.POST)
	public ModelAndView updateCard(@RequestParam("id") String strId,
                                   @RequestParam("numberTripUpdate") String strNumberTrip) {
		
		ModelAndView modelAndView = new ModelAndView();
		/////////////////////////////////////////////////////////////////////
		Integer id = null;
        try {
            id = Integer.valueOf(strId);
		
		} catch (NumberFormatException e) {
			modelAndView.addObject("exception", "ID must be integer type");
			modelAndView.addObject("menu", "update");
			modelAndView.setViewName("home");
			return modelAndView;
		}

        Integer numberTrip = null;
		try {
            numberTrip = Integer.valueOf(strNumberTrip);
		
		} catch (NumberFormatException e) {
			modelAndView.addObject("exception", "Number Trip must be integer type");
			modelAndView.addObject("menu", "update");
			modelAndView.setViewName("home");
			return modelAndView;
		} 
		
		if (numberTrip <= 0 || id<=0) {
			modelAndView.addObject("exception", " Number Trip and ID must be more then 0");
			modelAndView.setViewName("home");
			return modelAndView;
		} 		
		/////////////////////////////////////////////////////////////////////
		
		Card card = cardService.getCardById(id);
		
		if (card !=null) {
            modelAndView.addObject("card", card);

			if (card.getCardType()==CardType.NUMBER) {
                Integer tmp = ((NumberCard) card).getNumberTrip();
                tmp=tmp+numberTrip;
                ((NumberCard) card).setNumberTrip(tmp);

                if(cardService.updateCard(card)) {
                    modelAndView.addObject("card", card);
                } else {
                    modelAndView.addObject("exception", "Error update card");
                }

			} else {
				modelAndView.addObject("exception", "It's no number card");
			}

		} else {
			modelAndView.addObject("exception", "Card not found");
		}
		
		modelAndView.addObject("menu", "update");
		modelAndView.setViewName("home");
		return modelAndView;
		}
	

}
