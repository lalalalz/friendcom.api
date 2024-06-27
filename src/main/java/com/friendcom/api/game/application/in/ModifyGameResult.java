package com.friendcom.api.game.application.in;

import com.friendcom.api.game.domain.Game;
import lombok.Value;
import org.springframework.lang.NonNull;

@Value
public class ModifyGameResult {

    String name;
    String manufacturer;
    ModifyGameSpecification minimumSpecification;
    ModifyGameSpecification maximumSpecification;

    public static ModifyGameResult from(@NonNull final Game game) {
        return new ModifyGameResult(
                game.getName(),
                game.getManufacturer(),
                ModifyGameSpecification.from(game.getMinimumSpecification()),
                ModifyGameSpecification.from(game.getMaximumSpecification())
        );
    }
}
