package fileCoopier.gui;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;

public class CoppyThread implements Runnable {

	private File directory;
	private File file;

	public File getDirectory() {
		return directory;
	}

	public void setDirectory(File directory) {
		this.directory = directory; // thread
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Override
	public void run() {

		
		Random random = new Random();
		Integer number = random.nextInt();
		
		
		System.out.println("Watek wystartowal: = " + number);
		
		try {
			FileUtils.copyFileToDirectory(file, directory);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Watek zakonczyl robote: = " + number);
	}

}
