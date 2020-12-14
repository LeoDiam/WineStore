public class AlcoholDrink extends Drink
{
    private double alcoholicDegree;

    public AlcoholDrink(int code, String name, double alcoholicDegree)
    {
        super(code,name);
        this.alcoholicDegree = alcoholicDegree;
    }
    @Override
    public String toString()
    {
        return super.toString() + "   Alc.: " + alcoholicDegree;
    }
}
