package com.friendcom.api.game.application;

import com.friendcom.api.game.application.in.*;
import com.friendcom.api.game.application.out.LoadGamePort;
import com.friendcom.api.game.application.out.RemoveGamePort;
import com.friendcom.api.game.application.out.SaveGamePort;
import com.friendcom.api.game.domain.Game;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class GameService implements GameUseCase {

    private final SaveGamePort saveGamePort;
    private final LoadGamePort loadGamePort;
    private final RemoveGamePort removeGamePort;

    @Override @NonNull
    public Long addGame(@NonNull final AddGameParam addGameParam) {
        if (isExistGame(addGameParam.getName(), addGameParam.getManufacturer())) {
            throw new AlreadyExistGameException();
        }

        return saveGamePort
                .save(addGameParam.toEntity())
                .getId();
    }

    @Override @NonNull
    public Long removeGame(@NonNull final RemoveGameParam removeGameParam) {
        if (!isExistGame(removeGameParam.getId())) {
            throw new NoSuchGameException();
        }

        return removeGamePort.remove(removeGameParam.getId());
    }

    @Override @NonNull
    public ModifyGameResult modifyGameSpecification(@NonNull final ModifyGameParam modifyGameParam) {
        Game game = loadGamePort.findById(modifyGameParam.getId())
                .orElseThrow(NoSuchGameException::new);

        game.changeSpecification(
                modifyGameParam.getMinimumSpecification().toValueObject(),
                modifyGameParam.getMaximumSpecification().toValueObject()
        );

        return ModifyGameResult.from(saveGamePort.save(game));
    }

    private boolean isExistGame(@NotBlank final String gameName,
                                @NotBlank final String manufacturer) {
        return loadGamePort
                .findByNameAndManufacturer(gameName, manufacturer)
                .isPresent();
    }

    private boolean isExistGame(@NonNull final Long id) {
        return loadGamePort
                .findById(id)
                .isPresent();
    }
}
