package ControladorImpresora;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;

/**
 * Clase encargada de la comunicación con la impresora.
 *
 * @author Ángel Luis García
 */
public class Impresora implements Printable {

    private static ArrayList<String> textLines;

    /**
     * Método encargado de mandar el texto a la impresora.
     *
     * @param texto Un ArrayList con las cadenas de texto que deseamos imprimir. Cada cadena se imprimirá en una línea.
     */
    public static void imprime(ArrayList<String> texto){

    	textLines = texto;

        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new Impresora());
        boolean ok = job.printDialog();
        if (ok) {
            try {
                 job.print();
            } catch (PrinterException ex) {
                System.err.println("Printing error: " + ex);
            }
        }

    }

    /**
     * Implementación del método print de la interfaz Printable.
     * Imprime la página dada por pageIndex dentro del contexto dado por g.
     * El formato de la página está especificado en pf.
     *
     * @param g Contexto dentro del cual la página se va a pintar.
     * @param pf Formato de la página.
     * @param pageIndex Índice de la página que se desea imprimir.
     * @return PAGE_EXISTS si la página se ha renderizado correctamente o NO_SUCH_PAGE si pageIndex especifica una página que no existe.
     * @throws PrinterException Cuando la impresión ha terminado.
     */
    public int print(Graphics g, PageFormat pf, int pageIndex)
             throws PrinterException {

    	int[] pageBreaks = null;  // array of page break line positions.
        Font font = new Font("Monospaced", Font.PLAIN, 10);
        FontMetrics metrics = g.getFontMetrics(font);
        int lineHeight = metrics.getHeight();

        if (pageBreaks == null) {
            int linesPerPage = (int)(pf.getImageableHeight()/lineHeight);
            int numBreaks = (textLines.size()-1)/linesPerPage;
            pageBreaks = new int[numBreaks];
            for (int b=0; b<numBreaks; b++) {
                pageBreaks[b] = (b+1)*linesPerPage;
            }
        }

        if (pageIndex > pageBreaks.length) {
            return NO_SUCH_PAGE;
        }

        /* User (0,0) is typically outside the imageable area, so we must
         * translate by the X and Y values in the PageFormat to avoid clipping
         * Since we are drawing text we
         */
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());

        /* Draw each line that is on this page.
         * Increment 'y' position by lineHeight for each line.
         */
        int y = 0;
        int start = (pageIndex == 0) ? 0 : pageBreaks[pageIndex-1];
        int end   = (pageIndex == pageBreaks.length)? textLines.size() : pageBreaks[pageIndex];
        for (int line=start; line<end; line++) {
            y += lineHeight;
            g.drawString(textLines.get(line), 0, y);
        }

        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }
}