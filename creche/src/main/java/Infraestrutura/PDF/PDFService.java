/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infraestrutura.PDF;

import Dominio.Fatures.Relatorio.Relatorio;
import Dominio.Features.Crianca.Crianca;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author T0KS1CK
 */
public class PDFService implements IPDFService{

    public void gerarPdfRelatorio(List<Relatorio> relatorios, Crianca crianca, String path) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(path));
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");


        document.open();
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, BaseColor.BLACK);

        Chunk chunk = new Chunk("Nome criança: " + crianca.getNome() + "\n", font);
        chunk.append("Nome cuidador: " + crianca.getTurma().getCuidador().getNome() + "\n");
        chunk.append("Telefone cuidador: " + crianca.getTurma().getCuidador().getTelefone() + "\n");
        document.add(new Paragraph(chunk));
        
        chunk = new Chunk("\n\nRELATÓRIOS\n\n", font);
        document.add(chunk);        
        
        for (Relatorio relatorio : relatorios) {
            chunk = new Chunk("Data: " + df.format(relatorio.getData()) + "\n", font);
            chunk.append("Texto: " + relatorio.getTexto() + "\n\n");
            document.add(new Paragraph(chunk));
        } 

        document.close();
    }
}
