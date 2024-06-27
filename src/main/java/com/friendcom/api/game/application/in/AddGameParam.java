package com.friendcom.api.game.application.in;

import com.friendcom.api.game.domain.Game;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class AddGameParam {

    @NotBlank private String name;
    @NotBlank private String manufacturer;
    private AddGameSpecification minimumSpecification;
    private AddGameSpecification maximumSpecification;

    public Game toEntity() {
        return Game.withoutId(name,
                manufacturer,
                minimumSpecification.toValueObject(),
                maximumSpecification.toValueObject());
    }
}
