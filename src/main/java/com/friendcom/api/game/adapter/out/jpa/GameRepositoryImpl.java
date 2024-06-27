package com.friendcom.api.game.adapter.out.jpa;

import com.friendcom.api.game.adapter.out.jpa.entity.GameEntity;
import com.friendcom.api.game.application.in.SearchGameResult;
import com.friendcom.api.game.domain.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
class GameRepositoryImpl implements GameRepository {

    private final GameJpaRepository gameJpaRepository;
    private final GameMapper gameMapper;

    @Override @NonNull
    public Optional<Game> findByNameAndManufacturer(@NonNull final String name,
                                                    @NonNull final String manufacturer) {
        GameEntity gameEntity = gameJpaRepository
                .findByNameAndManufacturer(name, manufacturer)
                .orElse(null);

        return isNull(gameEntity) ?
                Optional.empty() : Optional.ofNullable(gameMapper.entityToDomain(gameEntity));
    }

    @Override @NonNull
    public Optional<Game> findById(final long id) {
        GameEntity gameEntity = gameJpaRepository
                .findById(id)
                .orElse(null);

        return isNull(gameEntity) ?
                Optional.empty(): Optional.ofNullable(gameMapper.entityToDomain(gameEntity));
    }

    @Override @NonNull
    public Game save(@NonNull final Game game) {
        return gameMapper.entityToDomain(gameJpaRepository.save(gameMapper.domainToEntity(game)));
    }

    @Override
    public long deleteById(long id) {
        gameJpaRepository.deleteById(id);
        return id;
    }

    @Override
    public List<SearchGameResult> findByName(String name) {
        return gameJpaRepository.findByName(name)
                .stream()
                .map(gameMapper::entityToDomain)
                .map(SearchGameResult::from)
                .collect(Collectors.toList());
    }
}
