package com.blackjackgame;

public enum ActionType {

    P_JOINED("P Joined"),
    P_HIT("P Hit"),
    P_STAND("P Stand"),
    P_WIN("P Win"),
    P_LEFT("P Left"),
    D_SHOW("D Show"),
    D_HIT("D Hit"),
    D_STAND("D Stand"),
    D_WIN("D Win"),
    D_REDEAL("D Redeal");

    private final String name;

    ActionType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
