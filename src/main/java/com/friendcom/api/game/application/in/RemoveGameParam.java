package com.friendcom.api.game.application.in;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class RemoveGameParam {

    @NotNull @Min(0L)
    private Long id;
}
