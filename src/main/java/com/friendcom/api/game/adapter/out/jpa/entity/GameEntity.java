package com.friendcom.api.game.adapter.out.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;
import static lombok.AccessLevel.PUBLIC;

@Getter
@Entity @Table(name = "game")
@AllArgsConstructor(access = PUBLIC)
@NoArgsConstructor(access = PROTECTED)
public class GameEntity {

    @Id @GeneratedValue
    @Column(name = "game_id")
    private Long id;
    private String name;
    private String manufacturer;

    @Embedded
    @AttributeOverrides({
                    @AttributeOverride(name = "operationSystem", column = @Column(name = "minimum_operation_system")),
                    @AttributeOverride(name = "cpu", column = @Column(name = "minimum_cpu")),
                    @AttributeOverride(name = "ram", column = @Column(name = "minimum_ram")),
                    @AttributeOverride(name = "storage", column = @Column(name = "minimum_storage")),
                    @AttributeOverride(name = "graphic", column = @Column(name = "minimum_graphic"))
    })
    private SpecificationInfo minimumSpecification;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "operationSystem", column = @Column(name = "maximum_operation_system")),
            @AttributeOverride(name = "cpu", column = @Column(name = "maximum_cpu")),
            @AttributeOverride(name = "ram", column = @Column(name = "maximum_ram")),
            @AttributeOverride(name = "storage", column = @Column(name = "maximum_storage")),
            @AttributeOverride(name = "graphic", column = @Column(name = "maximum_graphic"))
    })
    private SpecificationInfo maximumSpecification;
}
