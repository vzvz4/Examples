package EnumExample;

public enum AnimalEnum {
    LION("Лев"), CROCODILE("Крокодил"), BIRD("Птица");

    private String translation;

    AnimalEnum(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }
    public String toString() {
        return "Перевод на русский язык " + translation;
    }
}
