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

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
/**
 *
 * @author princ
 */
public class NewPrint{     
	private JFrame frame;
    private JLabel AppreciateLabel;
    private JButton BacktoDisplayAll;
    private JLabel BalanceCalculation;
    private JLabel BalanceLabel;
    private Box.Filler BalanceLine;
    private JLabel CheckedLabel;
    private JLabel CustomerInfoLabel;
    private JLabel DateLabel;
    private JButton EditBtn;
    private JLabel GuaranteeLabel;
    private Box.Filler GuaranteeLine;
    private JLabel InvoiceLabel;
    private JScrollPane InvoiceScrollPane;
    private JTable InvoiceTable;
    private JLabel PaymentCalculation;
    private JLabel PaymentLabel;
    private Box.Filler PaymentLine;
    private JButton PrintBtn;
    private JLabel PrintDate;
    private JLabel PrintInvoice;
    private JPanel PrintPanel;
    private JScrollPane PrintScrollPane;
    private JPanel PrintTopPanel;
    private JButton ReceivePaymentsBtn;
    private JLabel SetOwnerLabel;
    private Box.Filler SetOwnerLine;
    private JLabel SuwalInfoLabel;
    private JLabel SuwalLogoLabel;
    private JLabel TaxCalculation;
    private JLabel TaxLabel;
    private Box.Filler TaxLine;
    private JLabel TotalCalculation;
    private JLabel TotalLabel;
    private Box.Filler TotalLine;
    private Box.Filler line;
    public String Pinvoice, Pname, Paddress, Pphone;
    public String Pdate, Pqty, Pitem, Pmodel, Pproblem, Pdescription, Pprice, Pmemo; 
    public double JustTotal, Tax, TaxTotal;
    
    public NewPrint(String passedInvoice) {

    	frame = new JFrame();
        PrintTopPanel = new JPanel();
        BacktoDisplayAll = new JButton();
        PrintBtn = new JButton();
        EditBtn = new JButton();
        ReceivePaymentsBtn = new JButton();
        PrintScrollPane = new JScrollPane();
        PrintPanel = new JPanel();
        SuwalLogoLabel = new JLabel();
        SuwalInfoLabel = new JLabel();
        SetOwnerLabel = new JLabel();
        CustomerInfoLabel = new JLabel();
        line = new Box.Filler(new Dimension(850, 2), new Dimension(850, 2), new Dimension(850, 2));
        DateLabel = new JLabel();
        PrintDate = new JLabel();
        PrintInvoice = new JLabel();
        SetOwnerLine = new Box.Filler(new Dimension(250, 2), new Dimension(250, 2), new Dimension(250, 2));
        InvoiceLabel = new JLabel();
        InvoiceScrollPane = new JScrollPane();
        InvoiceTable = new JTable();
        TaxCalculation = new JLabel();
        TaxLabel = new JLabel();
        TaxLine = new Box.Filler(new Dimension(150, 2), new Dimension(150, 2), new Dimension(150, 2));
        TotalCalculation = new JLabel();
        TotalLine = new Box.Filler(new Dimension(150, 1), new Dimension(150, 1), new Dimension(150, 1));
        PaymentCalculation = new JLabel();
        PaymentLine = new Box.Filler(new Dimension(150, 1), new Dimension(150, 1), new Dimension(150, 1));
        BalanceCalculation = new JLabel();
        BalanceLine = new Box.Filler(new Dimension(150, 1), new Dimension(150, 1), new Dimension(150, 1));
        TotalLabel = new JLabel();
        PaymentLabel = new JLabel();
        BalanceLabel = new JLabel();
        GuaranteeLine = new Box.Filler(new Dimension(850, 1), new Dimension(850, 1), new Dimension(850, 1));
        GuaranteeLabel = new JLabel();
        AppreciateLabel = new JLabel();
        CheckedLabel = new JLabel();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);

