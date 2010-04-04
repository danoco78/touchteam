package utilidades;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Esta clase posee médotos utiles para trabajar con las imágenes.
 * 
 * @author angel
 */
public class Imagen {

    /**
     * Método de clase para transformar un ImageIcon en un array de bytes.
     *
     * @param imagen La imagen a transformar.
     * @return Array de bytes conteniendo la imagen.
     */
    public static byte[] imageIconToByteArray(ImageIcon imagen) {
        BufferedImage bi=new BufferedImage(imagen.getImage().getWidth(null),imagen.getImage().getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();

        g.drawImage(imagen.getImage(), 0, 0, null);
        g.dispose();

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {
            ImageIO.write(bi, "jpeg", stream);
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
        return stream.toByteArray();
    }

    /**
     * Método de clase para transformar un Blob en un ImageIcon.
     *
     * @param blob El Blob a transformar.
     * @return Un ImageIcon obtenido a partir de los datos del Blob.
     */
    public static ImageIcon blobToImageIcon(Blob blob){

        ImageIcon imagen = null;
        try{
            imagen = new ImageIcon(blob.getBytes(1, (int) blob.length()));
            return imagen;
        } catch (SQLException ex) {
            System.err.println("Error: " + ex.getMessage());
            return imagen;
        }
    }
}
