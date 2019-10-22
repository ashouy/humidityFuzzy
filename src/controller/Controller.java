package controller;

import com.company.Mamdani;
import com.company.TakagiS;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    private Mamdani m = new Mamdani();
    private TakagiS t = new TakagiS();
    private Float sensor1;
    private Float sensor2;
    private Float sensor3;
    private Float fase;
    private double resultt;

    @FXML
    Label humidityResult;

    @FXML
    private TextField inputSensor1, inputSensor2, inputSensor3, inputFase;

    @FXML
    private void startTakagi(){
        sensor1 = Float.parseFloat(inputSensor1.getText().toString());
        sensor2 = Float.parseFloat(inputSensor2.getText().toString());
        sensor3 = Float.parseFloat(inputSensor3.getText().toString());
        fase = Float.parseFloat(inputFase.getText().toString());
        resultt = t.startT(sensor1,sensor2,sensor3,fase);
        resultt = Math.round(resultt);
        humidityResult.setText( resultt +"%");
    }

    @FXML
    private void startMamdani(){
        sensor1 = Float.parseFloat(inputSensor1.getText().toString());
        sensor2 = Float.parseFloat(inputSensor2.getText().toString());
        sensor3 = Float.parseFloat(inputSensor3.getText().toString());
        fase = Float.parseFloat(inputFase.getText().toString());
        resultt = m.start(sensor1,sensor2,sensor3,fase);
        resultt = Math.round(resultt);
        humidityResult.setText(resultt +"%");
    }
}
