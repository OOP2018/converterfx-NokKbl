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
	
	/**
	 * JavaFX calls the initialize() method of the controller when
	 * it creates the UI form, after the components have been created
	 * and @FXML annotated attributes have been set.
	 */
	@FXML
	public void initialize() {
		if(unitbox1 != null) {
			unitbox1.getItems().addAll(Length.values());
			unitbox1.getSelectionModel().select(0);
		}
		if(unitbox2 != null) {
			unitbox2.getItems().addAll(Length.values());
			unitbox2.getSelectionModel().select(1);
		}
	}
	
	/**
	 * Convert a distance from one unit to another.
	 */
	public void handleConvert(ActionEvent event) {
		String text = textfield1.getText().trim();
		Length unit1 = unitbox1.getValue();
		String text2 = textfield2.getText().trim();
		Length unit2 = unitbox2.getValue();
		String result;
		double convertToMeter;
		
		try {
			if(!text.isEmpty()) {
				double input1 = Double.parseDouble(text);
				convertToMeter = input1/unit2.getValue();
				result = String.format("%.4g", convertToMeter*unit1.getValue());
				textfield2.setText(result);
			} else if(!text2.isEmpty()) {
				double input2 = Double.parseDouble(text2);
				convertToMeter = input2/unit1.getValue();
				result = String.format("%.4g", convertToMeter*unit2.getValue());
				textfield1.setText(result);
			}
		} catch(NumberFormatException num) {
			if(!text.isEmpty()) {
				textfield2.setText("Invalid number");
			} else if(!text2.isEmpty()) {
				textfield1.setText("Invalid number");
			}
		}
	}
	
	/**
	 * Clear text in TextField.
	 */
	public void handleClear() {
		textfield1.clear();
		textfield2.clear();
	}
}
