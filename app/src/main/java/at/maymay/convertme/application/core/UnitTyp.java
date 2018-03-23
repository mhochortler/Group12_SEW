package at.maymay.convertme.application.core;

/**
 * Created by mmalte on 21.03.18.
 */

public enum UnitTyp {

    WEIGHT ("Weight"),
    LENGTH ("Length"),
    CURRENCY ("Currency"),
    PRESSURE ("Pressure"),
    CLOTHING_SIZE ("Cloth size"),
    TEMPERATURE ("Temperature"),
    TIME ("Time"),
    VOLUME ("Volume");

    private String name;

    private UnitTyp(String name) {
        name = name;
    }



}
