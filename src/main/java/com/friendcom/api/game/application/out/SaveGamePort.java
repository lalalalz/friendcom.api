package com.friendcom.api.game.application.out;

import com.friendcom.api.game.domain.Game;

public interface SaveGamePort {
    Game save(Game game);
}
