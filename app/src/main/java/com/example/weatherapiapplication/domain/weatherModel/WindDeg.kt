package com.example.weatherapiapplication.domain.weatherModel

enum class WindDeg(
    val direction: String,
    val dir: String,
    val deg: Int
) {
    N("Север", "C", 338),
    NW("Северо-западный", "СЗ", 293),
    W("Запад", "З", 248),
    SW("Юго-западный", "ЮЗ", 203),
    S("Юг", "Ю", 158),
    SE("Юго-восточный", "ЮВ", 113),
    E("Восток", "В", 68),
    NE("Северо-восточный", "СВ", 23)
}

