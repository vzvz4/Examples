package EnumExample;

public enum Season {
    SUMMER(35), WINTER(-15), AUTUMN(0), SPRING(15);
    private int temperature;

    Season(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }
    public String toString() {
        return Integer.toString(temperature);
    }
}
