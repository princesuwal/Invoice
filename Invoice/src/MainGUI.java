import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.*;
import javax.swing.text.MaskFormatter;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;

import org.w3c.dom.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.print.*;
import java.text.*;
import java.util.*;
/**
 *
 * @author prince
 */
public class MainGUI{
	public JFrame frame; 
	MaskFormatter PhoneFormat;
	MaskFormatter PriceFormat;
	
	//MainMenu Used////
	private JPanel MainMenuPanel;
	private JLabel MainMenuTitle;
	private JButton NewInvoiceBtn;
	private JButton SearchBtn;
	private JButton DisplayAllBtn; 
	private JButton PaymentsBtn;
	
		//EnterInfo Used//
	 	private JTextField AddressField;
	    private JLabel AddressLabel;
	    private JButton BackstoMainMenu;
	    private JLabel CurrentInvoiceLabel;
	    private JTextField DateField;
	    private JTextArea DescriptionField;
	    private JLabel DescriptionLabel;
	    private JPanel InfoPanel;
	    private JTextField ItemInfoField;
	    private JLabel ItemInfoLabel;
	    private JTextField NameField;
	    private JLabel NameLabel;
	    private JTextField Phone1Field;
	    private JFormattedTextField PhoneField;
	    private JLabel PhoneLabel;
	    private JFormattedTextField PriceField;
	    private JLabel PriceLabel;
	    private JButton SaveBtn;
	    public String CInvoice, CName, CAddress, CPhone, CPhone2;
	    public String IDate, IItemDesc, IDescription, IPrice;
    
    //Search Used//
    private JButton BackMainBtn;
    private JLabel SearchTitle;
    private JPanel SearchPanel;
    private JButton PhoneSearchBtn;
    private JLabel SearchLabel;
    private JTextField SearchField;  
    
    //DisplayAll Used//
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
    public String DInvoice, DName, DAddress, DPhone, DPhone2, DMemo, DNote;
    public String DDate, DItemDesc, DDescription, DPrice;
    
    //PrintDisplay Used//
    private JFrame printframe;
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
    public JButton PrintBtn;
    private JLabel PrintDate;
    private JLabel PrintInvoice;
    public JPanel PrintPanel;
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
    public String Pinvoice, Pname, Paddress, Pphone, Pphone2, Pmemo, Pnote;
    public String Pdate, Pitemdesc, Pdescription, Pprice;
    public double JustTotal, Tax, TaxTotal, Payments, Balance;
    
    //ReceivePayments Used//
    private JFrame pframe;
    private JLabel ReceiveCustomerInfo;
    private JLabel ReceiveInvoiceLabel;
    private JTextField ReceiveMemoField;
    private JLabel ReceiveMemoLabel;
    private JButton ReceivePaymentBtn;
    private JTextField ReceivePaymentDate;
    private JPanel ReceivePaymentPanel;
    private JTextField ReceivePriceField;
    private JLabel ReceivePriceLabel;
    
