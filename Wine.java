public class Wine extends AlcoholDrink{

    private String  wineColor;

    public Wine(int code, String name, double alcoholicDegree, String wineColor) {
        super(code, name, alcoholicDegree);
        this.wineColor = wineColor;
        // TODO Auto-generated constructor stub
    }

    public String getWineColor() {
        return wineColor;
    }

    public void setWineColor(String wineColor) {
        this.wineColor = wineColor;
    }

    @Override
    public String toString() {
        return super.toString() + "  wineColor: " + wineColor;
    }



}

