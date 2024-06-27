package com.friendcom.api.game.application.in;

public interface GameUseCase {

    Long addGame(AddGameParam addGameParam);

    Long removeGame(RemoveGameParam removeGameParam);

    ModifyGameResult modifyGameSpecification(ModifyGameParam modifyGameParam);
}
