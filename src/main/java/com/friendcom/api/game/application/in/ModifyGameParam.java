package com.friendcom.api.game.application.in;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class ModifyGameParam {
    @NotNull @Min(0L)
    Long id;
    ModifyGameSpecification minimumSpecification;
    ModifyGameSpecification maximumSpecification;
}
