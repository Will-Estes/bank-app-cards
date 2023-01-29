package com.westes.cards.controller;

import com.westes.cards.config.CardsServiceConfig;
import com.westes.cards.model.Card;
import com.westes.cards.model.Properties;
import com.westes.cards.repository.CardRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CardsController {

  private final CardsServiceConfig cardsConfig;
  private final CardRepository cardRepository;

  @GetMapping("/cards/{customerId}")
  public List<Card> getCardDetails(@PathVariable int customerId) {
    return cardRepository.findCardsByCustomerId(customerId);
  }

  @GetMapping("/cards/properties")
  public Properties getPropertyDetails() {
    return new Properties(cardsConfig.getMsg(),
        cardsConfig.getBuildVersion(),
        cardsConfig.getMailDetails(), cardsConfig.getActiveBranches());
  }
}
