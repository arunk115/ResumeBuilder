package com.mia.reporting;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

@Component
public class HtmlToPdfConverter {

	
	public ResponseEntity<?> generatePdf(String html) {
		PdfWriter pdfWriter;
		
		Document pdfDocument = new Document();
        String resultPath = String.format("%s%s%s", "D:\\Eclipse", "resume", new SimpleDateFormat("yyyyMMddhhmmss'.pdf'")
                .format(new Date()));

        pdfDocument.addAuthor("Arun");
        pdfDocument.addCreationDate();
        pdfDocument.addCreator("Arun");
        pdfDocument.addTitle("Sample");
        pdfDocument.setPageSize(PageSize.A4);

        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<?>responseEntity=new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        try (OutputStream os = Files.newOutputStream(Paths.get(resultPath))) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            pdfWriter = PdfWriter.getInstance(pdfDocument, os);
            pdfDocument.open();

            XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();
            xmlWorkerHelper.getDefaultCssResolver(true);

            xmlWorkerHelper.parseXHtml(pdfWriter, pdfDocument, new StringReader(html));
            // close the document
            pdfDocument.close();
            // close the writer
            pdfWriter.close();
            PdfReader reader = new PdfReader(resultPath);
            //you can only retrieve the ByteArrayOutputStream after using a stamper
            PdfStamper stamper = new PdfStamper(reader, baos);
            stamper.close();//you need to wait for it to close
            
            byte[] byteArray = baos.toByteArray();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
            responseEntity= new ResponseEntity<>(byteArray, headers, HttpStatus.OK);

        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
        return responseEntity;
	}
}
