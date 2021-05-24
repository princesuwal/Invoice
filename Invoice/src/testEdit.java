import javax.swing.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author princ
 */
public class testEdit{       
	private JFrame frame;
    private JTextField DescriptionField;
    private JTextField ItemDescField;
    private JTextField PriceField;
    private JTextField QtyField;
    private JButton SaveChangeBtn;
    private JPanel Testedit;
    public String CurrentInvoice;
    // End of variables declaration        
    public testEdit(String passedInvoice) {
    	frame = new JFrame();
        Testedit = new JPanel();
        SaveChangeBtn = new JButton();
        CurrentInvoice = passedInvoice;

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        try{
        	XPath ipath = XPathFactory.newInstance().newXPath();
     		Document docitem = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("C:\\Users\\princ\\Documents\\items.xml");
     		docitem.getDocumentElement().normalize();
     		
    		XPathExpression itemexpr = ipath.compile("//ItemInfo/Items/Invoice[text()=" + passedInvoice + "]");

    		NodeList itemList = (NodeList)(itemexpr.evaluate(docitem, XPathConstants.NODESET));
    		
    		if (itemList.getLength() > 0){
    			Node item = itemList.item(0).getParentNode();							
    			Element iElement = (Element) item;		
    			for(int i = 0; i < itemList.getLength();i++){
    				ItemDescField = new JTextField();
    		        DescriptionField = new JTextField();
    		        PriceField = new JTextField();
    		        QtyField = new JTextField();
    		        
    				QtyField.setText("1");
    				ItemDescField.setText(iElement.getElementsByTagName("ItemDesc").item(0).getTextContent());
    				DescriptionField.setText(iElement.getElementsByTagName("Description").item(0).getTextContent());
    				PriceField.setText(iElement.getElementsByTagName("Price").item(0).getTextContent());	
    			}
    		}
        }catch(Exception e){
        	e.printStackTrace();
        }
       

        SaveChangeBtn.setText("Save");
        SaveChangeBtn.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent ae){
        		SaveChangeBtnActionPerformed();
        	}
        });

        GroupLayout TesteditLayout = new GroupLayout(Testedit);
        Testedit.setLayout(TesteditLayout);
        TesteditLayout.setHorizontalGroup(
            TesteditLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, TesteditLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SaveChangeBtn)
                .addGap(107, 107, 107))
            .addGroup(TesteditLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(QtyField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addGroup(TesteditLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(TesteditLayout.createSequentialGroup()
                        .addComponent(DescriptionField, GroupLayout.PREFERRED_SIZE, 455, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(TesteditLayout.createSequentialGroup()
                        .addComponent(ItemDescField, GroupLayout.PREFERRED_SIZE, 455, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(PriceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))))
        );
        TesteditLayout.setVerticalGroup(
            TesteditLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(TesteditLayout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addGroup(TesteditLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(ItemDescField, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addComponent(PriceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(QtyField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(DescriptionField, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                .addComponent(SaveChangeBtn)
                .addGap(80, 80, 80))
        );

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(Testedit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(Testedit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        frame.setVisible(true);
        frame.pack();
    }// </editor-fold>   
    
    public void SaveChangeBtnActionPerformed(){
    	try {
        	XPath ipath = XPathFactory.newInstance().newXPath();
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("C:\\Users\\princ\\Documents\\items.xml");
			doc.getDocumentElement().normalize();
     		
    		XPathExpression itemexpr = ipath.compile("//ItemInfo/Items/Invoice[text()=" + CurrentInvoice + "]");

    		NodeList itemList = (NodeList)(itemexpr.evaluate(doc, XPathConstants.NODESET));
    		
    		for(int i = 0; i < itemList.getLength(); i++){
    			
    			Node ItemParent  = itemList.item(i).getParentNode();
    			
    			NodeList NewNodeList = ItemParent.getChildNodes();
    			if(NewNodeList.getLength() > 0){
    					Node ItemInfo = NewNodeList.item(0).getParentNode();
    					
    					Element itemE = (Element) ItemInfo;
    					
    					if("ItemDesc".equals(itemE.getElementsByTagName("ItemDesc").item(0).getNodeName())){
    						itemE.getElementsByTagName("ItemDesc").item(0).setTextContent(ItemDescField.getText());
    	    				System.out.print("here");
    	    			}
    			}else{
    				System.out.println("Blaaaah");
    			}
    		}
			
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("C:\\Users\\princ\\Documents\\items.xml"));
			transformer.transform(source, result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(testEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(testEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(testEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(testEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new testEdit("17002");
            }
        });
    }           
}
