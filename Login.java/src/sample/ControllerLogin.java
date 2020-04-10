package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class ControllerLogin {
    @FXML
    private ImageView imageview1;
    @FXML
    private Text target;
    @FXML
    private StackPane stackPane;
    private boolean verifyLogin = true;
    public void Summit(ActionEvent event) throws IOException {
        changeTop();
    }
    public void changeTop(){
        ObservableList<Node> list = this.stackPane.getChildren();
        if(list.size() >1){
            Node topNode = list.get(list.size()-1);
            Node newNode = list.get(list.size()-2);
            topNode.setVisible(false);
            topNode.toBack();
            newNode.setVisible(true);
        }
    }
    public void click(ActionEvent event) {
        try{
            if(verifyLogin ==false){
                Error();
            }
            if(verifyLogin == true){
                Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
                Stage window = new Stage();
                Scene scene = new Scene(root,1083,690);
                window.getIcons().add(new Image(getClass().getResourceAsStream("book.png")));
                window.setTitle("Hust English App");
                window.setScene(scene);
                window.show();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    //error login
    public void Error(){
        this.target.setFill(Color.RED);
        this.target.setText("Sign in button pressed");
    }
    public void setHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("challenge.fxml"));
        Stage window = new Stage();
        Scene scene = new Scene(root,1083,690);
        window.getIcons().add(new Image(getClass().getResourceAsStream("book.png")));
        window.setTitle("Hust English App");
        System.out.println("hello");
        window.setScene(scene);
        window.show();
    }
}
