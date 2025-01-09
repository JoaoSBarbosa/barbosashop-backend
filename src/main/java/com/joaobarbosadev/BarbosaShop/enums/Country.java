package com.joaobarbosadev.BarbosaShop.enums;

public enum Country {

    BRASIL("Brasil"),
    EUA("Estados Unidos"),
    CANADA("Canadá"),
    ARGENTINA("Argentina"),
    ALEMANHA("Alemanha"),
    JAPAO("Japão"),
    FRANCA("França"),
    ITALIA("Itália"),
    CHINA("China"),
    INDIA("Índia"),
    RUSSIA("Rússia"),
    REINO_UNIDO("Reino Unido"),
    AUSTRALIA("Austrália"),
    MEXICO("México"),
    ESPANHA("Espanha");


    private String description;

    private Country(String description) {
        this.description = description;
    }


    public String getDescription() {
        return description;
    }
}
