package com.friendcom.api.game.application.in;

import java.util.List;

public interface GameQuery {

    List<SearchGameResult> searchGame(String name);

}
