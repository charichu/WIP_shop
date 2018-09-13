package cartFunctions;

import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import courseFunctions.Course;
import functions.DBFunctions;

import javax.servlet.http.*;

public class PdfInvoice {
    
    //Fonts for future reference
    private static com.itextpdf.text.Font font1 = FontFactory.getFont("Arial", BaseFont.IDENTITY_H, 10, Font.PLAIN);
    private static com.itextpdf.text.Font font2 = FontFactory.getFont("Arial", BaseFont.IDENTITY_H, 14, Font.BOLD);
    
    //Literals
    private static final String tutor24Address = "Tutor24 GmbH\nAndreas Tutorius\nMeisenstraße 92\nD 33607 Bielefeld\n";
    private static final String invoiceTitle = "Rechnung";
    private static final String bankAccount = "	Spaßkasse\n	IBAN: DEXX XXXX XXXX XXXX XXXX XX\n	BIC: SPASSDEXXXX";
    private static final String invoiceText = "Vielen Dank für ihre Bestellung.\nBitte überweisen sie den ausstehenden Betrag innerhalb von zwei Wochen an die unten aufgeführte Bankverbindung.";

    public static void print(ArrayList<Course> bookingList, HashMap<Integer, Integer> cart, double sum, int orderID, HttpServletRequest request){
        
        try {
        	String filename = new String ("C://xampp//Invoice_" + orderID + ".pdf");
        	createPDF(filename, bookingList, cart, sum, orderID, request);        	
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void createPDF(String filename, ArrayList<Course> bookingList, HashMap<Integer, Integer> cart, double sum, int orderID, HttpServletRequest request) throws DocumentException, MalformedURLException, IOException{
    	  	
    	Document document = new Document(PageSize.A4, 40, 20, 0, 0);
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.open();
        
        //Spacing to the top
        Paragraph paragraph1 = new Paragraph("\n");
        document.add(paragraph1);
        
          Image img = Image.getInstance("C:/Users/vennemei/git/WIP_shop3/WIP_shop_dynamic/WebContent/img/logo.png");
          img.setAlignment(Element.ALIGN_RIGHT);
        
        //Vendor Information
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setSpacingBefore(40f);
        table.setWidths(new int[]{2, 1, 2});
        PdfPCell cell = new PdfPCell(new Phrase(tutor24Address, font1));
            cell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
            cell.setBorder(0);
        table.addCell(cell);
        
        //Middle of the header
        PdfPCell cellrg = new PdfPCell(new Phrase(invoiceTitle, font2));
            cellrg.setBorder(0);
            cellrg.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
            cellrg.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        table.addCell(cellrg);
        
        //Image Cell
        PdfPCell cell2 = new PdfPCell();
        cell2.setBorder(0);
        cell2.setHorizontalAlignment(PdfPCell.RIGHT);
        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);            
        
          Chunk chunkImg = new Chunk(img, 100, -10);
          cell2.addElement(chunkImg);
            
        table.addCell(cell2);
        document.add(table);
        
        //Date via calendar instance
        Date now = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(now);

        // Add 14 days for the deadline
        calendar.add(Calendar.DAY_OF_MONTH, 14);

        // get the date instance
        Date future = calendar.getTime();
        
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");     
        
        //Creating Stringbuilders for invoice date and deadline date
        StringBuilder dateBuilder = new StringBuilder(dateFormat.format(now));
        StringBuilder deadline = new StringBuilder(dateFormat.format(future));
        Paragraph leftDate = new Paragraph();
            leftDate.setAlignment(Element.ALIGN_LEFT);
            leftDate.setFont(font1);
            leftDate.add("" + dateBuilder);
        
        document.add(new LineSeparator());  
            
        document.add(leftDate);
        document.add(new Paragraph(""));     
        
        //make sql statement
        ResultSet rs = null;
		try {
			rs = DBFunctions.Execute("select * from addresses where addressID = (SELECT addressID FROM user WHERE userID = (SELECT userID FROM orders WHERE orderID = "+orderID+"))");
			if(rs.next()){
				String recipient = rs.getString("user.firstName") + " " + rs.getString("user.lastName");
				String street = rs.getString("addresses.street");
				String city = rs.getString("addresses.plz") + " " + rs.getString("addresses.city");;
				String userID ="user.userid";
			
			
			// Address on the left side
			PdfPTable adressTable = new PdfPTable(2);
			adressTable.setHorizontalAlignment(PdfPTable.ALIGN_RIGHT);
			adressTable.setSpacingBefore(40f);
			adressTable.setWidthPercentage(96f);
			cell = new PdfPCell(new Phrase("\n" + recipient + "\n" + street + "\n" + city));
			cell.setBorder(0);

			// Details on the right side
			adressTable.addCell(cell);
			Chunk chunk = new Chunk("Rechnungsnummer: " + orderID + "\nKundennummer: " + userID + "\nRechnungsdatum: "
					+ dateBuilder + "\nZahlungsfrist: " + deadline);
			cell = new PdfPCell(new Phrase(chunk));
			cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
			cell.setBorder(0);
			adressTable.addCell(cell);

			document.add(adressTable);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
        
		//Variables for the address		
		

			// Table header for the actual order items
			PdfPTable table2 = new PdfPTable(9);
			table2.setWidths(new int[] { 2, 2, 2, 2, 2, 2, 2, 2, 2});
			table2.setSpacingBefore(50f);
			// header of order table
			table2.addCell(bookingList.get(0).getSubject());
			table2.addCell(bookingList.get(0).getDescription());
			table2.addCell(bookingList.get(0).getStudentType());
			table2.addCell(bookingList.get(0).getFrequency());
			table2.addCell(bookingList.get(0).getDurationPerMeetingDescription());
			table2.addCell(bookingList.get(0).getPricePerHour());
			table2.addCell("Preis pro Treffen");
			table2.addCell("Anzahl");
			table2.addCell("Summe");
			                                   
            // Loop to create the table for the single ordered items
			bookingList.remove(0);
			request.getSession().setAttribute("bookingList", bookingList);
			for(Course course:bookingList){
			
			//Calculation for Subtotal
			Double subTotal = cart.get(course.getCourseNumber())*course.getPricePerMeeting();
				
			table2.addCell(course.getSubject());
			table2.addCell(course.getDescription());
			table2.addCell(course.getStudentType());
			table2.addCell(course.getFrequency());
			table2.addCell(course.getDurationPerMeetingDescription());
			table2.addCell(course.getPricePerHour());
			table2.addCell(String.valueOf(course.getPricePerMeeting()));
			table2.addCell(String.valueOf(cart.get(course.getCourseNumber())));
			table2.addCell(String.valueOf(subTotal));
			
			}
           			
			document.add(table2);
		           
        //Small text for the invoice
        Paragraph paragraph2 = new Paragraph(invoiceText);
        paragraph2.setSpacingBefore(40f);
        paragraph2.setSpacingAfter(40f);
        document.add(paragraph2);
        
        document.add(new LineSeparator()); 
        //Vendor Information bank account
        Paragraph paragraph3 = new Paragraph(bankAccount, font1);
        paragraph2.setSpacingBefore(10f);
        document.add(paragraph3);
        
        document.close();
    }
    
//    public static void main(String[] args) {
//        PdfInvoice invoice = new PdfInvoice();
//        invoice.print(null, null, 0, 0, null);
//    }

}