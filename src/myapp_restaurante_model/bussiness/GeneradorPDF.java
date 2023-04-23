package myapp_restaurante_model.bussiness;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GeneradorPDF {

    public static void main(String[] args) {

        try {
            File file = new File("src\\myapp_restaurante_model\\pdf\\hello_world.pdf");
            try (PdfWriter pdfWriter = new PdfWriter(file)) {
                PdfDocument pdfDocument = new PdfDocument(pdfWriter);

                try (Document document = new Document(pdfDocument)) {
                    Paragraph paragraph = new Paragraph("Hello World");

                    document.add(paragraph);
                }
            }

            System.out.println("PDF creado");
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void createPDF(String data) {

        try {
            File file = new File("src\\myapp_restaurante_model\\pdf\\Pedido.pdf");
            try (PdfWriter pdfWriter = new PdfWriter(file)) {
                PdfDocument pdfDocument = new PdfDocument(pdfWriter);

                try (Document document = new Document(pdfDocument)) {
                    Paragraph paragraph = new Paragraph(data);

                    document.add(paragraph);
                }
            }

            System.out.println("PDF creado");
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String generarFactura(String cliente, String fecha, double subtotal, double iva, double total,double valorPagado) {
        StringBuilder sb = new StringBuilder();
        sb.append("Restaurante ML\n");
        sb.append("Av. Principal #123\n");
        sb.append("Tel: 555-5555\n\n");

        sb.append("Factura para: IDCliente ").append(cliente).append("\n");
        sb.append("Fecha: ").append(fecha).append("\n\n");

        sb.append("Detalle de pedido:\n");
        //sb.append("Item\tCantidad\tPrecio\tTotal\n");
        //sb.append("1\t2\t\t$25.00\t$50.00\n\n");

        sb.append("Subtotal: $").append(subtotal).append("\n");
        sb.append("itbis: $").append(iva).append("\n");
        sb.append("Total: $").append(total).append("\n");
        total = valorPagado - total;
        sb.append("Sobrante: $").append(total);

        return sb.toString();
    }

}
