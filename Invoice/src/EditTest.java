import javax.swing.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author princ
 */
public class EditTest{      
	private JFrame frame;
    private JTextField DescriptionField1;
    private JTextField DescriptionField2;
    private JTextField DescriptionField3;
    private JTextField ItemDescField1;
    private JTextField ItemDescField2;
    private JTextField ItemDescField3;
    private JTextField PriceField1;
    private JTextField PriceField2;
    private JTextField PriceField3;
    private JTextField QtyField1;
    private JTextField QtyField2;
    private JTextField QtyField3;
    private JButton SaveChangeBtn;
    private JPanel Testedit;
    // End of variables declaration         
    public EditTest(String passedInvoice) {
    	
    	frame = new JFrame();
        Testedit = new JPanel();
        SaveChangeBtn = new JButton();
        ItemDescField1 = new JTextField();
        DescriptionField1 = new JTextField();
        PriceField1 = new JTextField();
        QtyField2 = new JTextField();
        QtyField1 = new JTextField();
        ItemDescField2 = new JTextField();
        DescriptionField2 = new JTextField();
        ItemDescField3 = new JTextField();
        DescriptionField3 = new JTextField();
        QtyField3 = new JTextField();
        PriceField2 = new JTextField();
        PriceField3 = new JTextField();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        SaveChangeBtn.setText("Save");
        SaveChangeBtn.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent ae){
        		SaveChangeBtnActionPerformed();
        	}
        });
        
        try{
        	XPath ipath = XPathFactory.newInstance().newXPath();
     		Document docitem = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("C:\\Users\\princ\\Documents\\items.xml");
     		docitem.getDocumentElement().normalize();
     		
    		XPathExpression itemexpr = ipath.compile("//ItemInfo/Items/Invoice[text()=" + passedInvoice + "]");

    		NodeList itemList = (NodeList)(itemexpr.evaluate(docitem, XPathConstants.NODESET));
    		
    		if (itemList.getLength() == 1){		
    				Node item = itemList.item(0).getParentNode();							
        			Element iElement = (Element) item;
        			
    				ItemDescField1 = new JTextField();
    		        DescriptionField1 = new JTextField();
    		        PriceField1 = new JTextField();
    		        QtyField1 = new JTextField();
    		        
    				QtyField1.setText("1");
    				ItemDescField1.setText(iElement.getElementsByTagName("ItemDesc").item(0).getTextContent());
    				DescriptionField1.setText(iElement.getElementsByTagName("Description").item(0).getTextContent());
    				PriceField1.setText(iElement.getElementsByTagName("Price").item(0).getTextContent());	
    		}else if(itemList.getLength() == 2){	
    				Node item = itemList.item(0).getParentNode();							
        			Element iElement = (Element) item;
        			
    				ItemDescField1 = new JTextField();
    		        DescriptionField1 = new JTextField();
    		        PriceField1 = new JTextField();
    		        QtyField1 = new JTextField();
    		        
    				QtyField1.setText("1");
    				ItemDescField1.setText(iElement.getElementsByTagName("ItemDesc").item(0).getTextContent());
    				DescriptionField1.setText(iElement.getElementsByTagName("Description").item(0).getTextContent());
    				PriceField1.setText(iElement.getElementsByTagName("Price").item(0).getTextContent());	
    				
    				///////////////////////2nd item
    				Node item2 = itemList.item(1).getParentNode();							
        			Element iElement2 = (Element) item2;
    				
    				ItemDescField2 = new JTextField();
    		        DescriptionField2 = new JTextField();
    		        PriceField2 = new JTextField();
    		        QtyField2 = new JTextField();
    		        
    				QtyField2.setText("1");
    				ItemDescField2.setText(iElement2.getElementsByTagName("ItemDesc").item(0).getTextContent());
    				DescriptionField2.setText(iElement2.getElementsByTagName("Description").item(0).getTextContent());
    				PriceField2.setText(iElement2.getElementsByTagName("Price").item(0).getTextContent());	
    		}else if(itemList.getLength() == 3){	
    				Node item = itemList.item(0).getParentNode();							
        			Element iElement = (Element) item;	
        			
    				ItemDescField1 = new JTextField();
    		        DescriptionField1 = new JTextField();
    		        PriceField1 = new JTextField();
    		        QtyField1 = new JTextField();
    		        
    				QtyField1.setText("1");
    				ItemDescField1.setText(iElement.getElementsByTagName("ItemDesc").item(0).getTextContent());
    				DescriptionField1.setText(iElement.getElementsByTagName("Description").item(0).getTextContent());
    				PriceField1.setText(iElement.getElementsByTagName("Price").item(0).getTextContent());
    				
    				///////////////////////2nd item
    				Node item2 = itemList.item(1).getParentNode();							
        			Element iElement2 = (Element) item2;	
        			
    				ItemDescField2 = new JTextField();
    				DescriptionField2 = new JTextField();
    				PriceField2 = new JTextField();
    				QtyField2 = new JTextField();
  		        
    				QtyField2.setText("1");
    				ItemDescField2.setText(iElement2.getElementsByTagName("ItemDesc").item(0).getTextContent());
    				DescriptionField2.setText(iElement2.getElementsByTagName("Description").item(0).getTextContent());
    				PriceField2.setText(iElement2.getElementsByTagName("Price").item(0).getTextContent());
    				
    				//////////////////////3rd item
    				
    				Node item3 = itemList.item(2).getParentNode();							
        			Element iElement3 = (Element) item3;	
    				
    				ItemDescField3 = new JTextField();
    				DescriptionField3 = new JTextField();
    				PriceField3 = new JTextField();
    				QtyField3 = new JTextField();
  		        
    				QtyField3.setText("1");
    				ItemDescField3.setText(iElement3.getElementsByTagName("ItemDesc").item(0).getTextContent());
    				DescriptionField3.setText(iElement3.getElementsByTagName("Description").item(0).getTextContent());
    				PriceField3.setText(iElement3.getElementsByTagName("Price").item(0).getTextContent());
    			}
        }catch(Exception e){
        	e.printStackTrace();
        }

        GroupLayout TesteditLayout = new GroupLayout(Testedit);
        Testedit.setLayout(TesteditLayout);
        TesteditLayout.setHorizontalGroup(
            TesteditLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(TesteditLayout.createSequentialGroup()
                .addGroup(TesteditLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(TesteditLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(TesteditLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(QtyField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(QtyField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))
                    .addGroup(GroupLayout.Alignment.TRAILING, TesteditLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(QtyField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(TesteditLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(TesteditLayout.createSequentialGroup()
                        .addGroup(TesteditLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(DescriptionField3, GroupLayout.PREFERRED_SIZE, 455, GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemDescField3, GroupLayout.PREFERRED_SIZE, 455, GroupLayout.PREFERRED_SIZE)
                            .addComponent(DescriptionField2, GroupLayout.PREFERRED_SIZE, 455, GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(TesteditLayout.createSequentialGroup()
                        .addGroup(TesteditLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(TesteditLayout.createSequentialGroup()
                                .addGroup(TesteditLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(DescriptionField1, GroupLayout.PREFERRED_SIZE, 455, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ItemDescField1, GroupLayout.PREFERRED_SIZE, 455, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                                .addGroup(TesteditLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(PriceField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SaveChangeBtn)
                                    .addComponent(PriceField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(TesteditLayout.createSequentialGroup()
                                .addComponent(ItemDescField2, GroupLayout.PREFERRED_SIZE, 455, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PriceField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGap(88, 88, 88))))
        );
        TesteditLayout.setVerticalGroup(
            TesteditLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(TesteditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TesteditLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(TesteditLayout.createSequentialGroup()
                        .addGroup(TesteditLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(QtyField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemDescField1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                            .addComponent(PriceField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(TesteditLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(TesteditLayout.createSequentialGroup()
                                .addComponent(DescriptionField1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(QtyField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addComponent(PriceField2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addComponent(ItemDescField2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DescriptionField2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(TesteditLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(ItemDescField3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addComponent(QtyField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(PriceField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DescriptionField3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(EditTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditTest("17001");
            }
        });
    }          
}
