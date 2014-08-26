package ua.me.metro.controller;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.me.metro.domain.Card;
import ua.me.metro.service.ICardService;

@Controller
public class ShowController {

    @Inject
    ICardService cardService;

    @RequestMapping(value={"/show"}, method = RequestMethod.GET)
	public ModelAndView show() {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("menu", "show");
		modelAndView.setViewName("home");
		return modelAndView;
	}

    @RequestMapping(value="/show/card", method = RequestMethod.GET)
    public String showCardsRedirect() {
        return "redirect:/show";
    }


	@RequestMapping(value="/show/cards", method = RequestMethod.POST)
	public ModelAndView showCards(@RequestParam("idFrom") String strFrom,
                                  @RequestParam("idTo") String strIdTo) {
		
		ModelAndView modelAndView = new ModelAndView();
		
//////////////////////////////////////////////////////////////


		Integer idFrom = null;
		Integer idTo = null;
		
		try {
			idFrom = Integer.valueOf(strFrom);
			idTo = Integer.valueOf(strIdTo);
			
		} catch (NumberFormatException e) {
			modelAndView.addObject("exception", "ID FROM and ID TO must be integer type");
			modelAndView.addObject("menu", "show");
			modelAndView.setViewName("home");
			return modelAndView;
		}
		
		if (idFrom <= 0 || idTo<=0) {
			modelAndView.addObject("exception", "ID FROM and ID TO must be more then 0");
			modelAndView.addObject("menu", "show");
			modelAndView.setViewName("home");
			return modelAndView;
		} 		
//////////////////////////////////////////////////////////////		
		
		List<Card> cards = cardService.getCards(idFrom, idTo);

		if (cards.size()!=0) {
            modelAndView.addObject("cards", cards);
		} else {
            modelAndView.addObject("exception", "Cards from ID " + idFrom + " to " + idTo + " not found");
        }
		modelAndView.addObject("menu", "show");
		modelAndView.setViewName("home");
		return modelAndView;
	}

    @RequestMapping(value="/delete", method = RequestMethod.GET)
    public String deleteCardRedirect() {
        return "redirect:/show";
    }

    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public ModelAndView deleteCard(@RequestParam(value="id") Integer id) {

        ModelAndView modelAndView = new ModelAndView();

        if (!cardService.deleteCard(id)) {
            modelAndView.addObject("exception", "Error delete card");
        }

        modelAndView.addObject("menu", "show");
        modelAndView.setViewName("home");
        return modelAndView;
    }
	
	

}
