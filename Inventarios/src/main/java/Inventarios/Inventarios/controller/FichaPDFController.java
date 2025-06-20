package Inventarios.Inventarios.controller;

import Inventarios.Inventarios.entities.Bien;
import Inventarios.Inventarios.entities.Ficha;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.io.IOException;
import java.util.Set;

@Controller
public class FichaPDFController {

    @GetMapping("/reporte")
    public void generarReporte(HttpServletResponse response, @SessionAttribute("ficha") Ficha ficha) throws IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename=reporte.pdf");

        Document documento = new Document(PageSize.A4.rotate()); // ← ROTATE lo pone en horizontal
        PdfWriter writer = PdfWriter.getInstance(documento, response.getOutputStream());

        // Cabecera y pie de página personalizados
        writer.setPageEvent(new PdfPageEventHelper() {
            @Override
            public void onEndPage(PdfWriter writer, Document document) {
                try {
                    PdfContentByte cb = writer.getDirectContent();

                    Image header = Image.getInstance("src/main/resources/static/logo.png");

// Escala la imagen al ancho del documento (menos márgenes si es necesario)
                    header.scaleToFit(documento.getPageSize().getWidth(), 100); // 100 de alto aprox
                    header.setAbsolutePosition(0, documento.getPageSize().getHeight() - header.getScaledHeight()); // arriba del todo
                    cb.addImage(header);


                    // Pie de página
                    ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                            new Phrase("Página " + document.getPageNumber()),
                            (document.right() - document.left()) / 2 + document.leftMargin(),
                            document.bottom() - 10, 0);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        documento.open();

        // Título
        Font tituloFont = new Font(Font.HELVETICA, 14, Font.BOLD);
        Paragraph titulo = new Paragraph("Reporte de Ficha de Inventario", tituloFont);
        titulo.setAlignment(Element.ALIGN_CENTER);
        documento.add(titulo);
        documento.add(new Paragraph(" "));

        // Datos generales
        documento.add(new Paragraph("Centro de Costo: " + ficha.getCentroDeCosto()));
        documento.add(new Paragraph("Responsable: Bryan Silva"));
        documento.add(new Paragraph("Fecha de generación: " + java.time.LocalDate.now()));
        documento.add(new Paragraph(" "));

        // Tabla de bienes
        PdfPTable tabla = new PdfPTable(3); // 3 columnas
        tabla.setWidthPercentage(100);
        tabla.setSpacingBefore(10f);

        tabla.addCell("Código");
        tabla.addCell("Denominación");
        tabla.addCell("Estado");

        // Simulación de bienes
        Set<Bien> bienes = ficha.getBienes();

        for(Bien b : bienes){
            tabla.addCell(b.getCodigoActual());
            tabla.addCell(b.getDenominacion());
            tabla.addCell(b.getEstado().toString());
        }
        documento.add(tabla);

        // Espacio para firma
        documento.add(new Paragraph("\n\n\n"));
        documento.add(new Paragraph("___________________________"));
        documento.add(new Paragraph("Firma del Responsable"));

        documento.close();
    }
                }
