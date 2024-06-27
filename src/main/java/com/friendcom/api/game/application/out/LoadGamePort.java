package com.friendcom.api.game.application.out;

import com.friendcom.api.game.application.in.SearchGameResult;
import com.friendcom.api.game.domain.Game;

import java.util.List;
import java.util.Optional;

public interface LoadGamePort {
    Optional<Game> findByNameAndManufacturer(String name, String manufacturer);

    Optional<Game> findById(long id);

    List<SearchGameResult> searchGame(String name);
}
