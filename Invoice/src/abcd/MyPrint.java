package abcd;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;
import java.awt.print.*;

public class MyPrint extends MainGUI implements Printable, ActionListener{
	JFrame frameToPrint;
	JPanel printpane;
	public int print(Graphics g, PageFormat pf, int page) throws PrinterException{
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
		double y = ((pf.getImageableHeight() - scaleheight)/ 2d) + pf.getImageableY();
		
		AffineTransform at = new AffineTransform();
		
		at.translate(x,y);
		at.scale(scalefactor, scalefactor);
		g2.transform(at);
		PrintPanel.printAll(g2);
		//g2.dispose();
		//displaypanel.revalidate();
	
		return PAGE_EXISTS;
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
	
	
	
	public void actionPerformed(ActionEvent ae){
		PrinterJob pj = PrinterJob.getPrinterJob();
		pj.setPrintable(this);
		boolean ok = pj.printDialog();
		if(ok){
			try{
				pj.print();
			}catch(PrinterException ex){
				ex.printStackTrace();
			}
		}
	}
	
	public MyPrint(JPanel j){
		printpane = j;
	}
	
	MyPrint(){
		//JFrame frame = new JFrame("Print");
		//UIManager.put("swing.boldMetal", Boolean.FALSE);
		//frame.addWindowListener(new WindowAdapter(){
		//	public void windowClosing(WindowEvent e){System.exit(0);}
		//});
		///JButton printbtn = new JButton("Print");
		PrintBtn.addActionListener(new MyPrint(PrintPanel));
		//frame.add("South", printbtn);
		//frame.setVisible(true);
		//frame.pack();
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
