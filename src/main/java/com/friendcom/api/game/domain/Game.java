package com.friendcom.api.game.domain;

import lombok.Getter;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * <h1>Domain Rule</h1>
 * <li>게임 이름과 제조사는 불변하다.</li>
 * <li>게임 이름, 제조사, 스펙 사양은 모두 대문자이다.</li>
 */

@Getter
public class Game {

    private final Long id;
    private final String name;
    private final String manufacturer;
    private Specification maximumSpecification;
    private Specification minimumSpecification;

    private Game(@Nullable final Long id,
                 @NonNull final String name,
                 @NonNull final String manufacturer,
                 @NonNull final Specification minimumSpecification,
                 @NonNull final Specification maximumSpecification) {
        this.id = id;
        this.name = name.toUpperCase();
        this.manufacturer = manufacturer.toUpperCase();
        this.minimumSpecification = minimumSpecification;
        this.maximumSpecification = maximumSpecification;
    }

    @NonNull
    public static Game withoutId(@NonNull final String name,
                                 @NonNull final String manufacturer,
                                 @NonNull final Specification minimumSpecification,
                                 @NonNull final Specification maximumSpecification) {
        return new Game(null, name, manufacturer, minimumSpecification, maximumSpecification);
    }

    @NonNull
    public static Game withId(@NonNull final Long id,
                              @NonNull final String name,
                              @NonNull final String manufacturer,
                              @NonNull final Specification minimumSpecification,
                              @NonNull final Specification maximumSpecification) {
        return new Game(id, name, manufacturer, minimumSpecification, maximumSpecification);
    }

    public void changeSpecification(@NonNull final Specification minimumSpecification,
                                    @NonNull final Specification maximumSpecification) {
        this.minimumSpecification = minimumSpecification;
        this.maximumSpecification = maximumSpecification;
    }
}
