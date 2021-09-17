import java.text.DecimalFormat;

public class Terreno
{
    protected double largo;
    protected double ancho;
    protected String sector;
    protected double area;
    protected double valorXm2;
    protected double precio;
    
    public Terreno()
    {
        this.largo = 0;
        this.ancho = 0;
        this.sector = "";
    }
    
    public Terreno(double largo, double ancho, String sector)
    {
        this.largo = largo;
        this.ancho = ancho;
        this.sector = sector;
    }
    
    public void setLargo(double largo)
    {
        this.largo = largo;
    }
    
    public double getLargo()
    {
        return this.largo;
    }
    
    public void setAncho(double ancho)
    {
        this.ancho = ancho;
    }
    
    public double getAncho()
    {
        return this.ancho;
    }
    
    public void setSector(String sector)
    {
        this.sector = sector;
    }
    
    public String getSector()
    {
        return this.sector;
    }
    
    public double getArea()
    {
        area = largo * ancho;
        return area;
    }
    
    public double getValorXm2()
    {
        if (sector.toLowerCase().equals("urbano")) 
        {
            valorXm2=3000000;
        }
        else
        {
            valorXm2=1800000;
        }
        return valorXm2;
    }
    
    public double getPrecio()
    {
        precio = getValorXm2() * getArea();
        return precio;
    }
    
    public String toString()
    {
        DecimalFormat formato = new DecimalFormat("#,###.00");
        String mensaje = "Terreno rectangular" + "\n" +
                         "Área: " + getArea() + " m2" + "\n" +
                         "Valor: $" + formato.format(getPrecio()) +"\n";
        return mensaje;
    }
}
