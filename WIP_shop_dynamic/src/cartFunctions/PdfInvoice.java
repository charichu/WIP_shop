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

/**
*
* This class creates an invoice in pdf format.
*<br> It uses the bookingList and current session for this.
*
*@version 1.0
*/

public class PdfInvoice {
    
    //Fonts for future reference
    private static com.itextpdf.text.Font font1 = FontFactory.getFont("Arial", BaseFont.IDENTITY_H, 10, Font.PLAIN);
    private static com.itextpdf.text.Font font2 = FontFactory.getFont("Arial", BaseFont.IDENTITY_H, 14, Font.BOLD);
    
    //Literals
    private static final String tutor24Address = "Tutor24 GmbH\nAndreas Tutorius\nMeisenstra�e 92\nD 33607 Bielefeld\n";
    private static final String invoiceTitle = "Rechnung";
    private static final String bankAccount = "	Spa�kasse\n	IBAN: DEXX XXXX XXXX XXXX XXXX XX\n	BIC: SPASSDEXXXX";
    private static final String invoiceText = "Vielen Dank f�r ihre Bestellung.\nBitte �berweisen sie den ausstehenden Betrag innerhalb von zwei Wochen an die unten aufgef�hrte Bankverbindung.\nMit freundlichen Gr��en\n\nIhr tutor24-Team";

/**
*
* This method creates a filename and then calls the method createPDF.
*<br> The filename is the saving destination of the pdf.
*
*@param bookingList ArrayList from the order 
*@param cart Hashmap including the amounts of items
*@param sum double containg the total of the order
*@param orderID Number of the order
*@param request HttpServletRequest to get the userID
*/
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
    
/**
*
* This method creates the actual invoice.
*<br> Seperate fixed tables, logos, texts and footer is added.
*<br> Loops over the bookingList to create an order overview.
*
*@param filename String containg the absolute path
*@param bookingList ArrayList from the order 
*@param cart Hashmap including the amounts of items
*@param sum double containg the total of the order
*@param orderID Number of the order
*@param request HttpServletRequest to get the userID
*/
    private static void createPDF(String filename, ArrayList<Course> bookingList, HashMap<Integer, Integer> cart, double sum, int orderID, HttpServletRequest request) throws DocumentException, MalformedURLException, IOException{
    	  	
    	Document document = new Document(PageSize.A4, 40, 20, 0, 0);
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.open();
        
        //Spacing to the top
        Paragraph paragraph1 = new Paragraph("\n");
        document.add(paragraph1);
        
          Image img = Image.getInstance("C:/xampp/img/logo.png");
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
        Date future = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(now);

        // Add 14 days for the deadline
        calendar.add(Calendar.DAY_OF_MONTH, 14);

        // get the date instance
        future = calendar.getTime();
        
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");     
        
        //Creating Stringbuilders for invoice date and deadline date
        StringBuilder dateBuilder = new StringBuilder(dateFormat.format(now));
        StringBuilder deadline = new StringBuilder(dateFormat.format(future));
        Paragraph leftDate = new Paragraph();
            leftDate.setAlignment(Element.ALIGN_RIGHT);
            leftDate.setFont(font1);
            leftDate.add("" + dateBuilder);
        
        document.add(new LineSeparator());  
            
        document.add(leftDate);
        document.add(new Paragraph(""));     
        
        //make sql statement
        ResultSet rs = null;
		try {
			Integer userID = (Integer)request.getSession().getAttribute("userId");
			rs = DBFunctions.Execute("SELECT addresses.plz, addresses.city, addresses.street, addresses.housenumber, user.firstName, user.lastName FROM addresses, user WHERE user.userID = "+userID+" AND addresses.addressID = user.addressID;");
			if(rs.next()){
				String recipient = rs.getString("user.firstName") + " " + rs.getString("user.lastName");
				String street = rs.getString("addresses.street") + " " + rs.getString("addresses.housenumber");
				String city = rs.getString("addresses.plz") + " " + rs.getString("addresses.city");;
				String customer = String.valueOf(userID);
			
			
			// Address on the left side
			PdfPTable adressTable = new PdfPTable(2);
			adressTable.setHorizontalAlignment(PdfPTable.ALIGN_RIGHT);
			adressTable.setSpacingBefore(40f);
			adressTable.setWidthPercentage(96f);
			cell = new PdfPCell(new Phrase("\n" + recipient + "\n" + street + "\n" + city));
			cell.setBorder(0);

			// Details on the right side
			adressTable.addCell(cell);
			Chunk chunk = new Chunk("Rechnungsnummer: " + orderID + "\nKundennummer: " + customer + "\nRechnungsdatum: "
					+ dateBuilder + "\nZahlungsfrist: " + deadline);
			cell = new PdfPCell(new Phrase(chunk));
			cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
			cell.setBorder(0);
			adressTable.addCell(cell);

			document.add(adressTable);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
		//Variables for the address		
		

			// Table header for the actual order items
			PdfPTable table2 = new PdfPTable(9);
			table2.setWidthPercentage(100);
			table2.setWidths(new int[] { 2, 2, 2, 2, 2, 2, 2, 2, 2});
			table2.setSpacingBefore(50f);
			table2.setSpacingAfter(10f);
			
			
			// header of order table
			table2.addCell(getCell("Fach"));
			table2.addCell(getCell("Thema"));
			table2.addCell(getCell("Schüler/ Student"));
			table2.addCell(getCell("Frequenz"));			
			table2.addCell(getCell("Dauer des Treffens"));
			table2.addCell(getCell("Stundenpreis"));
			table2.addCell(getCell("Preis pro Treffen"));
			table2.addCell(getCell("Anzahl"));
			table2.addCell(getCell("Summe"));                                   
            // Loop to create the table for the single ordered items
			for(Course course:bookingList){
				
				//Calculation for Subtotal
				Double subTotal = cart.get(Integer.parseInt(course.getCourseNumber()))*course.getPricePerMeeting();
				table2.addCell(getCell(course.getSubject()));
				table2.addCell(getCell(course.getTopic()));
				table2.addCell(getCell(course.getStudentType()));
				table2.addCell(getCell(course.getFrequency()));
				table2.addCell(getCell(course.getDurationPerMeetingDescription()));
				table2.addCell(getCell(course.getPricePerHour()));
				table2.addCell(getCell(String.valueOf(course.getPricePerMeeting())));
				table2.addCell(getCell(String.valueOf(cart.get(Integer.parseInt(course.getCourseNumber())))));
				table2.addCell(getCell(String.valueOf(subTotal)));
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
 
/**
*
* This method is a bug fix.
*<br> It adjusts the position of the text in the overview table.
*
*@param value String that contains the content of the cell
*@return Returns the given cell
*/
    public static PdfPCell getCell(String value) {
        PdfPCell cell = new PdfPCell();
        cell.setUseAscender(true);
        cell.setUseDescender(true);
        Paragraph p = new Paragraph(value);
        cell.addElement(p);
        return cell;
    }
    
    
//    public static void main(String[] args) {
//        PdfInvoice invoice = new PdfInvoice();
//        invoice.print(null, null, 0, 0, null);
//    }

}
