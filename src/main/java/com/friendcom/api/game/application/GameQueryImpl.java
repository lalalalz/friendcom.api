package com.friendcom.api.game.application;

import com.friendcom.api.game.application.in.GameQuery;
import com.friendcom.api.game.application.in.SearchGameResult;
import com.friendcom.api.game.application.out.LoadGamePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class GameQueryImpl implements GameQuery {

    private final LoadGamePort loadGamePort;

    @Override
    public List<SearchGameResult> searchGame(String name) {
        return loadGamePort.searchGame(name);
    }
}
