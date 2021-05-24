package abcd;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class LabelRenderer extends JLabel implements TableCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LabelRenderer(){
		setOpaque(true);
		setFont(new Font("Sylfaen", Font.PLAIN, 20));
		setVerticalTextPosition(TOP);
		setVerticalAlignment(TOP);
	}
	
	public Component getTableCellRendererComponent(JTable table, Object value, 
			boolean isSelected, boolean hasFocus, int row, int column){
		if(isSelected){
			setForeground(table.getSelectionForeground());
			setBackground(table.getSelectionBackground());
		}else{
			setForeground(table.getForeground());
			setBackground(UIManager.getColor("Button.background"));
		}
		setText((value == null) ? "" : value.toString());
		return this;
	}
}
