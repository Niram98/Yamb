/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domaciyamb;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Korisnik
 */
public class DomaciYamb extends Application 
{
    public Scene scene;
    int brojac = 1;
    @Override
    public void start(Stage primaryStage) 
    {
        //GridPane 
        GridPane gp = new GridPane();
        gp.setVgap(20);
        gp.setHgap(20);
        Scene scene = new Scene(gp, 800,400);
        gp.setAlignment(Pos.CENTER);
        
        //Komponente
        Label userLabel = new Label("Username: ");
        Label pwLabel = new Label("Password: ");
        TextField userText = new TextField();
        PasswordField pwText = new PasswordField();
        Button logBtn = new Button("Login");
        
        //Dodavanje na GridPane
        gp.add(userLabel, 0, 0);
        gp.add(userText, 1, 0);
        gp.add(pwLabel, 0, 1);
        gp.add(pwText, 1, 1);
        gp.add(logBtn, 2, 3);
        
        //Username i password za login stranu
        String username = "Marin";
        String password = "sifra";
        
        //Logovanje
        logBtn.setOnAction(e -> 
        {
            if(userText.getText().matches(username) && pwText.getText().matches(password))
            {
                //Pravljenje panela za yamb igru
               FlowPane fp = new FlowPane();
                fp.setVgap(10);
                fp.setHgap(20);
//                fp.setPadding(new Insets(10, 0, 0, 100));
                Scene scene3 = new Scene(fp,600,500);
                
                Button  btn1 = new Button();
                btn1.setPrefWidth(35);
                btn1.setPrefHeight(35);
                Button  btn2 = new Button();
                btn2.setPrefWidth(35);
                btn2.setPrefHeight(35);
                Button  btn3 = new Button();
                btn3.setPrefWidth(35);
                btn3.setPrefHeight(35);
                Button  btn4 = new Button();
                btn4.setPrefWidth(35);
                btn4.setPrefHeight(35);
                Button  btn5 = new Button();
                btn5.setPrefWidth(35);
                btn5.setPrefHeight(35);
                Button  btn6 = new Button();
                btn6.setPrefWidth(35);
                btn6.setPrefHeight(35);
                
                HBox hb = new HBox();
                hb.getChildren().addAll(btn1, btn2, btn3, btn4, btn5, btn6);
                hb.setPadding(new Insets(30, 145, 0, 145));
                hb.setSpacing(20);
                
                
                CheckBox cb1 = new CheckBox();
                CheckBox cb2 = new CheckBox();
                CheckBox cb3 = new CheckBox();
                CheckBox cb4 = new CheckBox();
                CheckBox cb5 = new CheckBox();
                CheckBox cb6 = new CheckBox();
                HBox hb2 = new HBox();
                hb2.getChildren().addAll(cb1, cb2, cb3, cb4, cb5, cb6);
                hb2.setPadding(new Insets(10, 155, 0, 155));
                hb2.setSpacing(39);
                
                HBox hb3 = new HBox();
                hb3.setPadding(new Insets(10, 225, 0, 225));
                Button baciOpet = new Button("Baci kockice");
                baciOpet.setPrefWidth(150);
                hb3.getChildren().addAll(baciOpet);

                HBox hb0 = new HBox();
                hb0.setPadding(new Insets(10, 225, 0, 260));
                Button stop = new Button("Zaustavi");
                stop.setPrefWidth(75);
                hb0.getChildren().addAll(stop);
                
                HBox hb4 = new HBox();
                hb4.setPadding(new Insets(50, 280, 0, 220));
                Label bacanje = new Label("Bacanje: ");
                TextField brojBacanja = new TextField(String.valueOf(0));
                Label rezultat = new Label();
                brojBacanja.setPrefWidth(50);
                hb4.setSpacing(10);
                hb4.getChildren().addAll(bacanje, brojBacanja, rezultat);
                
                HBox hb5 = new HBox();
                hb5.setPadding(new Insets(100, 100, 0, 400));
                Button refreshBtn = new Button("Nova igra");
                hb5.getChildren().addAll(refreshBtn);
                
                fp.getChildren().addAll(hb, hb2, hb3, hb0, hb4, hb5);
                

                
                if(brojac<=3)
                {
                    baciOpet.setOnAction(e2 ->
                    {
                        int[] niz_brojeva = new Random().ints(1, 7).limit(6).toArray();
                        
                        if(!cb1.isSelected() && !baciOpet.getText().equals("Prikazi rezultat"))
                            btn1.setText(Integer.toString(niz_brojeva[0]));
                        if(!cb2.isSelected() && !baciOpet.getText().equals("Prikazi rezultat"))
                            btn2.setText(Integer.toString(niz_brojeva[1]));
                        if(!cb3.isSelected() && !baciOpet.getText().equals("Prikazi rezultat"))
                            btn3.setText(Integer.toString(niz_brojeva[2]));
                        if(!cb4.isSelected() && !baciOpet.getText().equals("Prikazi rezultat"))
                            btn4.setText(Integer.toString(niz_brojeva[3]));
                        if(!cb5.isSelected() && !baciOpet.getText().equals("Prikazi rezultat"))
                            btn5.setText(Integer.toString(niz_brojeva[4]));
                        if(!cb6.isSelected() && !baciOpet.getText().equals("Prikazi rezultat"))
                            btn6.setText(Integer.toString(niz_brojeva[5]));
                        brojBacanja.setText(Integer.toString(brojac));

                        stop.setOnAction(event -> {
                            brojac = 3;
                            baciOpet.setText("Prikazi rezultat");
                        });

//                        Ako je broj bacanja jednak 3, prekid bacanja
                        if(brojBacanja.getText().matches("3"))
                        {
                            int n1 = Integer.parseInt(btn1.getText());
                            int n2 = Integer.parseInt(btn2.getText());
                            int n3 = Integer.parseInt(btn3.getText());
                            int n4 = Integer.parseInt(btn4.getText());
                            int n5 = Integer.parseInt(btn5.getText());
                            int n6 = Integer.parseInt(btn6.getText());
                            int[] kockice = {n1, n2, n3, n4, n5, n6};

                            stop.setDisable(true);
                            baciOpet.setDisable(true);
                            rezultat.setText(rez(kockice));
                            
                            
                        }
                        brojac++;
                    });
                }

                
                //Dugme za zapocinjanje nove partije
                refreshBtn.setOnAction(e2 ->
                {
                    brojBacanja.setText(String.valueOf(0));
                    rezultat.setText("");
                    btn1.setText("");
                    btn2.setText("");
                    btn3.setText("");
                    btn4.setText("");
                    btn5.setText("");
                    btn6.setText("");
                    
                    cb1.setSelected(false);
                    cb2.setSelected(false);
                    cb3.setSelected(false);
                    cb4.setSelected(false);
                    cb5.setSelected(false);
                    cb6.setSelected(false);
                    
                    brojac = 1;

                    baciOpet.setText("Baci kockice");
                    baciOpet.setDisable(false);
                    stop.setDisable(false);
                });
                
                primaryStage.setTitle("YAMB game");
                primaryStage.setScene(scene3);
                primaryStage.show();   
            }
            //Ukoliko username i password nisu tacni, error dialog box
            else
            {
                GridPane gp2 = new GridPane();
                gp2.setVgap(30);
                gp2.setHgap(30);
                Scene scene2 = new Scene(gp2,300,300);
                
                Label messageLabel = new Label("Nepostojeci username ili password");
                gp2.add(messageLabel, 1, 3);
                
                primaryStage.setTitle("Error dialog box");
                primaryStage.setScene(scene2);
                primaryStage.show();
                
                Button backBtn = new Button("Vrati se");
                backBtn.setOnAction(e2 -> 
                {
                 primaryStage.setTitle("Login page");
                 primaryStage.setScene(scene);
                 primaryStage.show();
                });
                gp2.add(backBtn, 1, 4);
            }
        });
        
        primaryStage.setTitle("Login page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static String rez(int[] niz) {
        int counter = 0;
        int br = 0;
        
        if(nadji(niz, 2) && nadji(niz, 3) && nadji(niz, 4) && nadji(niz, 5)) {
            if(nadji(niz, 1) && nadji(niz, 6))
                return "Super Kenta: 1, 2, 3, 4, 5, 6";
            if(nadji(niz, 1))
                return "Kenta 1, 2, 3, 4, 5";
            if(nadji(niz, 6))
                return "Kenta 2, 3, 4, 5, 6";
             
        }
        for(int j = 1; j <= 6; j++) {
            int jcounter = 0;
            for(int i = 0; i < niz.length; i++) {
                if(niz[i] == j)
                    jcounter++;
            }
            if(jcounter > 3) {
                counter = jcounter;
                br = j;
            }
        }
        
        if(counter == 4)
            return "Kare:" + br;
        else if(counter == 5 || counter == 6)
            return "Yamb:" + br;
        return "Nista od trazenog";
    }
    
    public static boolean nadji(int[] niz, int n) {
        boolean ima = false;
        for (int i : niz) {
            if(n == i)
                ima = true;
        }
        return ima;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
