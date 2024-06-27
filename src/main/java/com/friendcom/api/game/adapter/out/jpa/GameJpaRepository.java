package com.friendcom.api.game.adapter.out.jpa;

import com.friendcom.api.game.adapter.out.jpa.entity.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

interface GameJpaRepository extends JpaRepository<GameEntity, Long> {
    Optional<GameEntity> findByNameAndManufacturer(String name, String manufacturer);

    List<GameEntity> findByName(String name);
}
