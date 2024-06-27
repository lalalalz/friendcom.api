package com.friendcom.api.game.adapter.out;

import com.friendcom.api.game.adapter.out.jpa.GameRepository;
import com.friendcom.api.game.application.out.RemoveGamePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class RemoveGameAdapter implements RemoveGamePort {

    private final GameRepository gameRepository;

    @Override
    public Long remove(Long id) {
        return gameRepository.deleteById(id);
    }
}
