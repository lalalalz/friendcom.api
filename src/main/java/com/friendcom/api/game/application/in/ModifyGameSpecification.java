package com.friendcom.api.game.application.in;

import com.friendcom.api.game.domain.Specification;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ModifyGameSpecification {

    private String operationSystem;
    private String cpu;
    private String ram;
    private String storage;
    private String graphic;

    @NonNull
    public Specification toValueObject() {
        return new Specification(operationSystem, cpu, ram, storage, graphic);
    }

    @NonNull
    public static ModifyGameSpecification from(@NonNull final Specification specification) {
        return new ModifyGameSpecification(
                specification.getOperationSystem(),
                specification.getCpu(),
                specification.getRam(),
                specification.getStorage(),
                specification.getGraphic()
        );
    }
}
