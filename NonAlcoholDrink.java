public class NonAlcoholDrink extends Drink{

    public NonAlcoholDrink(int code, String name) {
        super(code, name);

    }

    @Override
    public String toString()
    {
        return "Non alcohol drink code: " + this.getCode() + " Non alcohol drink Name: " + this.getName();
    }

}
