package com.westes.cards.repository;

import com.westes.cards.model.Card;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Integer> {

  List<Card> findCardsByCustomerId(int customerId);
}
