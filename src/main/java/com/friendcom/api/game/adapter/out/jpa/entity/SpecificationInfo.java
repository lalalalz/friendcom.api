package com.friendcom.api.game.adapter.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SpecificationInfo {

    private String operationSystem;
    private String cpu;
    private String ram;
    private String storage;
    private String graphic;
}
