package ua.me.metro.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.me.metro.domain.Card;
import ua.me.metro.domain.User;
import ua.me.metro.service.ICardService;

import javax.inject.Inject;
import java.util.List;

@Controller
public class MyCardsController {

    @Inject
    ICardService cardService;

    @RequestMapping(value="/myCards", method = RequestMethod.GET)
    public ModelAndView myCards() {

        ModelAndView modelAndView = new ModelAndView();

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (user!=null) {

            List<Card> cards = cardService.getUserCards(user);

            if (cards!=null) {
                if (cards.size()!=0) {
                    modelAndView.addObject("cards", cards);
                } else {
                    modelAndView.addObject("exception", "No cards");
                }
            } else {
                modelAndView.addObject("exception", "No cards");
            }
        } else {
            modelAndView.addObject("exception", "No user auhtorization");
        }

        modelAndView.addObject("menu","myCards");
        modelAndView.setViewName("home");
        return modelAndView;
    }
}
