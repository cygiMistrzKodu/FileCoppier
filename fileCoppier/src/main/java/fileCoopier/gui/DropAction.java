package fileCoopier.gui;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.swing.JLabel;

public class DropAction implements DropTargetListener {

	private File directory;
    private DropArea dropArea;
	
	public DropArea getDropArea() {
		return dropArea;
	}

	public void setDropArea(DropArea dropArea) {
		this.dropArea = dropArea;
	}

	public File getDirectory() {
		return directory;
	}

	public void setDirectory(File directory) {
		this.directory = directory;
	}

	@Override
	public void dragEnter(DropTargetDragEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dragExit(DropTargetEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dragOver(DropTargetDragEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drop(DropTargetDropEvent dropEvent) {
		System.out.println("Drop a file");

		DataFlavor[] dataFlavors = dropEvent.getCurrentDataFlavors();
		Transferable tr = dropEvent.getTransferable();

		for (DataFlavor flavors : dataFlavors) {

			dropEvent.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);

			try {

				java.util.List<File> list = (List<File>) tr
						.getTransferData(flavors);

				for (File file : list) {

					if (file.isDirectory()) {
						System.out.print("IsDirectory");
						directory = file;
						
						
						dropArea.setFileNameInfo(directory.getName());
						dropArea.setPopUpMessage(directory.getAbsolutePath());
						
					} else {

						
						CoppyThread coppyThread = new CoppyThread();
						coppyThread.setDirectory(directory);
						coppyThread.setFile(file);
						
						Thread thread = new Thread(coppyThread);
						thread.start();
						
						

					}
				}

			} catch (UnsupportedFlavorException | IOException e) {
				
				e.printStackTrace();
			}

		}

	}

	@Override
	public void dropActionChanged(DropTargetDragEvent arg0) {
		// TODO Auto-generated method stub

	}

}
