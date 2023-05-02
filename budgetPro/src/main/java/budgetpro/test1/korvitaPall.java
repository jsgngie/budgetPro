package budgetpro.test1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class korvitaPall extends Application {
        @Override
        public void start(final Stage primaryStage){
            // akna loomine
            Stage testStage = new Stage();
            testStage.setTitle("Test aken");
            Pane root = new Pane();
            Scene testScene = new Scene(root, 600, 600);
        }
        public static void main(String[] args) {
            launch(args);
        }

}
