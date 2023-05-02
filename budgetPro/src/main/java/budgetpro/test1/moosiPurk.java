package budgetpro.test1;

import javafx.animation.*;
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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.security.Key;

import static javafx.animation.Animation.INDEFINITE;

public class moosiPurk extends Application {
    @Override
    public void start(final Stage primaryStage) throws InterruptedException {
        // akna loomine
        Stage testStage = new Stage();
        testStage.setTitle("Test aken");
        Pane root = new Pane();
        Scene testScene = new Scene(root, 600, 600);
        //vajalikud objectid.
        Rectangle vasakKate = new Rectangle(200,600, Color.BISQUE);
        Rectangle paremKate = new Rectangle(200,600,Color.BISQUE);
        Circle kaarUks = new Circle(300,300,100);
        Circle kaarKaks = new Circle(100,300,100);
        Circle kaarKolm = new Circle(-100,300,100);
        kaarUks.setFill(Color.CRIMSON);
        kaarKaks.setFill(Color.WHITE);
        kaarKolm.setFill(Color.CRIMSON);
        paremKate.setLayoutX(400);
        Rectangle alumineKate = new Rectangle(300,300,Color.CRIMSON);
        alumineKate.setLayoutX(200);
        alumineKate.setLayoutY(300);
        root.getChildren().addAll(alumineKate, kaarUks, kaarKaks, kaarKolm, vasakKate, paremKate);
        //animatsioonid
        Timeline timeline = new Timeline();
        timeline.setCycleCount(INDEFINITE);

        KeyValue kv = new KeyValue(kaarUks.centerXProperty(),700);
        KeyValue kv2 = new KeyValue(kaarKaks.centerXProperty(), 500);
        KeyValue kv3 = new KeyValue(kaarKolm.centerXProperty(), 300);
        KeyFrame kf = new KeyFrame(Duration.millis(2000),kv,kv2,kv3);

        Timeline timeline2 = new Timeline();
        timeline2.setCycleCount(INDEFINITE);

        KeyValue kv8 = new KeyValue(kaarUks.centerYProperty(),350);
        KeyValue kv5 = new KeyValue(kaarKaks.centerYProperty(), 350);
        KeyValue kv6 = new KeyValue(kaarKolm.centerYProperty(),350);
        KeyValue kv7 = new KeyValue(alumineKate.yProperty(),50);
        KeyFrame kf4 = new KeyFrame(Duration.millis(1000),kv8,kv5,kv6,kv7);

        timeline2.getKeyFrames().add(kf4);
        timeline2.setAutoReverse(true);
        timeline2.play();
        timeline.getKeyFrames().add(kf);
        timeline.play();
        testStage.setScene(testScene);
        testStage.show();

        // animatsioon
    }
    public static void main(String[] args) {
        launch(args);
    }

}
