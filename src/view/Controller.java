package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Controller implements Initializable {
	@FXML
	private TextArea ta;
	@FXML
	private Button b;
	@FXML
	private Main main;

	private FileReader fr;
	private BufferedReader br;

	public void test() throws IOException {
		String str = br.readLine();
		if (str == null) {
			ta.appendText("结束了");
		} else {
			ta.appendText(str + "\n");
		}

	}

	public void setMainAPP(Main m) {
		main = m;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			fr = new FileReader(new File("lines.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		br = new BufferedReader(fr);
	}
}
