package com.friendcom.api.game.adapter.out;

import com.friendcom.api.game.adapter.out.jpa.GameRepository;
import com.friendcom.api.game.application.out.SaveGamePort;
import com.friendcom.api.game.domain.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class SaveGameAdapter implements SaveGamePort {

    private final GameRepository gameRepository;

    @Override @NonNull
    public Game save(@NonNull final Game game) {
        return gameRepository.save(game);
    }
}
