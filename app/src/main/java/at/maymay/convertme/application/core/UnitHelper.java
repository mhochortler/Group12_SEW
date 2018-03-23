package at.maymay.convertme.application.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mmalte on 21.03.18.
 */

public class UnitHelper {

    private List<Unit> weightList;
    private List<Unit> lengthList;
    private List<Unit> currencyList;
    private List<Unit> pressureList;
    private List<Unit> clothSizeList;
    private List<Unit> temperatureList;
    private List<Unit> timeList;
    private List<Unit> volumeList;


    public void init() {
        //example - load from file
        Unit kg = new Unit();
        kg.setName("Kilograms");
        kg.setFactor(1000);
        kg.setShortcut("kg");
        kg.setType(UnitTyp.WEIGHT);

        weightList =  new ArrayList<>();
        weightList.add(kg);
    }


    public List<Unit> getWeightList() {
        return weightList;
    }

    public void setWeightList(List<Unit> weightList) {
        this.weightList = weightList;
    }

    public List<Unit> getLengthList() {
        return lengthList;
    }

    public void setLengthList(List<Unit> lengthList) {
        this.lengthList = lengthList;
    }

    public List<Unit> getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(List<Unit> currencyList) {
        this.currencyList = currencyList;
    }

    public List<Unit> getPressureList() {
        return pressureList;
    }

    public void setPressureList(List<Unit> pressureList) {
        this.pressureList = pressureList;
    }

    public List<Unit> getClothSizeList() {
        return clothSizeList;
    }

    public void setClothSizeList(List<Unit> clothSizeList) {
        this.clothSizeList = clothSizeList;
    }

    public List<Unit> getTemperatureList() {
        return temperatureList;
    }

    public void setTemperatureList(List<Unit> temperatureList) {
        this.temperatureList = temperatureList;
    }

    public List<Unit> getTimeList() {
        return timeList;
    }

    public void setTimeList(List<Unit> timeList) {
        this.timeList = timeList;
    }

    public List<Unit> getVolumeList() {
        return volumeList;
    }

    public void setVolumeList(List<Unit> volumeList) {
        this.volumeList = volumeList;
    }
}
