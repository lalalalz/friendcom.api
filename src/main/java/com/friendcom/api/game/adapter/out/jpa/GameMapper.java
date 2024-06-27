package com.friendcom.api.game.adapter.out.jpa;

import com.friendcom.api.game.adapter.out.jpa.entity.GameEntity;
import com.friendcom.api.game.adapter.out.jpa.entity.SpecificationInfo;
import com.friendcom.api.game.domain.Game;
import com.friendcom.api.game.domain.Specification;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
class GameMapper {

    public Game entityToDomain(@NonNull final GameEntity gameEntity) {
        return Game.withId(gameEntity.getId(),
                gameEntity.getName(),
                gameEntity.getManufacturer(),
                toValueObject(gameEntity.getMinimumSpecification()),
                toValueObject(gameEntity.getMaximumSpecification()));
    }

    public GameEntity domainToEntity(@NonNull final Game game) {
        return new GameEntity(
                game.getId(),
                game.getName(),
                game.getManufacturer(),
                toInfo(game.getMinimumSpecification()),
                toInfo(game.getMaximumSpecification())
        );
    }

    private Specification toValueObject(@NonNull final SpecificationInfo specificationInfo) {
        return new Specification(
                specificationInfo.getOperationSystem(),
                specificationInfo.getCpu(),
                specificationInfo.getRam(),
                specificationInfo.getStorage(),
                specificationInfo.getGraphic()
        );
    }

    private SpecificationInfo toInfo(@NonNull final Specification specification) {
        return new SpecificationInfo(
                specification.getOperationSystem(),
                specification.getCpu(),
                specification.getRam(),
                specification.getStorage(),
                specification.getGraphic()
        );
    }
}
