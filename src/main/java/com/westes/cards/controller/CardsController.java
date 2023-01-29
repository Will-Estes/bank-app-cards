package com.westes.cards.controller;

import com.westes.cards.model.Card;
import com.westes.cards.repository.CardRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CardsController {

  private final CardRepository cardRepository;

  @GetMapping("/cards/{customerId}")
  public List<Card> getCardDetails(@PathVariable int customerId) {
    List<Card> cards = cardRepository.findCardsByCustomerId(customerId);
    if (cards != null) {
      return cards;
    } else {
      return null;
    }

  }
}