    //Used to interact with XML/
    //public String CName, CAddress, CPhone, CInvoice;
    public String CDate, CQty, CItem, CModel, CProblem, CDescription, CPrice;
    
    
    public MainGUI() {
    	frame = new JFrame();
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setResizable(false);
    	MainMenu();
    } //Constructor of MainGUI ends here
    
/////////////////////////////////////////////////MainMenuPanel//////////////////////////////////////////////////////
/////////////////////////////////////////////////MainMenuPanel//////////////////////////////////////////////////////
/////////////////////////////////////////////////MainMenuPanel//////////////////////////////////////////////////////
    public void MainMenu(){
        MainMenuPanel = new JPanel();
        MainMenuTitle = new JLabel();
        NewInvoiceBtn = new JButton();
        DisplayAllBtn = new JButton();
        SearchBtn = new JButton();
        PaymentsBtn = new JButton();
        
        frame.setTitle("Main Menu");

        MainMenuTitle.setFont(new Font("Sylfaen", 0, 45)); // NOI18N
        MainMenuTitle.setText("Main Menu");

        NewInvoiceBtn.setFont(new Font("Sylfaen", 0, 45)); // NOI18N
        NewInvoiceBtn.setText("Create New Invoice");
        NewInvoiceBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                NewInvoiceBtnActionPerformed(evt);
            }
        });

        DisplayAllBtn.setFont(new Font("Sylfaen", 0, 45)); // NOI18N
        DisplayAllBtn.setText("Display All Invoice");
        DisplayAllBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                DisplayAllBtnActionPerformed(evt);
            }
        });
        
        SearchBtn.setFont(new Font("Sylfaen", 0, 45)); // NOI18N
        SearchBtn.setText("Search");
        SearchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SearchBtnActionPerformed(evt);
            }
        });

        PaymentsBtn.setFont(new Font("Sylfaen", 0, 45)); // NOI18N
        PaymentsBtn.setText("Received Payments");
        PaymentsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                PaymentsBtnActionPerformed(evt);
            }
        });

        GroupLayout MainMenuPanelLayout = new GroupLayout(MainMenuPanel);
        MainMenuPanel.setLayout(MainMenuPanelLayout);
        MainMenuPanelLayout.setHorizontalGroup(
            MainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(MainMenuPanelLayout.createSequentialGroup()
                .addGroup(MainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(MainMenuPanelLayout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(MainMenuTitle))
                    .addGroup(MainMenuPanelLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(NewInvoiceBtn, GroupLayout.PREFERRED_SIZE, 614, GroupLayout.PREFERRED_SIZE))
                    .addGroup(MainMenuPanelLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(DisplayAllBtn, GroupLayout.PREFERRED_SIZE, 614, GroupLayout.PREFERRED_SIZE))
                    .addGroup(MainMenuPanelLayout.createSequentialGroup()
                            .addGap(104, 104, 104)
                            .addComponent(SearchBtn, GroupLayout.PREFERRED_SIZE, 614, GroupLayout.PREFERRED_SIZE))
                    .addGroup(MainMenuPanelLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(PaymentsBtn, GroupLayout.PREFERRED_SIZE, 614, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        MainMenuPanelLayout.setVerticalGroup(
            MainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(MainMenuPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(MainMenuTitle)
                .addGap(45, 45, 45)
                .addComponent(NewInvoiceBtn, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(DisplayAllBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(SearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(PaymentsBtn, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(MainMenuPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(MainMenuPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        MainMenuPanel.setVisible(true);
        frame.setVisible(true);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }      //MainMenu Ends here
    
////////////////////////////////ActionListener for MainMenu Buttons //////////////////////////////////////////
////////////////////////////////ActionListener for MainMenu Buttons //////////////////////////////////////////
////////////////////////////////ActionListener for MainMenu Buttons //////////////////////////////////////////
    private void NewInvoiceBtnActionPerformed(ActionEvent evt) { 
    	MainMenuPanel.setVisible(false);
    	EnterInfo();
    }                                             

    private void DisplayAllBtnActionPerformed(ActionEvent evt) {                                              
    	MainMenuPanel.setVisible(false);
    	DisplayAll();
    } 
    
    private void SearchBtnActionPerformed(ActionEvent evt) {                                              
    	MainMenuPanel.setVisible(false);
    	Search();
    } 

    private void PaymentsBtnActionPerformed(ActionEvent evt) {                                            
    }                                           
////////////////////////////ActionListener for MainMenu Buttons ends here///////////////////////////////////
////////////////////////////ActionListener for MainMenu Buttons ends here///////////////////////////////////
////////////////////////////ActionListener for MainMenu Buttons ends here///////////////////////////////////
    
    
    
/////////////////////////////////////////////////MainMenuPanel Ends//////////////////////////////////////////////////////
/////////////////////////////////////////////////MainMenuPanel Ends//////////////////////////////////////////////////////
/////////////////////////////////////////////////MainMenuPanel Ends//////////////////////////////////////////////////////

/////////////////////////////////////////////////EnterInfo//////////////////////////////////////////////////////
/////////////////////////////////////////////////EnterInfo//////////////////////////////////////////////////////
/////////////////////////////////////////////////EnterInfo//////////////////////////////////////////////////////
    public void EnterInfo() {
    	MainXML x = new MainXML();
    	int xinvoice = x.IncrementInvoiceNo();
    	CInvoice = Integer.toString(xinvoice);
    	
        InfoPanel = new JPanel();
        BackstoMainMenu = new JButton();
        CurrentInvoiceLabel = new JLabel();
        NameLabel = new JLabel();
        AddressLabel = new JLabel();
        PhoneLabel = new JLabel();
        DateField = new JTextField();
        ItemInfoLabel = new JLabel();
        DescriptionLabel = new JLabel();
        NameField = new JTextField();
        AddressField = new JTextField();
        PhoneField = new JFormattedTextField();
        Phone1Field = new JTextField();
        DescriptionField = new JTextArea();
        PriceLabel = new JLabel();
        PriceField = new JFormattedTextField();
        SaveBtn = new JButton();
        ItemInfoField = new JTextField();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        BackstoMainMenu.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        BackstoMainMenu.setText("< Main Menu");
        BackstoMainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BackstoMainMenuActionPerformed(evt);
            }
        });

        CurrentInvoiceLabel.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        CurrentInvoiceLabel.setText("Invoice No. :" + String.valueOf(xinvoice));

        NameLabel.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        NameLabel.setText("Name :");

        AddressLabel.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        AddressLabel.setText("Address :");

        PhoneLabel.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        PhoneLabel.setText("Phone No. :");

        DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        
        DateField.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        DateField.setText(dateformat.format(date));

        ItemInfoLabel.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        ItemInfoLabel.setText("Item Info :");

        DescriptionLabel.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        DescriptionLabel.setText("Description :");

        NameField.setFont(new Font("Sylfaen", 0, 20)); // NOI18N

        AddressField.setFont(new Font("Sylfaen", 0, 20)); // NOI18N

        try {
			MaskFormatter PhoneFormat = new MaskFormatter("(###)-###-####");
			PhoneFormat.setPlaceholderCharacter('_');
			PhoneField = new JFormattedTextField(PhoneFormat);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        PhoneField.setFont(new Font("Sylfaen", 0, 20)); // NOI18N

        Phone1Field.setFont(new Font("Sylfaen", 0, 20)); // NOI18N

        DescriptionField.setColumns(20);
        DescriptionField.setFont(new Font("Sylfaen", 0, 20)); // NOI18N
        DescriptionField.setRows(5);

        PriceLabel.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        PriceLabel.setText("Price :");
        
        
        PriceField.setFont(new Font("Sylfaen", 0, 20)); // NOI18N

        SaveBtn.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        SaveBtn.setText("Save");
        SaveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SaveBtnActionPerformed(evt);
            }
        });

        ItemInfoField.setFont(new Font("Sylfaen", 0, 20)); // NOI18N

        GroupLayout InfoPanelLayout = new GroupLayout(InfoPanel);
        InfoPanel.setLayout(InfoPanelLayout);
        InfoPanelLayout.setHorizontalGroup(
            InfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(InfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(InfoPanelLayout.createSequentialGroup()
                        .addComponent(BackstoMainMenu)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(InfoPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CurrentInvoiceLabel))
                    .addGroup(InfoPanelLayout.createSequentialGroup()
                        .addGroup(InfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(InfoPanelLayout.createSequentialGroup()
                                .addGroup(InfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(NameLabel)
                                    .addComponent(AddressLabel)
                                    .addComponent(PhoneLabel)
                                    .addComponent(ItemInfoLabel))
                                .addGap(28, 28, 28)
                                .addGroup(InfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(InfoPanelLayout.createSequentialGroup()
                                        .addComponent(PhoneField, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(Phone1Field, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(NameField)
                                    .addComponent(AddressField)
                                    .addComponent(ItemInfoField)))
                            .addGroup(InfoPanelLayout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(SaveBtn, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
                            .addGroup(InfoPanelLayout.createSequentialGroup()
                                .addGroup(InfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(DescriptionLabel)
                                    .addComponent(PriceLabel))
                                .addGroup(InfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(InfoPanelLayout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(PriceField, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(InfoPanelLayout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(DescriptionField, GroupLayout.PREFERRED_SIZE, 539, GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 131, Short.MAX_VALUE)))
                .addContainerGap())
        );
        InfoPanelLayout.setVerticalGroup(
            InfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(InfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(BackstoMainMenu)
                    .addComponent(DateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(CurrentInvoiceLabel)
                .addGap(0, 0, 0)
                .addGroup(InfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(NameLabel)
                    .addComponent(NameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(AddressLabel)
                    .addComponent(AddressField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(PhoneLabel)
                    .addComponent(PhoneField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(Phone1Field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(ItemInfoLabel)
                    .addComponent(ItemInfoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(DescriptionLabel)
                    .addComponent(DescriptionField, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(InfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(PriceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(PriceLabel))
                .addGap(26, 26, 26)
                .addComponent(SaveBtn)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(InfoPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(InfoPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        
        frame.setTitle("Enter Info");
        frame.pack();
        frame.setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void BackstoMainMenuActionPerformed(ActionEvent evt) {                                                
        InfoPanel.setVisible(false);
       MainMenu();
    }                                               

    private void SaveBtnActionPerformed(ActionEvent evt) {                                        
        CName = NameField.getText();
        CAddress = AddressField.getText();
        CPhone = PhoneField.getText();
        CPhone2 = Phone1Field.getText();
        IDate = DateField.getText();
        IItemDesc = ItemInfoField.getText();
        IDescription = DescriptionField.getText();
        IPrice = PriceField.getText();
        
        if(CName.equals("")){
    		JOptionPane.showMessageDialog(frame, "Please Enter Customer Name");
    	}else if(CPhone.equals("")){
    		JOptionPane.showMessageDialog(frame, "Please Enter Customer Phone No.");
    	}else if(IItemDesc.equals("")){
    		JOptionPane.showMessageDialog(frame, "Please Enter Item Info");
    	}else{
    		MainXML XML = new MainXML();
    		XML.AddCustomerInfo(CInvoice, CName, CAddress, CPhone, CPhone2, "", "");
    		XML.AddItemDescription(CInvoice, IDate, IItemDesc, IDescription, IPrice);
    		InfoPanel.setVisible(false);
    		DisplayAll();
    	}
    }                                    
    
/////////////////////////////////////////////////EnterInfo Ends//////////////////////////////////////////////////////
/////////////////////////////////////////////////EnterInfo Ends//////////////////////////////////////////////////////
/////////////////////////////////////////////////EnterInfo Ends//////////////////////////////////////////////////////
    
/////////////////////////////////////////////////Search//////////////////////////////////////////////////////
/////////////////////////////////////////////////Search//////////////////////////////////////////////////////
/////////////////////////////////////////////////Search//////////////////////////////////////////////////////
    public void Search() {
        SearchPanel = new JPanel();
        BackMainBtn = new JButton();
        SearchTitle = new JLabel();
        SearchLabel = new JLabel();
        PhoneSearchBtn = new JButton();

        BackMainBtn.setFont(new Font("Sylfaen", 0, 25)); // NOI18N
        BackMainBtn.setText("< Main Menu");
        BackMainBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BackMainBtnActionPerformed(evt);
            }
        });

        SearchTitle.setFont(new Font("Sylfaen", 0, 45)); // NOI18N
        SearchTitle.setText("Search by Phone No.");

        SearchLabel.setFont(new Font("Sylfaen", 0, 45)); // NOI18N
        SearchLabel.setText("Search :");
        
        try {
			PhoneFormat = new MaskFormatter("(###)-###-####");
			PhoneFormat.setPlaceholderCharacter('_');
			SearchField = new JFormattedTextField(PhoneFormat);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        SearchField.setFont(new Font("Sylfaen", 0, 40)); // NOI18N
        SearchField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        PhoneSearchBtn.setFont(new Font("Sylfaen", 0, 35)); // NOI18N
        PhoneSearchBtn.setText("Search");
        PhoneSearchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        GroupLayout SearchLayout = new GroupLayout(SearchPanel);
        SearchPanel.setLayout(SearchLayout);
        SearchLayout.setHorizontalGroup(
            SearchLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(SearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SearchLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(SearchLayout.createSequentialGroup()
                        .addComponent(BackMainBtn)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(SearchLayout.createSequentialGroup()
                        .addComponent(SearchLabel)
                        .addGroup(SearchLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(SearchLayout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(SearchTitle)
                                .addContainerGap())
                            .addGroup(GroupLayout.Alignment.TRAILING, SearchLayout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                                .addComponent(SearchField, GroupLayout.PREFERRED_SIZE, 599, GroupLayout.PREFERRED_SIZE))))))
            .addGroup(SearchLayout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addComponent(PhoneSearchBtn, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        SearchLayout.setVerticalGroup(
            SearchLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(SearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BackMainBtn)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchTitle)
                .addGap(62, 62, 62)
                .addGroup(SearchLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchLabel)
                    .addComponent(SearchField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addComponent(PhoneSearchBtn, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(328, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SearchPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SearchPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        
        frame.pack();
        frame.setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void BackMainBtnActionPerformed(ActionEvent evt) {                                              
        SearchPanel.setVisible(false);
        MainMenu();
    }                                             

    private void jTextField1ActionPerformed(ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jButton1ActionPerformed(ActionEvent evt) {                                         
        // TODO add your handling code here:
    } 
/////////////////////////////////////////////////Search Ends//////////////////////////////////////////////////////
/////////////////////////////////////////////////Search Ends//////////////////////////////////////////////////////
/////////////////////////////////////////////////Search Ends//////////////////////////////////////////////////////    
    
    
/////////////////////////////////////////////////DisplayAll//////////////////////////////////////////////////////
/////////////////////////////////////////////////DisplayAll//////////////////////////////////////////////////////
/////////////////////////////////////////////////DisplayAll//////////////////////////////////////////////////////  
    public void DisplayAll() {  

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
        double TotalPaid = 0.00, TotalPrice = 0.00;

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
        
        DefaultTableCellRenderer CenterRenderer = new DefaultTableCellRenderer();
        CenterRenderer.setVerticalAlignment(SwingConstants.CENTER);
        CenterRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        
        DisplayTable.setIntercellSpacing(new Dimension(0, 0));
        DisplayTable.setRowHeight(60);
        DisplayTable.setTableHeader(null);
        DisplayTable.setFont(new Font("Sylfaen", Font.PLAIN, 20));
        DisplayTable.setShowVerticalLines(true);
        DisplayTable.setShowHorizontalLines(true);
        DisplayScrollPane.setViewportView(DisplayTable);
        DisplayScrollPane.getVerticalScrollBar().setUnitIncrement(16);
        
        try{
    		XPath path = XPathFactory.newInstance().newXPath();
    		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("C:\\Users\\princ\\Documents\\customer.xml");
    		doc.getDocumentElement().normalize();
    		
    		String linvoice = path.evaluate("//CustomerInfo/Customer[last()]/Invoice", doc);
    		
    		int lastinvoice = Integer.parseInt(linvoice);
    		int counter = (lastinvoice - 17000);
    		
    		while(counter != 0){
    			DInvoice = path.evaluate(("//CustomerInfo/Customer["+counter+"]/Invoice"), doc);
    			DName = path.evaluate("//CustomerInfo/Customer["+counter+"]/Name", doc);
        		DPhone = path.evaluate("//CustomerInfo/Customer["+counter+"]/Phone", doc);
        		DPhone2 = path.evaluate("//CustomerInfo/Customer["+counter+"]/Phone2", doc);
        		DMemo = path.evaluate("//CustomerInfo/Customer["+counter+"]/Memo", doc);
        		DNote = path.evaluate("//CustomerInfo/Customer["+counter+"]/Note", doc);
        		
        		TotalPrice = 0.00;
        		TotalPaid = 0.00;
        		////search item for the invoice number clicked
        			XPath ipath = XPathFactory.newInstance().newXPath();
        			Document docitem = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("C:\\Users\\princ\\Documents\\items.xml");
        			docitem.getDocumentElement().normalize();
        			
        			XPath Paymentpath = XPathFactory.newInstance().newXPath();
        			Document docPayment = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("C:\\Users\\princ\\Documents\\payments.xml");
        			docPayment.getDocumentElement().normalize();
        		
        			XPathExpression itemexpr = ipath.compile("//ItemInfo/Items/Invoice[text()=" + DInvoice + "]");
        			XPathExpression Paymentexpr = Paymentpath.compile("//AllPayments/Payments/Invoice[text()=" + DInvoice + "]");

        			NodeList itemList = (NodeList)(itemexpr.evaluate(docitem, XPathConstants.NODESET));//turn found item to nidelist
        			NodeList PaymentList = (NodeList)(Paymentexpr.evaluate(docPayment, XPathConstants.NODESET));//turn found item to nidelist
        			
        			
        			if( itemList.getLength() > 0) {
        				
    	    			Node item = itemList.item(0).getParentNode();
    	    				
    	    			Element iElement = (Element) item;
    	    			
    	    			DDate = iElement.getElementsByTagName("Date").item(0).getTextContent();
    	    			DItemDesc = iElement.getElementsByTagName("ItemDesc").item(0).getTextContent();
    	    			DDescription = iElement.getElementsByTagName("Description").item(0).getTextContent();
    	    			for(int i = 0; i < itemList.getLength(); i++){
    	    				item = itemList.item(i).getParentNode();
    	    				
        	    			iElement = (Element) item;
        	    			
    	    				DPrice = iElement.getElementsByTagName("Price").item(0).getTextContent();
    	    				double Price = Double.parseDouble(DPrice);
    	    				TotalPrice = TotalPrice + Price;
    	    			}
        			}
        			else{
        				DDate = "";
	    				DItemDesc = "";
	    				DDescription = "";
	    				TotalPrice = 00.00;
        			}

        			if(PaymentList.getLength() > 0){
        				Node payment = PaymentList.item(0).getParentNode();
    	    			Element pElement = (Element) payment;
        				for(int i = 0; i < PaymentList.getLength(); i++){
        					payment = PaymentList.item(i).getParentNode();
        	    			pElement = (Element) payment;
        	    			
        	    			String paid = pElement.getElementsByTagName("Paid").item(0).getTextContent();
        	    			if(paid.charAt(0) == '-'){
        	    				double Paid = Double.parseDouble(paid.replaceAll("-", ""));
            	    			TotalPaid = TotalPaid - Paid;
        	    			}else
        	    			{
        	    				double Paid = Double.parseDouble(paid);
        	    				TotalPaid = TotalPaid + Paid;
        	    			}
        	    			
        				}
        			}else
        			{
        				TotalPaid = 00.00;
        			}
    	    				DefaultTableModel model = (DefaultTableModel) DisplayTable.getModel();
    	            		model.addRow(new Object[]{
    	            				DInvoice,//invoice
    	            				DDate,//date
    	            				"<HTML>"+DName+" <br>"+DPhone+"<br>"+DPhone2+"</HTML>",//customer info
    	            				"<HTML>"+DItemDesc +"<br>"+DDescription+"</HTML",//item description
    	            				"$ "+String.format("%.2f", TotalPrice),
    	            				"$ "+String.format("%.2f", TotalPaid),
    	            				"$ "+String.format("%.2f", TotalPrice - TotalPaid),
    	            				DMemo,
    	            				DNote});
        			       		
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
            DisplayTable.getColumnModel().getColumn(4).setCellRenderer(CenterRenderer);
            DisplayTable.getColumnModel().getColumn(5).setResizable(false);
            DisplayTable.getColumnModel().getColumn(5).setPreferredWidth(100);
            DisplayTable.getColumnModel().getColumn(5).setCellRenderer(CenterRenderer);
            DisplayTable.getColumnModel().getColumn(6).setResizable(false);
            DisplayTable.getColumnModel().getColumn(6).setPreferredWidth(100);
            DisplayTable.getColumnModel().getColumn(6).setCellRenderer(CenterRenderer);
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
            	    	  DisplayAllPanel.setVisible(false);
            	    	  PrintDisplay(value);
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
                .addComponent(DisplayScrollPane, GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE))
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
        
        frame.setTitle("Display All Invoice");
        //frame.setVisible(true);
        frame.setResizable(true);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }                  

    private void BackstoMainBtn4ActionPerformed(ActionEvent evt) {                                                
        DisplayScrollPane.setVisible(false);
        DisplayAllPanel.setVisible(false);
        MainMenu();
    } 
    
/////////////////////////////////////////////////DisplayAll Ends//////////////////////////////////////////////////////
/////////////////////////////////////////////////DisplayAll Ends//////////////////////////////////////////////////////
/////////////////////////////////////////////////DisplayAll Ends//////////////////////////////////////////////////////
    
    
/////////////////////////////////////////////////PrintDisplay//////////////////////////////////////////////////////
/////////////////////////////////////////////////PrintDisplay//////////////////////////////////////////////////////
/////////////////////////////////////////////////PrintDisplay//////////////////////////////////////////////////////

    public void PrintDisplay(String passedInvoice) {

    	printframe = new JFrame();
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

        printframe.setResizable(false);

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
        ReceivePaymentsBtn.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent ae){
        		ReceivePaymentsBtnActionPerformed(ae);
        	}
        });

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
    		
    		XPath ppath = XPathFactory.newInstance().newXPath();
    		Document docpayment = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("C:\\Users\\princ\\Documents\\payments.xml");
    		docpayment.getDocumentElement().normalize();
    		
    		XPathExpression customerexpr = path.compile("//CustomerInfo/Customer/Invoice[text()=" + passedInvoice + "]");
    		XPathExpression itemexpr = ipath.compile("//ItemInfo/Items/Invoice[text()=" + passedInvoice + "]");
    		XPathExpression paymentexpr = ppath.compile("//AllPayments/Payments/Invoice[text()=" + passedInvoice + "]");

    		NodeList customerList = (NodeList)(customerexpr.evaluate(doc, XPathConstants.NODESET));
    		NodeList itemList = (NodeList)(itemexpr.evaluate(docitem, XPathConstants.NODESET));
    		NodeList paymentList = (NodeList)(paymentexpr.evaluate(docpayment, XPathConstants.NODESET));

    		JustTotal = 0.00;
    		Tax = 0.00;
    		Payments = 0.00;
    		if (customerList.getLength() > 0) {
    		    Node customer = customerList.item(0).getParentNode();
    		    
    		    Element nElement = (Element) customer;
    		    
    		    Pinvoice = nElement.getElementsByTagName("Invoice").item(0).getTextContent();
    		    Pname = nElement.getElementsByTagName("Name").item(0).getTextContent();
    		    Paddress = nElement.getElementsByTagName("Address").item(0).getTextContent();
    		    Pphone = nElement.getElementsByTagName("Phone").item(0).getTextContent();
    		    Pphone2 = nElement.getElementsByTagName("Phone2").item(0).getTextContent();
    		    Pmemo = nElement.getElementsByTagName("Memo").item(0).getTextContent();
    		    
    		    CustomerInfoLabel.setFont(new Font("Calibri", 0, 18)); // NOI18N
    		    CustomerInfoLabel.setText("<html>"+Pname+"<br>"+Paddress+"<br>"+Pphone+"  "+Pphone2+"</html>");
    		    
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
    				
    				Pitemdesc = iElement.getElementsByTagName("ItemDesc").item(0).getTextContent();
    				Pdescription = iElement.getElementsByTagName("Description").item(0).getTextContent();
    				Pprice = iElement.getElementsByTagName("Price").item(0).getTextContent();
    				
    				PrintDate.setFont(new Font("Calibri", 1, 18)); // NOI18N
    		        PrintDate.setHorizontalAlignment(SwingConstants.RIGHT);
    		        PrintDate.setText(Pdate);
    		        
    		        JustTotal = JustTotal + Double.parseDouble(Pprice);//double No tax added
    		        Tax = JustTotal * (8.875/100);
    		        TaxCalculation.setFont(new Font("Calibri", 0, 18)); // NOI18N
    		        TaxCalculation.setHorizontalAlignment(SwingConstants.RIGHT);
    		        TaxCalculation.setText("$ "+ String.format("%.2f",Tax) +"    ");//4 spaces to align with top price
    		        
    		        TotalCalculation.setFont(new Font("Calibri", 0, 18)); // NOI18N
    		        TotalCalculation.setHorizontalAlignment(SwingConstants.RIGHT);
    		        TotalCalculation.setText("$ "+ String.format("%.2f",JustTotal + Tax)+"    ");//4space to allign with top price
    				
    				DefaultTableModel model = (DefaultTableModel) InvoiceTable.getModel();
            		model.addRow(new Object[]{
            					"1",
            					"<html>"+Pitemdesc+" <br>"+Pdescription+"</html>",
            					"$ "+Pprice
            					});
            		
    			}//for loop ends for 3 item	
    		}//if statement ends here
    		
    		if(paymentList.getLength() > 0){
    			for(int i = 0; i < paymentList.getLength(); i++){
    				Node payment = paymentList.item(i).getParentNode();
    				Element pElement = (Element) payment;
    			
    				String paid = pElement.getElementsByTagName("Paid").item(0).getTextContent();
    				if(paid.charAt(0) == '-'){
    					double Paid = Double.parseDouble(paid.replaceAll("-",""));
        				Payments = Payments - Paid;
    				}else 
    				{
    					double Paid = Double.parseDouble(paid);
        				Payments = Payments + Paid;
    				}
    				
    			}
    		}
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}

        TaxLabel.setBackground(new Color(255, 255, 255));
        TaxLabel.setFont(new Font("Calibri", 0, 18)); // NOI18N
        TaxLabel.setText("TAX:");

        TaxLine.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        TotalLine.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        PaymentCalculation.setFont(new Font("Calibri", 0, 18)); // NOI18N
        PaymentCalculation.setHorizontalAlignment(SwingConstants.RIGHT);
        PaymentCalculation.setText("$ "+String.format("%.2f", Payments)+"    ");

        PaymentLine.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        BalanceCalculation.setFont(new Font("Calibri", 0, 18)); // NOI18N
        BalanceCalculation.setHorizontalAlignment(SwingConstants.RIGHT);
        BalanceCalculation.setText("$ "+String.format("%.2f", (JustTotal + Tax) - Payments)+"    ");

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

        GroupLayout layout = new GroupLayout(printframe.getContentPane());
        printframe.getContentPane().setLayout(layout);
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
        
        printframe.setTitle("Invoice");
        printframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        printframe.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                DisplayAll();
                }
        });
        printframe.setVisible(true);
        printframe.pack();
        printframe.setLocationRelativeTo(null);
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
  
  public void ReceivePaymentsBtnActionPerformed(ActionEvent ae){
	  ReceivePayments(PrintInvoice.getText());
	  
  }
  
  private void BacktoDisplayAllActionPerformed(ActionEvent evt) { 
	  PrintPanel.setVisible(false);
      printframe.dispose();
      DisplayAll();
  }
    
    
    
/////////////////////////////////////////////////PrintDisplay Ends//////////////////////////////////////////////////////
/////////////////////////////////////////////////PrintDisplay Ends//////////////////////////////////////////////////////
/////////////////////////////////////////////////PrintDisplay Ends//////////////////////////////////////////////////////

  public void ReceivePayments(String passedInvoice) {
  	
  	  pframe = new JFrame();
      ReceivePaymentPanel = new JPanel();
      ReceiveInvoiceLabel = new JLabel();
      ReceiveCustomerInfo = new JLabel();
      ReceivePriceLabel = new JLabel();
      ReceiveMemoLabel = new JLabel();
      ReceivePriceField = new JTextField();
      ReceiveMemoField = new JTextField();
      ReceivePaymentBtn = new JButton();
      ReceivePaymentDate = new JTextField();
      String rname ="", raddress = "", rphone = "";
      

      pframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

      ReceiveInvoiceLabel.setFont(new Font("Sylfaen", 0, 22)); // NOI18N
      ReceiveInvoiceLabel.setText(passedInvoice);
      
      try{
      		XPath path = XPathFactory.newInstance().newXPath();
      		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("C:\\Users\\princ\\Documents\\customer.xml");
      		doc.getDocumentElement().normalize();

      		XPathExpression customerexpr = path.compile("//CustomerInfo/Customer/Invoice[text()=" + passedInvoice + "]");
		
      		NodeList customerList = (NodeList)(customerexpr.evaluate(doc, XPathConstants.NODESET));
      		
      		if(customerList.getLength() > 0){
      			Node customer = customerList.item(0).getParentNode();
      			
      			Element cElement = (Element) customer;
      			
      			rname = cElement.getElementsByTagName("Name").item(0).getTextContent();
      			raddress = cElement.getElementsByTagName("Address").item(0).getTextContent();
      			rphone = cElement.getElementsByTagName("Phone").item(0).getTextContent();      			
      		}else{
      			rname = "";
      			raddress = "";
      			rphone = "";
      			}
      			
      }catch(Exception e){
    	  e.printStackTrace();
      }

      ReceiveCustomerInfo.setFont(new Font("Sylfaen", 0, 20)); // NOI18N
      ReceiveCustomerInfo.setText("<html>"+rname+"<br>"+raddress+"<br>"+rphone+"</html>");

      ReceivePriceLabel.setFont(new Font("Sylfaen", 0, 22)); // NOI18N
      ReceivePriceLabel.setText("Price :");

      ReceiveMemoLabel.setFont(new Font("Sylfaen", 0, 20)); // NOI18N
      ReceiveMemoLabel.setText("Memo:");

      ReceivePriceField.setFont(new Font("Sylfaen", 0, 20)); // NOI18N

      ReceiveMemoField.setFont(new Font("Sylfaen", 0, 20)); // NOI18N

      ReceivePaymentBtn.setFont(new Font("Sylfaen", 0, 22)); // NOI18N
      ReceivePaymentBtn.setText("Save");
      ReceivePaymentBtn.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
              ReceivePaymentBtnActionPerformed(evt);
          }
      });
      
      DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
      Date date = new Date();

      ReceivePaymentDate.setFont(new Font("Sylfaen", 0, 22)); // NOI18N
      ReceivePaymentDate.setText(dateformat.format(date));

      GroupLayout ReceivePaymentPanelLayout = new GroupLayout(ReceivePaymentPanel);
      ReceivePaymentPanel.setLayout(ReceivePaymentPanelLayout);
      ReceivePaymentPanelLayout.setHorizontalGroup(
          ReceivePaymentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
          .addGroup(ReceivePaymentPanelLayout.createSequentialGroup()
              .addGap(43, 43, 43)
              .addComponent(ReceiveCustomerInfo, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
              .addGroup(ReceivePaymentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                  .addComponent(ReceiveInvoiceLabel, GroupLayout.Alignment.TRAILING)
                  .addComponent(ReceivePaymentDate, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
              .addContainerGap())
          .addGroup(ReceivePaymentPanelLayout.createSequentialGroup()
              .addGap(122, 122, 122)
              .addGroup(ReceivePaymentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                  .addComponent(ReceiveMemoLabel)
                  .addComponent(ReceivePriceLabel))
              .addGap(18, 18, 18)
              .addGroup(ReceivePaymentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                  .addComponent(ReceivePriceField, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                  .addComponent(ReceiveMemoField, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                  .addComponent(ReceivePaymentBtn, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
              .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      ReceivePaymentPanelLayout.setVerticalGroup(
          ReceivePaymentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
          .addGroup(ReceivePaymentPanelLayout.createSequentialGroup()
              .addGroup(ReceivePaymentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                  .addGroup(ReceivePaymentPanelLayout.createSequentialGroup()
                      .addContainerGap()
                      .addGroup(ReceivePaymentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                          .addComponent(ReceiveCustomerInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                          .addComponent(ReceivePaymentDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                  .addGroup(ReceivePaymentPanelLayout.createSequentialGroup()
                      .addGap(63, 63, 63)
                      .addComponent(ReceiveInvoiceLabel)))
              .addGap(59, 59, 59)
              .addGroup(ReceivePaymentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                  .addComponent(ReceivePriceLabel)
                  .addComponent(ReceivePriceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
              .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
              .addGroup(ReceivePaymentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                  .addComponent(ReceiveMemoLabel)
                  .addComponent(ReceiveMemoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
              .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
              .addComponent(ReceivePaymentBtn)
              .addContainerGap(30, Short.MAX_VALUE))
      );

      GroupLayout layout = new GroupLayout(pframe.getContentPane());
      pframe.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
          layout.createParallelGroup(GroupLayout.Alignment.LEADING)
          .addComponent(ReceivePaymentPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(
          layout.createParallelGroup(GroupLayout.Alignment.LEADING)
          .addComponent(ReceivePaymentPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );
      
      pframe.setTitle("Receive Payments");
      pframe.setLocation(400, 400);
      pframe.setVisible(true);
      pframe.pack();
  }// </editor-fold>                        

  private void ReceivePaymentBtnActionPerformed(ActionEvent evt) {
	  if(ReceivePriceField.equals("")){
		  JOptionPane.showMessageDialog(pframe, "Price is empty");
	  }else if(ReceiveMemoField.equals("")){
		  JOptionPane.showMessageDialog(pframe, "Memo is Empty");
	  }else{
		  MainXML XML = new MainXML();
		  XML.ReceivePayments(Integer.parseInt(ReceiveInvoiceLabel.getText()), ReceivePaymentDate.getText(), ReceivePriceField.getText() , ReceiveMemoField.getText());
		  JOptionPane.showMessageDialog(pframe, "Payment Received");
		  PrintTopPanel.setVisible(false);
		  PrintScrollPane.setVisible(false);
		  PrintPanel.setVisible(false);
		  pframe.dispose();
		  printframe.dispose();
		  PrintDisplay(ReceiveInvoiceLabel.getText());
	  }
  }  
  
  
    public static void main(String args[]) {
    	UIManager.put("OptionPane.messageFont", new Font("Sylfaen", Font.PLAIN, 25));
    	UIManager.put("OptionPane.buttonFont", new Font("Sylfaen", Font.PLAIN, 25));
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainGUI();
            }
        });
    }                 
}
