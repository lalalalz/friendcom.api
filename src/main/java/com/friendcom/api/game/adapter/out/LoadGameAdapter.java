package com.friendcom.api.game.adapter.out;

import com.friendcom.api.game.adapter.out.jpa.GameRepository;
import com.friendcom.api.game.application.in.SearchGameResult;
import com.friendcom.api.game.application.out.LoadGamePort;
import com.friendcom.api.game.domain.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
class LoadGameAdapter implements LoadGamePort {

    private final GameRepository gameRepository;

    @Override
    public Optional<Game> findByNameAndManufacturer(@NonNull final String name,
                                                    @NonNull final String manufacturer) {
        return gameRepository.findByNameAndManufacturer(name, manufacturer);
    }

    @Override
    public Optional<Game> findById(final long id) {
        return gameRepository.findById(id);
    }

    @Override
    public List<SearchGameResult> searchGame(@NonNull final String name) {
        return gameRepository.findByName(name);
    }
}
