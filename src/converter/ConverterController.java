package converter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * UI controller for events and initializing components.
 * @author Kunyaruk Katebunlu
 */
public class ConverterController {
	@FXML
	TextField textfield1;
	@FXML
	TextField textfield2;
	@FXML
	private ComboBox<Length> unitbox1;
	@FXML
	private ComboBox<Length> unitbox2;
	
	@FXML
	public void initialize() {
		System.out.println("Running initialize");
		if(unitbox1 != null) {
			unitbox1.getItems().addAll(Length.values());
			unitbox1.getSelectionModel().select(0);
		}
		if(unitbox2 != null) {
			unitbox2.getItems().addAll(Length.values());
			unitbox2.getSelectionModel().select(1);
		}
	}
	
	public void handleConvert(ActionEvent event) {
		String text = textfield1.getText().trim();
		Length unit1 = unitbox1.getValue();
		System.out.printf("got values %s %s\n", text, unit1.toString());
		String text2 = textfield2.getText().trim();
		Length unit2 = unitbox2.getValue();
		System.out.printf("got values %s %s\n", text2, unit2.toString());
		String result;
		double convertToMeter;
		
		try {
			if(!text.isEmpty()) {
				double input1 = Double.parseDouble(text);
				convertToMeter = input1/unit2.getValue();
				System.out.println("handleConvert converting " + text);
				result = String.format("%.4g", convertToMeter*unit1.getValue());
				textfield2.setText(result);
			} else if(!text2.isEmpty()) {
				double input2 = Double.parseDouble(text2);
				convertToMeter = input2/unit1.getValue();
				System.out.println("handleConvert converting " + text2);
				result = String.format("%.4g", convertToMeter*unit2.getValue());
				textfield1.setText(result);
			}
		} catch(NumberFormatException num) {
			if(!text.equals("")) {
				textfield2.setText("Invalid number");
				textfield2.setStyle("-fx-control-inner-background: #f08080;");
			} else if(!text2.equals("")) {
				textfield1.setText("Invalid number");
				textfield1.setStyle("-fx-control-inner-background: #f08080;");
			}
		}
	}
	
	public void handleClear() {
		textfield1.clear();
		textfield1.setStyle("-fx-control-inner-background: white;");
		textfield2.clear();
		textfield2.setStyle("-fx-control-inner-background: white;");
	}
}
