package fileCoopier.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.dnd.DropTarget;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class DropArea extends JPanel {

	private JLabel fileNameInfo = new JLabel();
	private JRadioButton coppyFile;
	private JRadioButton moveFile;


	public DropArea() {
		this.setBorder(BorderFactory.createLineBorder(Color.blue, 5, true));
		
		DropAction dropAction = new DropAction();		
		dropAction.setDropArea(this);
		
		new DropTarget(this,dropAction);
		
		BorderLayout borderLayout = new BorderLayout();
		this.setLayout(borderLayout);
	    
		
	    fileNameInfo.setBackground(Color.green);
		fileNameInfo.setBorder(BorderFactory.createLineBorder(Color.red));
		fileNameInfo.setHorizontalAlignment(SwingConstants.CENTER);
		fileNameInfo.setVerticalAlignment(SwingConstants.CENTER);
		fileNameInfo.setText("No Folder specyfie");
				
		
		
		JPanel copyOptionPanel = new JPanel(new BorderLayout());
		
		
		
		coppyFile = new JRadioButton();
		coppyFile.setText("coppy");
		coppyFile.setSelected(true);
		
		moveFile = new JRadioButton();
		moveFile.setText("move");
		
		
		ButtonGroup fileOption = new ButtonGroup();
		fileOption.add(coppyFile);
		fileOption.add(moveFile);
		
		
		
		
	
		copyOptionPanel.add(coppyFile, BorderLayout.WEST);
		copyOptionPanel.add(moveFile,BorderLayout.EAST);
		
		JPanel infoPanel = new JPanel(new BorderLayout());
		JLabel fileAciotnInfoLabel = new JLabel("information");
		fileAciotnInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoPanel.add(fileAciotnInfoLabel);
		
		
		this.add(copyOptionPanel, BorderLayout.NORTH);
		this.add(infoPanel,BorderLayout.SOUTH);
		this.add(fileNameInfo);
		
	}
	
	public void setFileNameInfo(String fileName)
	{
		fileNameInfo.setText(fileName);
	}
	
	public void setPopUpMessage(String popUpMessage)
	{
		fileNameInfo.setToolTipText(popUpMessage);
	}
	
	public boolean isCoppySelected() {
		
		return coppyFile.isSelected();
	}
	public boolean isMoveSelected() {
		
		return moveFile.isSelected();
	}
	
	
	@Override
	public Dimension preferredSize() {
		
		return  new Dimension(150,150);
	}
	
	
		
	
}
