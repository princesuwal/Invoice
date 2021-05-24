package abcd;
import javax.swing.*;
import javax.swing.table.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author princ
 */
public class testdisplay{    
	
	private JFrame frame;
    private JButton BackstoMainBtn4;
    private JPanel DisplayAllPanel;
    private JScrollPane DisplayScrollPane;
    private JTable DisplayTable;
    private JLabel TitleBalance;
    private JLabel TitleCustomerInfo;
    private JLabel TitleDate;
    private JLabel TitleInvoice;
    private JLabel TitleItemDescription;
    private JLabel TitleMemo;
    private JLabel TitleNote;
    private JLabel TitlePayment;
    private JLabel TitlePrice;
    public String CInvoice, CDate, CName, CPhone, CItem, CModel, CProblem, CDescription, CPrice, CPayment, CBalance, CMemo, CNote;
    
    public testdisplay() {

    	frame = new JFrame();
        DisplayAllPanel = new JPanel();
        BackstoMainBtn4 = new JButton();
        TitleInvoice = new JLabel();
        TitleDate = new JLabel();
        TitleCustomerInfo = new JLabel();
        TitleItemDescription = new JLabel();
        TitlePrice = new JLabel();
        TitlePayment = new JLabel();
        TitleBalance = new JLabel();
        TitleMemo = new JLabel();
        TitleNote = new JLabel();
        DisplayScrollPane = new JScrollPane();
        DisplayTable = new JTable();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        BackstoMainBtn4.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        BackstoMainBtn4.setText("< Main Menu");
        BackstoMainBtn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BackstoMainBtn4ActionPerformed(evt);
            }
        });

        TitleInvoice.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        TitleInvoice.setHorizontalAlignment(SwingConstants.CENTER);
        TitleInvoice.setText("Invoice");
        TitleInvoice.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        TitleInvoice.setHorizontalTextPosition(SwingConstants.CENTER);

        TitleDate.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        TitleDate.setHorizontalAlignment(SwingConstants.CENTER);
        TitleDate.setText("Date");
        TitleDate.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        TitleDate.setHorizontalTextPosition(SwingConstants.CENTER);

        TitleCustomerInfo.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        TitleCustomerInfo.setHorizontalAlignment(SwingConstants.CENTER);
        TitleCustomerInfo.setText("Customer Info.");
        TitleCustomerInfo.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        TitleCustomerInfo.setHorizontalTextPosition(SwingConstants.CENTER);

        TitleItemDescription.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        TitleItemDescription.setHorizontalAlignment(SwingConstants.CENTER);
        TitleItemDescription.setText("Item Description");
        TitleItemDescription.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        TitleItemDescription.setHorizontalTextPosition(SwingConstants.CENTER);

        TitlePrice.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        TitlePrice.setHorizontalAlignment(SwingConstants.CENTER);
        TitlePrice.setText("Price");
        TitlePrice.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        TitlePrice.setHorizontalTextPosition(SwingConstants.CENTER);

        TitlePayment.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        TitlePayment.setHorizontalAlignment(SwingConstants.CENTER);
        TitlePayment.setText("Payment");
        TitlePayment.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        TitlePayment.setHorizontalTextPosition(SwingConstants.CENTER);

        TitleBalance.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        TitleBalance.setHorizontalAlignment(SwingConstants.CENTER);
        TitleBalance.setText("Balance");
        TitleBalance.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        TitleBalance.setHorizontalTextPosition(SwingConstants.CENTER);

        TitleMemo.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        TitleMemo.setHorizontalAlignment(SwingConstants.CENTER);
        TitleMemo.setText("Memo");
        TitleMemo.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        TitleMemo.setHorizontalTextPosition(SwingConstants.CENTER);

        TitleNote.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        TitleNote.setHorizontalAlignment(SwingConstants.CENTER);
        TitleNote.setText("Notes");
        TitleNote.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        TitleNote.setHorizontalTextPosition(SwingConstants.CENTER);

        DisplayScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        DisplayScrollPane.setPreferredSize(new Dimension(1571, 737));

        DefaultTableModel tableModel = new DefaultTableModel(
        		new Object [][] {
        							null, null, null, null,
        							null,null, null, null,
        							null},0)
        { 
				private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        
        DisplayTable.setModel(tableModel);
        
        DefaultTableCellRenderer TopRenderer = new DefaultTableCellRenderer();
        TopRenderer.setVerticalAlignment(SwingConstants.TOP);
        
        DisplayTable.setIntercellSpacing(new Dimension(0, 0));
        DisplayTable.setRowHeight(60);
        DisplayTable.setTableHeader(null);
        DisplayTable.setFont(new Font("Sylfaen", Font.PLAIN, 20));
        DisplayScrollPane.setViewportView(DisplayTable);
        
        try{
    		XPath path = XPathFactory.newInstance().newXPath();
    		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("C:\\Users\\princ\\Documents\\customer.xml");
    		doc.getDocumentElement().normalize();
    		
    		String linvoice = path.evaluate("//CustomerInfo/Customer[last()]/Invoice", doc);
    		
    		int lastinvoice = Integer.parseInt(linvoice);
    		int counter = (lastinvoice - 17000);
    		
    		while(counter != 0){
    			CInvoice = path.evaluate(("//CustomerInfo/Customer["+counter+"]/Invoice"), doc);
    			CName = path.evaluate("//CustomerInfo/Customer["+counter+"]/Name", doc);
        		CPhone = path.evaluate("//CustomerInfo/Customer["+counter+"]/Phone", doc);
        		
        		////search item for the invoice number clicked
        			XPath ipath = XPathFactory.newInstance().newXPath();
        			Document docitem = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("C:\\Users\\princ\\Documents\\items.xml");
        			docitem.getDocumentElement().normalize();
        		
        			XPathExpression itemexpr = ipath.compile("//ItemInfo/Items/Invoice[text()=" + CInvoice + "]");
        			
        			NodeList itemList = (NodeList)(itemexpr.evaluate(docitem, XPathConstants.NODESET));//turn found item to nidelist
        			
        			if( itemList.getLength() > 0 ) {
    	    				Node item = itemList.item(0).getParentNode();
    	    			
    	    				Element iElement = (Element) item;
    	    			
    	    				CItem = iElement.getElementsByTagName("Item").item(0).getTextContent();
    	    				CModel = iElement.getElementsByTagName("Model").item(0).getTextContent();
    	    				CProblem = iElement.getElementsByTagName("Problem").item(0).getTextContent();
    	    				CDescription = iElement.getElementsByTagName("Description").item(0).getTextContent();
    	    				CPrice = iElement.getElementsByTagName("Price").item(0).getTextContent();
    	    			}
    		
        		DefaultTableModel model = (DefaultTableModel) DisplayTable.getModel();
        		model.addRow(new Object[]{
        				CInvoice,//invoice
        				"07/23/2017",//date
        				"<HTML>"+CName+" "+CPhone+"</HTML",//customer info
        				"<HTML>"+CItem +" "+CModel+"<br>"+CProblem+"</HTML",//item description
        				CPrice});
        		
        		counter--;
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
        if (DisplayTable.getColumnModel().getColumnCount() > 0) {
            DisplayTable.getColumnModel().getColumn(0).setResizable(false);
            DisplayTable.getColumnModel().getColumn(0).setPreferredWidth(80);
            DisplayTable.getColumnModel().getColumn(1).setResizable(false);
            DisplayTable.getColumnModel().getColumn(1).setPreferredWidth(120);
            DisplayTable.getColumnModel().getColumn(2).setResizable(false);
            DisplayTable.getColumnModel().getColumn(2).setPreferredWidth(260);
            DisplayTable.getColumnModel().getColumn(2).setCellRenderer(TopRenderer);
            DisplayTable.getColumnModel().getColumn(3).setResizable(false);
            DisplayTable.getColumnModel().getColumn(3).setPreferredWidth(260);
            DisplayTable.getColumnModel().getColumn(3).setCellRenderer(TopRenderer);
            DisplayTable.getColumnModel().getColumn(4).setResizable(false);
            DisplayTable.getColumnModel().getColumn(4).setPreferredWidth(100);
            DisplayTable.getColumnModel().getColumn(5).setResizable(false);
            DisplayTable.getColumnModel().getColumn(5).setPreferredWidth(100);
            DisplayTable.getColumnModel().getColumn(6).setResizable(false);
            DisplayTable.getColumnModel().getColumn(6).setPreferredWidth(100);
            DisplayTable.getColumnModel().getColumn(7).setResizable(false);
            DisplayTable.getColumnModel().getColumn(7).setPreferredWidth(250);
            DisplayTable.getColumnModel().getColumn(7).setCellRenderer(TopRenderer);
            DisplayTable.getColumnModel().getColumn(8).setResizable(false);
            DisplayTable.getColumnModel().getColumn(8).setPreferredWidth(250);
            DisplayTable.getColumnModel().getColumn(8).setCellRenderer(TopRenderer);
            
            //DisplayTable.getColumnModel().getColumn(0).setCellRenderer(new ButtonRenderer());
            
            DisplayTable.addMouseListener(new MouseAdapter() {
            	  public void mouseClicked(MouseEvent e) {
            	    if (e.getClickCount() == 2) {
            	      JTable target = (JTable)e.getSource();
            	      int row = target.getSelectedRow();
            	      //int column = target.getSelectedColumn();
            	      String value = DisplayTable.getValueAt(row, 0).toString();
            	      if(value == null){
            	    	  System.out.println("Empty");
            	      }else{
            	    	  System.out.println(value);
            	      }
            	      
            	    }
            	  }
            	});
            
        }

        GroupLayout DisplayAllPanelLayout = new GroupLayout(DisplayAllPanel);
        DisplayAllPanel.setLayout(DisplayAllPanelLayout);
        DisplayAllPanelLayout.setHorizontalGroup(
            DisplayAllPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(DisplayAllPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DisplayAllPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(DisplayScrollPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(DisplayAllPanelLayout.createSequentialGroup()
                        .addGroup(DisplayAllPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(BackstoMainBtn4)
                            .addGroup(DisplayAllPanelLayout.createSequentialGroup()
                                .addComponent(TitleInvoice, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TitleDate, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TitleCustomerInfo, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TitleItemDescription, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(TitlePrice, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TitlePayment, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TitleBalance, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(TitleMemo, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TitleNote, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addContainerGap())
        );
        DisplayAllPanelLayout.setVerticalGroup(
            DisplayAllPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(DisplayAllPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BackstoMainBtn4)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DisplayAllPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(TitleInvoice)
                    .addComponent(TitleDate)
                    .addComponent(TitleCustomerInfo)
                    .addComponent(TitleItemDescription)
                    .addComponent(TitlePrice)
                    .addComponent(TitlePayment)
                    .addComponent(TitleBalance)
                    .addComponent(TitleMemo)
                    .addComponent(TitleNote))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DisplayScrollPane, GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(DisplayAllPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(DisplayAllPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        frame.setVisible(true);
        frame.pack();
    }// </editor-fold>                        

    private void BackstoMainBtn4ActionPerformed(ActionEvent evt) {                                                
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(testdisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(testdisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(testdisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(testdisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new testdisplay();
            }
        });
    }                  
}
