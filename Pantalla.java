import java.util.Scanner;
import java.text.DecimalFormat;

public class Pantalla
{
    private Terreno[] terrenos;
    private int cantTerrenos;
    private double precio;
    
    public void preguntarDatos()
    {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de terrenos: ");
        cantTerrenos = Integer.parseInt(teclado.nextLine());
        
        terrenos = new Terreno[cantTerrenos];
        
        for(int i = 0; i < cantTerrenos ; i++)
        {
            System.out.println("Ingrese el largo del terreno " + (i + 1)+":");
            double largo = Double.parseDouble(teclado.nextLine());
            System.out.println("Ingrese el ancho del terreno " + (i + 1)+":");
            double ancho = Double.parseDouble(teclado.nextLine());
            System.out.println("Ingrese el sector del terreno "+ (i + 1) + " (Urbano/Rural): ");
            String sector = teclado.nextLine();
            
            terrenos[i] = new Terreno(largo, ancho, sector);
        }
    }
    
    public void calcularPrecio()
    {
        precio = 0;
        for (int i = 0; i <cantTerrenos; i++)
        {
            precio = precio + terrenos[i].getPrecio();
        }
    }
    
    public void mostrarSuma()
    {
        DecimalFormat formato = new DecimalFormat("#,###.00");
        for (Terreno t : terrenos)
        {
            System.out.println(t.toString());
        }
        System.out.println("El valor total de los terrenos es $ "+formato.format(precio));
    }
}
