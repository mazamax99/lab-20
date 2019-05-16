import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.*;
import javafx.scene.layout.*;

import java.awt.*;
import java.util.Random;

public class Main extends Application {
    public static void main (String[] args){
        launch(args);
    }
    public void init(){
        System.out.println("В теле метода init().");
    }

    public void start(Stage stage) {
        System.out.println("В теле метода start().");
        stage.setTitle("Skeleton");
        FlowPane rootNode= new FlowPane(10,10);
        rootNode.setAlignment(Pos.CENTER);
        Alert MessageBox1= new Alert(Alert.AlertType.INFORMATION);
        MessageBox1.setTitle("Э, ты че нажал сюда?");
        MessageBox1.setHeaderText(null);
        MessageBox1.setContentText("Можешь закрывать ->>");
        Scene myScene= new Scene(rootNode,500,100);
        Label lbl=new Label("Не нажимай вторую кнопку");
        Button but1=new Button("Не жми туда ->");
        Button but2=new Button("Жми меня полностью");
        but1.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MessageBox1.showAndWait();
            }
        });
        but2.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MessageBox1.showAndWait();
            }
        });
//        double heightBut;
//        double widthBut;
//        double x;
//        double y;
//        double maxHeight;
//        double maxWidth;
//        double newX;
//        double newY;
//        //but2.setOnMouseMoved(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                Double mousex=event.getX();
//                Double mousey=event.getY();
//                double heightBut= but2.getMaxHeight();
//                double widthBut= but2.getMaxWidth();
//                double x=but2.getLayoutX();
//                double y=but2.getLayoutY();
//                double maxHeight=myScene.getHeight();
//                double maxWidth=myScene.getWidth();
//
//                if(mousex==x&&mousey==y){
//                    but2.setVisible(false);
//                    double newX=x+ Math.random()*(maxWidth-widthBut);
//                    double newY=y+ Math.random()*(maxHeight-heightBut);
//                    but2.setVisible(true);
//                }
//
//            }
//        });
        but2.setOnMouseEntered(event -> {
            but2.setVisible(false);
        });
        but2.setOnMouseExited(event -> {
            double heightBut= but2.getMaxHeight();
            double widthBut= but2.getMaxWidth();
            double x=but2.getLayoutX();
            double y=but2.getLayoutY();
            double maxHeight=myScene.getHeight();
            double maxWidth=myScene.getWidth();
            double newX=x+ Math.random()*(maxWidth-widthBut);
            double newY=y+ Math.random()*(maxHeight-heightBut);
            //but2.relocate(newX,newY);
            but2.setLayoutX(newX);
            but2.setLayoutY(newY);
            but2.setVisible(true);

        });
        rootNode.getChildren().addAll(lbl,but1,but2);
        stage.setScene(myScene);
        stage.show();

    }
    public void stop(){
        System.out.println("В теле метода stop().");
    }
}