        BacktoDisplayAll.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        BacktoDisplayAll.setText("< Back");
        BacktoDisplayAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BacktoDisplayAllActionPerformed(evt);
            }
        });

        PrintBtn.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        PrintBtn.setText("Print");
        PrintBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                PrintBtnActionPerformed(evt);
            }
        });

        EditBtn.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        EditBtn.setText("Edit");

        ReceivePaymentsBtn.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        ReceivePaymentsBtn.setText("Receive Payments");

        GroupLayout PrintTopPanelLayout = new GroupLayout(PrintTopPanel);
        PrintTopPanel.setLayout(PrintTopPanelLayout);
        PrintTopPanelLayout.setHorizontalGroup(
            PrintTopPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(PrintTopPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BacktoDisplayAll)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 404, Short.MAX_VALUE)
                .addComponent(ReceivePaymentsBtn)
                .addGap(18, 18, 18)
                .addComponent(EditBtn)
                .addGap(18, 18, 18)
                .addComponent(PrintBtn)
                .addContainerGap())
        );
        PrintTopPanelLayout.setVerticalGroup(
            PrintTopPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, PrintTopPanelLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(PrintTopPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(PrintTopPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(PrintBtn)
                        .addComponent(EditBtn)
                        .addComponent(ReceivePaymentsBtn))
                    .addComponent(BacktoDisplayAll)))
        );

        PrintScrollPane.setBackground(new Color(255, 255, 255));
        PrintScrollPane.getVerticalScrollBar().setUnitIncrement(16);
        PrintScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        PrintPanel.setBackground(new Color(255, 255, 255));
        PrintPanel.setAlignmentX(0.0F);
        PrintPanel.setAlignmentY(0.0F);

        ImageIcon imgLink = new ImageIcon("C:\\Users\\princ\\Documents\\suwallogo.gif");
        SuwalLogoLabel.setBackground(new Color(255, 255, 255));
        SuwalLogoLabel.setIcon(imgLink);

        SuwalInfoLabel.setBackground(new Color(255, 255, 255));
        SuwalInfoLabel.setFont(new Font("Mongolian Baiti", 1, 18)); // NOI18N
        SuwalInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        SuwalInfoLabel.setText("<html><center>47-12 Junction Blvd. Corona Ny, 11368 <br>Tel- 718-606-6700  Tel- 718-505-2013<br>www.suwal.net<br>Lic No.- 1401112/2001080</center></html>");
        SuwalInfoLabel.setHorizontalTextPosition(SwingConstants.CENTER);

        SetOwnerLabel.setFont(new Font("Calibri", 1, 18)); // NOI18N
        SetOwnerLabel.setText("SET OWNER");

        line.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        DateLabel.setFont(new Font("Calibri", 1, 18)); // NOI18N
        DateLabel.setText("DATE:");

        SetOwnerLine.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        InvoiceLabel.setFont(new Font("Calibri", 1, 18)); // NOI18N
        InvoiceLabel.setText("INVOICE NO.");

        InvoiceScrollPane.setBackground(new Color(255, 255, 255));
        InvoiceScrollPane.setBorder(null);
        InvoiceScrollPane.setFont(new Font("Calibri", 0, 18)); // NOI18N

        InvoiceTable.setFont(new Font("Calibri", 0, 20)); // NOI18N
        DefaultTableModel tableModel = new DefaultTableModel(
        		new Object [][] {
        							null, null, null},0)
        { 
				private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        InvoiceTable.setModel(tableModel);
        InvoiceTable.setTableHeader(null);
        InvoiceTable.setFont(new Font("Calibri", 0, 18)); // NOI18N
        InvoiceTable.setBackground(Color.white);
        InvoiceTable.setOpaque(true);
        InvoiceTable.setBorder(null);
        InvoiceTable.setAutoscrolls(false);
        InvoiceTable.setRowHeight(80);
        InvoiceTable.setRowSelectionAllowed(false);
        InvoiceTable.setShowHorizontalLines(false);
        InvoiceTable.setShowVerticalLines(false);

        InvoiceScrollPane.setViewportView(InvoiceTable);
        InvoiceScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        InvoiceScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        InvoiceScrollPane.setBackground(Color.white);
        InvoiceScrollPane.setBorder(BorderFactory.createEmptyBorder());
        InvoiceScrollPane.setOpaque(true);
        InvoiceScrollPane.getViewport().setBackground(Color.white);
        
        
        DefaultTableCellRenderer rightAlign = new DefaultTableCellRenderer();
        rightAlign.setHorizontalAlignment(SwingConstants.RIGHT);
        
        DefaultTableCellRenderer centerAlign = new DefaultTableCellRenderer();
        centerAlign.setHorizontalAlignment(SwingConstants.CENTER);
        if (InvoiceTable.getColumnModel().getColumnCount() > 0) {
            InvoiceTable.getColumnModel().getColumn(0).setResizable(false);
            InvoiceTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            InvoiceTable.getColumnModel().getColumn(0).setCellRenderer(centerAlign);
            InvoiceTable.getColumnModel().getColumn(1).setResizable(false);
            InvoiceTable.getColumnModel().getColumn(1).setPreferredWidth(600);
            InvoiceTable.getColumnModel().getColumn(2).setResizable(false);
            InvoiceTable.getColumnModel().getColumn(2).setPreferredWidth(150);
            InvoiceTable.getColumnModel().getColumn(2).setCellRenderer(rightAlign);
        }
        
        try{
        	XPath path = XPathFactory.newInstance().newXPath();
    		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("C:\\Users\\princ\\Documents\\customer.xml");
    		doc.getDocumentElement().normalize();
    		
    		XPath ipath = XPathFactory.newInstance().newXPath();
    		Document docitem = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("C:\\Users\\princ\\Documents\\items.xml");
    		docitem.getDocumentElement().normalize();
    		
    		XPathExpression customerexpr = path.compile("//CustomerInfo/Customer/Invoice[text()=" + passedInvoice + "]");
    		XPathExpression itemexpr = ipath.compile("//ItemInfo/Items/Invoice[text()=" + passedInvoice + "]");
    		
    		NodeList customerList = (NodeList)(customerexpr.evaluate(doc, XPathConstants.NODESET));
    		NodeList itemList = (NodeList)(itemexpr.evaluate(docitem, XPathConstants.NODESET));
    		
    		JustTotal = 0.00;
    		Tax = 0.00;
    		if (customerList.getLength() > 0) {
    		    Node customer = customerList.item(0).getParentNode();
    		    
    		    Element nElement = (Element) customer;
    		    
    		    Pinvoice = nElement.getElementsByTagName("Invoice").item(0).getTextContent();
    		    Pname = nElement.getElementsByTagName("Name").item(0).getTextContent();
    		    Paddress = nElement.getElementsByTagName("Address").item(0).getTextContent();
    		    Pphone = nElement.getElementsByTagName("Phone").item(0).getTextContent();
    		    
    		    CustomerInfoLabel.setFont(new Font("Calibri", 0, 18)); // NOI18N
    		    CustomerInfoLabel.setText("<html>"+Pname+"<br>"+Paddress+"<br>"+Pphone+"</html>");
    		    
    		    PrintInvoice.setFont(new Font("Calibri", 1, 18)); // NOI18N
    	        PrintInvoice.setHorizontalAlignment(SwingConstants.CENTER);
    	        PrintInvoice.setText(Pinvoice);
    		}
    		
    		if (itemList.getLength() > 0){
    			Node item = itemList.item(0).getParentNode();							//first item's date wi;; be displayed
    			Element iElement = (Element) item;										//this is for just one date even if
    			Pdate = iElement.getElementsByTagName("Date").item(0).getTextContent();//multiple items for one invoice
    			for(int i = 0; i < itemList.getLength() && i < 3;i++){

    				item = itemList.item(i).getParentNode();
    			
    				iElement = (Element) item;
    				
    				Pqty = iElement.getElementsByTagName("Qty").item(0).getTextContent();
    				Pitem = iElement.getElementsByTagName("Item").item(0).getTextContent();
    				Pmodel = iElement.getElementsByTagName("Model").item(0).getTextContent();
    				Pproblem = iElement.getElementsByTagName("Problem").item(0).getTextContent();
    				Pdescription = iElement.getElementsByTagName("Description").item(0).getTextContent();
    				Pprice = iElement.getElementsByTagName("Price").item(0).getTextContent();
    				
    				System.out.println(i);
    				
    				PrintDate.setFont(new Font("Calibri", 1, 18)); // NOI18N
    		        PrintDate.setHorizontalAlignment(SwingConstants.RIGHT);
    		        PrintDate.setText(Pdate);
    		        
    		        JustTotal = JustTotal + Double.parseDouble(Pprice.replaceAll("\\$",""));//double No tax added
    		        Tax = Double.parseDouble(String.format("%.2f",JustTotal * (8.875/100)));
    		        TaxCalculation.setFont(new Font("Calibri", 0, 18)); // NOI18N
    		        TaxCalculation.setHorizontalAlignment(SwingConstants.RIGHT);
    		        TaxCalculation.setText("$"+ Tax +"    ");//4 spaces to align with top price
    		        
    		        TotalCalculation.setFont(new Font("Calibri", 0, 18)); // NOI18N
    		        TotalCalculation.setHorizontalAlignment(SwingConstants.RIGHT);
    		        TotalCalculation.setText("$"+ (JustTotal + Tax)+"    ");//4space to allign with top price
    				
    				DefaultTableModel model = (DefaultTableModel) InvoiceTable.getModel();
            		model.addRow(new Object[]{
            					Pqty,
            					"<html>"+Pitem+" "+Pmodel+" <br>"+Pproblem+" "+" <br>"+Pdescription+"</html>",
            					Pprice
            					});
            		
    			}
    			
    			
    		}//if statement ends here
    	}catch(Exception e){
    		e.printStackTrace();
    	}

        TaxLabel.setBackground(new Color(255, 255, 255));
        TaxLabel.setFont(new Font("Calibri", 0, 18)); // NOI18N
        TaxLabel.setText("TAX:");

        TaxLine.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        TotalLine.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        PaymentCalculation.setFont(new Font("Calibri", 0, 18)); // NOI18N
        PaymentCalculation.setHorizontalAlignment(SwingConstants.CENTER);
        PaymentCalculation.setText("$100.00");

        PaymentLine.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        BalanceCalculation.setFont(new Font("Calibri", 0, 18)); // NOI18N
        BalanceCalculation.setHorizontalAlignment(SwingConstants.CENTER);
        BalanceCalculation.setText("$100.00");

        BalanceLine.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        TotalLabel.setBackground(new Color(255, 255, 255));
        TotalLabel.setFont(new Font("Calibri", 0, 18)); // NOI18N
        TotalLabel.setText("TOTAL:");

        PaymentLabel.setBackground(new Color(255, 255, 255));
        PaymentLabel.setFont(new Font("Calibri", 0, 18)); // NOI18N
        PaymentLabel.setText("PAYMENT:");

        BalanceLabel.setBackground(new Color(255, 255, 255));
        BalanceLabel.setFont(new Font("Calibri", 0, 18)); // NOI18N
        BalanceLabel.setText("BALANCE:");

        GuaranteeLine.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        GuaranteeLabel.setFont(new Font("Calibri", 0, 14)); // NOI18N
        GuaranteeLabel.setText("<HTML><b>GUARANTEE:</b> 1. All works performed by qualified technicians. 2. All materials used in repair of your unit are of first quality and guaranteed for a period of 30 days after the date of repair. 3. The guarantee only applies for the same problem that the unit was repaired for.<br><b>CUSTOMER CLAIM:</b> 1. This invoice must be presented to redeem your unit. 2. We are not responsible for units undeliverable after 30 days. 3. Your unit may be sold to cover the repair costs.<br><b>RETURN POLICY:</b> EXCHANGE ONLY: Items may be <b> EXCHANGED</b> for other merchandise within 7 days of purchase. <b>NO CASH REFUND, THANK YOU</b></HTML> ");
        GuaranteeLabel.setVerticalAlignment(SwingConstants.TOP);

        AppreciateLabel.setFont(new Font("Modern No. 20", 1, 20)); // NOI18N
        AppreciateLabel.setText("We Appreciate Your Business!");

        CheckedLabel.setFont(new Font("Modern No. 20", 1, 20)); // NOI18N
        CheckedLabel.setText("Set Checked and Picked By..............................");

        GroupLayout PrintPanelLayout = new GroupLayout(PrintPanel);
        PrintPanel.setLayout(PrintPanelLayout);
        PrintPanelLayout.setHorizontalGroup(
            PrintPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(PrintPanelLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(PrintPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, PrintPanelLayout.createSequentialGroup()
                        .addGroup(PrintPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(GroupLayout.Alignment.LEADING, PrintPanelLayout.createSequentialGroup()
                                .addComponent(DateLabel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(PrintDate)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(InvoiceLabel)
                                .addGap(49, 49, 49)
                                .addComponent(PrintInvoice)
                                .addGap(32, 32, 32))
                            .addGroup(GroupLayout.Alignment.LEADING, PrintPanelLayout.createSequentialGroup()
                                .addGroup(PrintPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(SetOwnerLine, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SetOwnerLabel)
                                    .addComponent(CustomerInfoLabel, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(PrintPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(PrintPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(SuwalInfoLabel, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SuwalLogoLabel, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE))))
                        .addGap(64, 64, 64))
                    .addGroup(GroupLayout.Alignment.TRAILING, PrintPanelLayout.createSequentialGroup()
                        .addGroup(PrintPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(InvoiceScrollPane)
                            .addComponent(line, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(65, 65, 65))))
            .addGroup(GroupLayout.Alignment.TRAILING, PrintPanelLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PrintPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(PrintPanelLayout.createSequentialGroup()
                        .addComponent(PaymentLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PaymentCalculation, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                    .addGroup(PrintPanelLayout.createSequentialGroup()
                        .addComponent(TotalLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TotalCalculation, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                    .addComponent(TaxLine, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(PrintPanelLayout.createSequentialGroup()
                        .addComponent(TaxLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TaxCalculation, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                    .addComponent(TotalLine, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(PaymentLine, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(PrintPanelLayout.createSequentialGroup()
                        .addComponent(BalanceLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BalanceCalculation, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                    .addComponent(BalanceLine, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
            .addGroup(GroupLayout.Alignment.TRAILING, PrintPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(PrintPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(GuaranteeLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(GuaranteeLine, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(GroupLayout.Alignment.LEADING, PrintPanelLayout.createSequentialGroup()
                        .addComponent(CheckedLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AppreciateLabel)))
                .addGap(34, 34, 34))
        );
        PrintPanelLayout.setVerticalGroup(
            PrintPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(PrintPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(SuwalLogoLabel, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(SuwalInfoLabel, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(SetOwnerLabel)
                .addGap(0, 0, 0)
                .addComponent(SetOwnerLine, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CustomerInfoLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PrintPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(DateLabel)
                    .addComponent(PrintDate)
                    .addComponent(PrintInvoice)
                    .addComponent(InvoiceLabel))
                .addGap(0, 0, 0)
                .addComponent(line, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(InvoiceScrollPane, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                .addGroup(PrintPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(TaxCalculation)
                    .addComponent(TaxLabel))
                .addGap(0, 0, 0)
                .addComponent(TaxLine, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(PrintPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(TotalCalculation)
                    .addComponent(TotalLabel))
                .addGap(0, 0, 0)
                .addComponent(TotalLine, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(PrintPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(PaymentCalculation)
                    .addComponent(PaymentLabel))
                .addGap(1, 1, 1)
                .addComponent(PaymentLine, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(PrintPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(BalanceCalculation)
                    .addComponent(BalanceLabel))
                .addGap(0, 0, 0)
                .addComponent(BalanceLine, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(GuaranteeLine, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(GuaranteeLabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                .addGap(70,70,70)
                .addGroup(PrintPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckedLabel)
                    .addComponent(AppreciateLabel))
                .addGap(47,47,47))
        );

        PrintScrollPane.setViewportView(PrintPanel);

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PrintTopPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(PrintScrollPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PrintTopPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PrintScrollPane, GroupLayout.PREFERRED_SIZE, 781, GroupLayout.PREFERRED_SIZE))
        );
        frame.setVisible(true);
        frame.pack();
    }// </editor-fold>                        
    public void printComponent(){

  	  PrinterJob pj = PrinterJob.getPrinterJob();
  	  pj.setJobName(" Print Invoice ");

  	  pj.setPrintable (new Printable() {    
  	    public int print(Graphics g, PageFormat pf, int page){
  	    	if(page > 0) return NO_SUCH_PAGE;
  	    	
  			Dimension componentsize = PrintPanel.getPreferredSize();
  			PrintPanel.setSize(componentsize);
  			
  			Dimension printsize =new Dimension();
  			printsize.setSize(pf.getImageableWidth(), pf.getImageableHeight());
  			
  			double scalefactor = getScaleFactorToFit(componentsize, printsize);
  			
  			if(scalefactor > 1d){
  				scalefactor = 1d;
  			}
  			
  			double scalewidth = componentsize.width * scalefactor;
  			double scaleheight = componentsize.height * scalefactor;
  			
  			Graphics2D g2 = (Graphics2D) g;
  			
  			double x = ((pf.getImageableWidth() - scalewidth)/ 2d) + pf.getImageableX();
  			double y = ((pf.getImageableHeight() - scaleheight)/ 2d) + pf.getImageableY() - 100;
  			
  			AffineTransform at = new AffineTransform();
  			
  			at.translate(x,y);
  			at.scale(scalefactor, scalefactor);
  			g2.transform(at);
  			PrintPanel.printAll(g2);
  			return PAGE_EXISTS;
  	    }//print ends here
  	  });
  	  if (pj.printDialog() == false)
  	  return;

  	  try {
  	        pj.print();
  	  } catch (PrinterException ex) {
  	        ex.printStackTrace();
  	  }
  	}
  
  public double getScaleFactorToFit(Dimension original, Dimension toFit){
		double dscale = 1d;
		
		if(original != null && toFit != null){
			double scaleWidth = getScaleFactor(original.width, toFit.width);
			double scaleHeight = getScaleFactor(original.height, toFit.height);
			
			dscale = Math.min(scaleHeight,  scaleWidth);
		}
		return dscale;
	}
	public double getScaleFactor(int iMasterSize, int iTargetSize){
		double dscale = 1;
		if(iMasterSize > iTargetSize){
			dscale = (double) iTargetSize / (double) iMasterSize;
		}else{
			dscale = (double) iMasterSize / (double) iTargetSize;
		}
		return dscale;
	}
  
  
  private void PrintBtnActionPerformed(ActionEvent evt) {                                         
  	printComponent();
  } 
  
  private void BacktoDisplayAllActionPerformed(ActionEvent evt) {                                         
      PrintPanel.setVisible(false);
      PrintScrollPane.setVisible(false);
      PrintTopPanel.setVisible(false);
      InvoiceScrollPane.setVisible(false);
      ///sDisplayAll();
  }
  
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
            java.util.logging.Logger.getLogger(NewPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewPrint("17091");
            }
        });
    }                  
}
