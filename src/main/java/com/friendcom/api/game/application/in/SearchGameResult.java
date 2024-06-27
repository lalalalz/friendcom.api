package com.friendcom.api.game.application.in;

import com.friendcom.api.game.domain.Game;
import lombok.Value;

@Value
public class SearchGameResult {

    Long id;
    String name;
    String manufacturer;
    SearchGameSpecification minimumSpecification;
    SearchGameSpecification maximumSpecification;

    public static SearchGameResult from(Game game) {
        return new SearchGameResult(
                game.getId(),
                game.getName(),
                game.getManufacturer(),
                SearchGameSpecification.from(game.getMinimumSpecification()),
                SearchGameSpecification.from(game.getMaximumSpecification())
        );
    }
}
