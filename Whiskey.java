public class Whiskey extends AlcoholDrink{

    private int  whiskeyAge;

    public Whiskey(int code, String name, double alcoholicDegree,int whiskeyAge) {
        super(code, name, alcoholicDegree);
        this.whiskeyAge = whiskeyAge;
    }

    public int getWhiskeyAge() {
        return whiskeyAge;
    }

    public void setWhiskeyAge(int whiskeyAge) {
        this.whiskeyAge = whiskeyAge;
    }

    @Override
    public String toString() {
        return super.toString() + "  whiskeyAge: " + whiskeyAge;
    }
}