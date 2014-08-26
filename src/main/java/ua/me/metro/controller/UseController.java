package ua.me.metro.controller;

import javax.inject.Inject;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ua.me.metro.domain.Card;
import ua.me.metro.domain.TimeCard;
import ua.me.metro.service.ICardService;

@Controller
public class UseController {

	@Inject
    ICardService cardService;

	@RequestMapping(value="/use", method = RequestMethod.GET)
	public ModelAndView use() {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("menu", "use");
		modelAndView.setViewName("home");
		return modelAndView;
	}

    @RequestMapping(value="/use/card", method = RequestMethod.GET)
    public String updateCardRedirect() {
        return "redirect:/use";
    }

	@RequestMapping(value="/use/card", method = RequestMethod.POST)
    public @ResponseBody String useCard(@RequestParam(value="inp") Integer id) {
		Card card = cardService.getCardById(id);
        JSONObject data = new JSONObject();

		if (card != null) {
            data.put("card", card.toJson());
        //    if (card instanceof TimeCard) data.put("validity", ((TimeCard) card).getValidity());
			if (card.use(card)) {
                if(cardService.updateCard(card)) {
                    data.put("card", card.toJson());
                    data.put("access", "open");
                } else {
                    data.put("exception", "Error update card");
                }
			} else {
                data.put("access", "close");
			}
		} else {
            data.put("exception", "Card not found");
		}
        return data.toString();
	}

}
