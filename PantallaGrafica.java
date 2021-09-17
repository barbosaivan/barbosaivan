import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class PantallaGrafica
{
    private Terreno[] terrenos;
    private int cantTerrenos;
    private double suma;
    
    public void preguntarDatos()
    {
        cantTerrenos = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de terrenos: "));
        terrenos = new Terreno[cantTerrenos];
        
        for(int i = 0; i < cantTerrenos ; i++)
        {
            String forma = JOptionPane.showInputDialog(null, "Ingrese la forma del terreno "+ (i + 1) + " (rectangular, triangular, trapezoidal): ");
            double largo = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el largo del terreno " + (i + 1)+":"));
            double ancho = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el ancho del terreno " + (i + 1)+":"));
            String sector = JOptionPane.showInputDialog(null, "Ingrese el sector del terreno "+ (i + 1) + " (Urbano/Rural): ");
            
            if (forma.toLowerCase().trim().equals("rectangular"))
            {
                terrenos[i] = new Terreno(largo, ancho, sector);
            }
            else if (forma.toLowerCase().trim().equals("triangular"))
            {
                terrenos[i] = new TerrenoTriangular(largo, ancho, sector);
            }
            else if (forma.toLowerCase().trim().equals("trapezoidal"))
            {
                double largo2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el segundo largo del terreno " + (i + 1)+":"));
                terrenos[i] = new TerrenoTrapezoidal(largo, largo2, ancho, sector);
            }
        }
    }
    
    public void calcularPrecio()
    {
        suma = 0;
        for (int i = 0; i <cantTerrenos; i++)
        {
            suma = suma + terrenos[i].getPrecio();
        }
    }
    
    public void mostrarSuma()
    {
        DecimalFormat formato = new DecimalFormat("#,###.00");
        for (int i= 0; i<cantTerrenos; i++)
        {
            JOptionPane.showMessageDialog(null, terrenos[i].toString());
        }
        JOptionPane.showMessageDialog(null, "El valor total de los terrenos es $ "+formato.format(suma));
    }
}





