package com.friendcom.api.game.application.in;

import com.friendcom.api.game.domain.Specification;
import lombok.Value;
import org.springframework.lang.NonNull;

@Value
public class SearchGameSpecification {

    String operationSystem;
    String cpu;
    String ram;
    String storage;
    String graphic;

    @NonNull
    public Specification toValueObject() {
        return new Specification(operationSystem, cpu, ram, storage, graphic);
    }

    @NonNull
    public static SearchGameSpecification from(@NonNull final Specification specification) {
        return new SearchGameSpecification(
                specification.getOperationSystem(),
                specification.getCpu(),
                specification.getRam(),
                specification.getStorage(),
                specification.getGraphic()
        );
    }
}
