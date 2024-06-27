package com.friendcom.api.game.adapter.out.jpa;

import com.friendcom.api.game.application.in.SearchGameResult;
import com.friendcom.api.game.domain.Game;

import java.util.List;
import java.util.Optional;

public interface GameRepository {
    Optional<Game> findByNameAndManufacturer(String name, String manufacturer);
    Optional<Game> findById(long id);
    Game save(Game game);
    long deleteById(long id);
    List<SearchGameResult> findByName(String name);
}
