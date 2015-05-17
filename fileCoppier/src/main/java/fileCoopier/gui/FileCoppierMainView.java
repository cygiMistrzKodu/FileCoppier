package fileCoopier.gui;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class FileCoppierMainView extends JFrame {


	public FileCoppierMainView() {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 200);

		FlowLayout flowLayout = new FlowLayout();

		this.setLayout(flowLayout);
		this.setVisible(true);


		for (int i = 0; i < 5; i++) {

			this.add(new DropArea());
			
		}

		this.pack();

	}

}
