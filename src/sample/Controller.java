package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller
{
    private  double epsilon ,x;
    @FXML
    private Button solution;
    @FXML
    private TextField textepsilon,textx;

    @FXML
    private void click(ActionEvent event)
    {
        epsilon = Double.valueOf(textepsilon.getText());
        x = Double.valueOf(textx.getText());

        solution.setText("Done!");
    }
}
