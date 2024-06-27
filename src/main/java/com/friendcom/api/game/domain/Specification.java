package com.friendcom.api.game.domain;

import lombok.Value;
import org.springframework.lang.NonNull;

@Value
public class Specification {
    String operationSystem;
    String cpu;
    String ram;
    String storage;
    String graphic;

    public Specification(@NonNull final String operationSystem,
                         @NonNull final String cpu,
                         @NonNull final String ram,
                         @NonNull final String storage,
                         @NonNull final String graphic) {
        this.operationSystem = operationSystem.toUpperCase();
        this.cpu = cpu.toUpperCase();
        this.ram = ram.toUpperCase();
        this.storage = storage.toUpperCase();
        this.graphic = graphic.toUpperCase();
    }
}
