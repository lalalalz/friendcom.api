package com.friendcom.api.game.adapter.in;

import com.friendcom.api.game.application.in.AddGameParam;
import com.friendcom.api.game.application.in.GameQuery;
import com.friendcom.api.game.application.in.GameUseCase;
import com.friendcom.api.game.application.in.SearchGameResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
class GameController {

    private final GameQuery gameQuery;
    private final GameUseCase gameUseCase;

    @GetMapping("/api/v1/game")
    List<SearchGameResult> searchGame(@RequestParam(name = "name") String name) {
        return gameQuery.searchGame(name);
    }

    @PostMapping("/api/v1/game")
    Long addGame(@RequestBody @Valid final AddGameParam addGameParam) {
        return gameUseCase.addGame(addGameParam);
    }

}
