import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class TTT extends Application{
    TextField tf;
    Label tip;
    Label tax;
    Label total;
    public static void main(String[] args) {
        launch(args);
    }

    class buttonConvert implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {

            String s = tf.getText();
            double cost = Double.parseDouble(s);
            double tip1 = cost * (0.18);
            double tax1 = cost * (0.07);
            double total1 = cost + tax1 + tip1;

            tip.setText(String.format("18 tip = %.2f", tip1));
            tax.setText(String.format("7 tax = %.2f", tax1));
            total.setText(String.format("total = %.2f", total1));
            }
            
        
    }

    public void start(Stage stage) {
        Label l1 = new Label("Enter the food Charge: ");
        tf = new TextField();
        tip = new Label("18% tip = ");
        tax = new Label("7% tax = ");
        total = new Label("total = ");
        Button cal = new Button("calculate");
        cal.setOnAction(new buttonConvert());
        HBox hbox = new HBox(10, l1, tf, cal);
        VBox vbox = new VBox(10, tip, tax, total);
        VBox mainVBox = new VBox(10, hbox, vbox);
        Scene scene = new Scene(mainVBox);
        stage.setScene(scene);
        stage.setTitle("TTT");
        stage.show();

    }
}
