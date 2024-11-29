package game.cards;

public enum enumBorne {
    BORNE_50(50),
    BORNE_75(75),
    BORNE_100(100),
    BORNE_200(200);

    private final int valeur;

    enumBorne(int valeur) {
        this.valeur = valeur;
    }

    public int getValeur() {
        return valeur;
    }

    @Override
    public String toString() {
        return "Borne: " + valeur;
    }
}