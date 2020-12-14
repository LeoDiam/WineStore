

public abstract class Drink
{
    private int code;
    private String name;

    public Drink(int code, String name)
    {
        this.code = code;
        this.name = name;
    }



    public int getCode() {
        return code;
    }



    public void setCode(int code) {
        if(code < 0 )
            System.out.println("Ti timi mou bazeis re file ");
        else
            this.code = code;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString()
    {
        return "Code: " + code + "   Name: " + name;
    }
}

