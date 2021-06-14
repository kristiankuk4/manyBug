package org.kirovEyes.controller;

import de.felixroske.jfxsupport.FXMLController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
@RestController
public class DemoController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public Label hello;
    public TextField MD5;

    public void finctionSayHello(ActionEvent actionEvent) {
        hello.setText("文件路径");
        Stage fileStage = null;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        //选择文件，识别文件
        File selectedFile =fileChooser.showOpenDialog(fileStage);
        String fileMD5= DigestUtils.md5Hex(String.valueOf(selectedFile));
        hello.setText(String.valueOf(selectedFile));
        System.out.println("文件MD5是"+fileMD5);
        MD5.setText(fileMD5);
    }

    public void changeLabel(String text){
        Platform.runLater(new Runnable(){
            @Override
            public void run() {
                hello.setText(text);
            }
        });
    }

    @GetMapping("/demo")
    public String hello() {
        System.out.println("hello springboot!!!");
        Platform.runLater(new Runnable(){
            @Override
            public void run() {
                hello.setText("hello springboot!!!");
            }
        });
        return "hello springboot";
    }
}
