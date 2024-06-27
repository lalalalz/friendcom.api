package com.friendcom.api.game.application.in;

import com.friendcom.api.game.domain.Specification;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class AddGameSpecification {

    @NotBlank private String operationSystem;
    @NotBlank private String cpu;
    @NotBlank private String ram;
    @NotBlank private String storage;
    @NotBlank private String graphic;


    public Specification toValueObject() {
        return new Specification(operationSystem, cpu, ram, storage, graphic);
    }
}
