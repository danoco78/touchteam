/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

import java.awt.Component;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Daniel
 */
public class ImageRenderer extends DefaultTableCellRenderer {

    JLabel lbl = new JLabel();

    public ImageRenderer() {
        this.setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus,
            int row, int column) {
        if (value != null) {
            ImageIcon aux = new ImageIcon();
            aux.setImage(new BufferedImage(50, 50, BufferedImage.TYPE_INT_RGB));
            aux.getImage().getGraphics().drawImage(((ImageIcon) value).getImage(), 0, 0, 50, 50, null);
            lbl.setIcon(aux);
        }
        return lbl;
    }
}
