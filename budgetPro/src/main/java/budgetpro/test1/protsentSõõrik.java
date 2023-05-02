package budgetpro.test1;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class protsentSõõrik extends Application {

    public double leiaNurk(double hiireX, double hiireY) {
        double xDiff = hiireX - 300;
        double yDiff = hiireY - 300;
        double nurk = Math.toDegrees(Math.atan2(yDiff, xDiff));

        if (nurk < 0) {
            return -nurk;
        } else {
            return 180+(180-nurk);
        }
    }

    @Override
    public void start(final Stage primaryStage) {
        // akna loomine
        Stage testStage = new Stage();
        testStage.setTitle("Test aken");
        Pane root = new Pane();
        Scene testScene = new Scene(root, 600, 600);

        // loon objektid.
        Label tekstProtsent = new Label();
        tekstProtsent.setLayoutY(280);
        tekstProtsent.setLayoutX(267.5);
        tekstProtsent.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 25));
        Circle taustaRing = new Circle(150, Color.LIGHTCORAL);
        taustaRing.setLayoutX(300);
        taustaRing.setLayoutY(300);
        Circle sisemineRing = new Circle(125, Color.WHITE);
        sisemineRing.setLayoutX(300);
        sisemineRing.setLayoutY(300);
        Arc spanningArc = new Arc(300,300,151,151,0,0);
        spanningArc.setType(ArcType.ROUND);
        spanningArc.setFill(Color.WHITE);
        root.getChildren().addAll(taustaRing, sisemineRing, spanningArc, tekstProtsent);

        // hiire värk
        root.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent event) {
                double hiireX = event.getX();
                double hiireY = event.getY();
                double nurk = leiaNurk(hiireX, hiireY);
                spanningArc.setLength(nurk);
                tekstProtsent.setText(String.format("%.2f", nurk/360*100));
            }
        });

        // akna näitamine
        testStage.setScene(testScene);
        testStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }

}
