package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class Controller implements Initializable {
	@FXML
	private TextArea ta;
	@FXML
	private Button b;
	@FXML
	private Main main;
	@FXML
	private Text t1;

	private FileReader fr;
	private BufferedReader br;
	private static Random r = new Random();

	public void test() throws IOException {
		String str = br.readLine();
		t1.setText(String.valueOf(r.nextInt(32)));
		if (str == null) {
			ta.appendText("结束了");
			System.exit(1);
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
			BufferedReader br1 = new BufferedReader(new FileReader(new File("prologue.txt")));   //中文utf-8格式存储
			String str1 = null;
			while((str1 = br1.readLine()) != null){
				ta.appendText(str1 + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			fr = new FileReader(new File("lines.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		br = new BufferedReader(fr);
	}
}
