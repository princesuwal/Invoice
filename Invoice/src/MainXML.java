import java.io.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.*;

public class MainXML {

	public void AddCustomerInfo(String ninvoice, String cname, String caddress, String cphone, String cphone2, String cmemo, String cnote){
    	try{
    		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
    						.parse(new File("C:\\Users\\princ\\Documents\\customer.xml"));
    		
        
            //invoice number element
            Element customer = doc.createElement("Customer");
            
            Element invoice = doc.createElement("Invoice");
            customer.appendChild(invoice);
            invoice.appendChild(doc.createTextNode(ninvoice));
            
            //element customer name
            Element name = doc.createElement("Name");
            customer.appendChild(name);
            name.appendChild(doc.createTextNode(cname));
        
            //element customer address
            Element address = doc.createElement("Address");
            customer.appendChild(address);
            address.appendChild(doc.createTextNode(caddress));
        
            //element customer telephone
            Element phone = doc.createElement("Phone");
            customer.appendChild(phone);
            phone.appendChild(doc.createTextNode(cphone));
            
            Element phone2 = doc.createElement("Phone2");
            customer.appendChild(phone2);
            phone2.appendChild(doc.createTextNode(cphone2));
            
            Element memo = doc.createElement("Memo");
            customer.appendChild(memo);
            memo.appendChild(doc.createTextNode(cmemo));
            
            Element note = doc.createElement("Note");
            customer.appendChild(note);
            note.appendChild(doc.createTextNode(cnote));
            
            doc.getDocumentElement().appendChild(doc.importNode(customer, true));
            
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            StreamResult result = new StreamResult(new FileWriter("C:\\Users\\princ\\Documents\\customer.xml"));
            DOMSource source = new DOMSource(doc);
            transformer.transform(source,  result);
    
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }//addtoXML ends here
	
	
	public void AddItemDescription(String ninvoice, String cdate, String citemdesc, String cdescription, String cprice){    	
    	try{
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
            		.parse(new File("C:\\Users\\princ\\Documents\\items.xml"));
            //root element Customer info
        
            //items element
            Element items = doc.createElement("Items");
            
            //invoice no element
            Element invoice = doc.createElement("Invoice");
            items.appendChild(invoice);
            invoice.appendChild(doc.createTextNode(ninvoice));
            
            //element date
            Element date = doc.createElement("Date");
            items.appendChild(date);
            date.appendChild(doc.createTextNode(cdate));
            
            //element qty
            Element qty = doc.createElement("Qty");
            items.appendChild(qty);
            qty.appendChild(doc.createTextNode("1"));
            
            
            Element itemdesc = doc.createElement("ItemDesc");
            items.appendChild(itemdesc);
            itemdesc.appendChild(doc.createTextNode(citemdesc));
            
            Element description = doc.createElement("Description");
            items.appendChild(description);
            description.appendChild(doc.createTextNode(cdescription));
            
            Element price = doc.createElement("Price");
            items.appendChild(price);
            price.appendChild(doc.createTextNode(cprice));
            
            doc.getDocumentElement().appendChild(doc.importNode(items, true));
        
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new FileWriter("C:\\Users\\princ\\Documents\\items.xml"));  
            
            transformer.transform(source, result);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }//add item to item.xml ends here
	
	public void ReceivePayments(int ninvoice, String PDate, String PPaid, String PItem){
		try{
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
            		.parse(new File("C:\\Users\\princ\\Documents\\payments.xml"));
            //root element Customer info
         
            //items element
            Element payments = doc.createElement("Payments");
            
            //invoice no element
            Element invoice = doc.createElement("Invoice");
            payments.appendChild(invoice);
            invoice.appendChild(doc.createTextNode(Integer.toString(ninvoice)));
            
            //element date
            Element date = doc.createElement("Date");
            payments.appendChild(date);
            date.appendChild(doc.createTextNode(PDate));
            
            //amount Paid
            Element paid = doc.createElement("Paid");
            payments.appendChild(paid);
            paid.appendChild(doc.createTextNode(PPaid));
            
            //element itemmemo
            Element itemmemo = doc.createElement("Memo");
            payments.appendChild(itemmemo);
            itemmemo.appendChild(doc.createTextNode(PItem));
            
            doc.getDocumentElement().appendChild(doc.importNode(payments, true));
        
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new FileWriter("C:\\Users\\princ\\Documents\\payments.xml"));  
            
            transformer.transform(source, result);
            
        }catch(Exception e){
            e.printStackTrace();
        }
	}

	public int IncrementInvoiceNo(){
    	int inv = 17000;
    	try{
    		XPath path = XPathFactory.newInstance().newXPath();
    		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("C:\\Users\\princ\\Documents\\customer.xml");
    		doc.getDocumentElement().normalize();
    		
    		inv = (Integer.parseInt(path.evaluate("//CustomerInfo/Customer[last()]/Invoice", doc)) + 1);
    		return inv;
    	}catch(Exception e){
    		e.printStackTrace();
    		System.exit(0);
    	}
		return inv;
    }
}
