package ua.me.metro.controller;

import javax.inject.Inject;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.me.metro.domain.Card;
import ua.me.metro.domain.TimeCard;
import ua.me.metro.domain.UnlimCard;
import ua.me.metro.domain.TimeCard.ValidityTime;
import ua.me.metro.service.ICardService;

@Controller
public class BuyController {

	@Inject
    ICardService cardService;
	
	@RequestMapping(value="/buy", method = RequestMethod.GET)
	public ModelAndView buy() {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("menu", "buy");
		modelAndView.setViewName("home");
		return modelAndView;
	}

    @RequestMapping(value="/buy/choice", method = RequestMethod.GET)
    public String buyChoiceRedirect() {
        return "redirect:/buy";
    }
	
	@RequestMapping(value="/buy/choice", method = RequestMethod.POST)
	public ModelAndView buyChoice(@RequestParam("type") String type) {

		ModelAndView modelAndView = new ModelAndView();

		switch (type) {
		
		case "NumberCard":
			modelAndView.addObject("choice", "numberCard");
			break;
		case "UnlimCard":
			modelAndView.addObject("choice", "unlimCard");
			break;
		case "TimeCard":
			modelAndView.addObject("choice", "timeCard");
			break;
		default: break;
		}
	
		modelAndView.addObject("menu", "buy");
		modelAndView.setViewName("home");
		return modelAndView;
	}

    @RequestMapping(value="/buy/unlimCard", method = RequestMethod.GET)
    public String buyUnlimRedirect() {
        return "redirect:/buy";
    }

	@RequestMapping(value="/buy/unlimCard", method = RequestMethod.POST)
	public ModelAndView buyUnlim(@RequestParam("name") String name,
                                 @RequestParam("lastName") String lastName) {
		
		ModelAndView modelAndView = new ModelAndView();

		UnlimCard unlimCard = new UnlimCard(null,true,name,lastName);

        if(cardService.addCard(unlimCard)) {
            modelAndView.addObject("card", unlimCard);
        } else {
            modelAndView.addObject("exception", "Buy card error");
        }
	
		modelAndView.addObject("menu", "buy");
		modelAndView.addObject("choice", "unlimCard");	
		modelAndView.setViewName("home");
		return modelAndView;
	}

    @RequestMapping(value="/buy/timeCard", method = RequestMethod.GET)
    public String buyTimeRedirect() {
        return "redirect:/buy";
    }
	
	@RequestMapping(value="/buy/timeCard", method = RequestMethod.POST)
	public ModelAndView buyTime(@RequestParam("validity") String strValidity) {
		
		ModelAndView modelAndView = new ModelAndView();

		ValidityTime validity = null;
		switch (strValidity) {
			case "MONTH": validity=ValidityTime.MONTH; break;
			case "QUARTER": validity=ValidityTime.QUARTER; break;
			case "YEAR": validity=ValidityTime.YEAR; break;
			default: break;
		}
		
		TimeCard timeCard = new TimeCard(null,true,validity,null);

        if(cardService.addCard(timeCard)) {
            modelAndView.addObject("card", timeCard);
        } else {
            modelAndView.addObject("exception", "Buy card error");
        }
		
		modelAndView.addObject("menu", "buy");
		modelAndView.addObject("choice", "timeCard");	
		modelAndView.setViewName("home");
		return modelAndView;
	}

    @RequestMapping(value="/buy/numberCard", method = RequestMethod.GET)
    public String buyNumberRedirect() {
        return "redirect:/buy";
    }

	@RequestMapping(value="/buy/numberCard", method = RequestMethod.POST)
	public @ResponseBody String buyNumber(@RequestParam(value="numberCard") String numberCard) {

        JSONObject cardJson = new JSONObject(numberCard);
        JSONObject data = new JSONObject();

        Card card = Card.fromJson(cardJson);

        if(!cardService.addCard(card)) {
            data.put("exception", "Buy card error");
        }
        data.put("ok", "Buy card succesful");

		return data.toString();
	}
}
	
	

