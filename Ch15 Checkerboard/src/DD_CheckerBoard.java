import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javax.swing.*;

/**
 * @author Dolunay Dagci
 * CISS 111-360
 * Assignment: Ch15 CheckerBoard
 * Due: 3.17.19
 * This program takes a number from the user, uses the number as grid size 'n x n', and creates a checkerboard.
 */
public class DD_CheckerBoard extends Application {

    Scene scene1, scene2; //2 scenes created to pass from a scene to another scene when create a checkerboard is clicked

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("My Checkerboard");

        //Scene 1 - OptionPane
        HBox optionsPane = new HBox(5);
        optionsPane.setAlignment(Pos.CENTER); //sets alignment
        optionsPane.setPadding(new Insets(5,5,5,5));
        TextField n_input = new TextField("0"); //gets n from the user
        Label label = new Label("Enter a number to customize grid size.");
        Button createButton = new Button("Create A New Checkerboard"); //button to create the new grid for checkerboard
        createButton.setOnAction(new EventHandler<ActionEvent>() { //handle event when button is clicked
            @Override
            public void handle(ActionEvent event) {

                    //Scene 2 - Create Checkerboard
                    GridPane checkerboardPane = new GridPane(); //create a grid pane
                try {
                    int n = Integer.parseInt(n_input.getText()); //parse input n to int
                    int count = 0; //keep count of rectangles
                    double s = 70; // side of rectangle
                    for (int i = 0; i < n; i++) { //create the grid and rectangles
                        if(n%2 ==1) count++;
                        count++;
                        for (int j = 0; j < n; j++) {
                            Rectangle r = new Rectangle(s, s, s, s); //create rectangle
                                if(n%2==1){ //if n is odd
                                if (count % 2 == 1) r.setFill(Color.BLACK);
                                else if (count%2==0) {
                                    r.setFill(Color.WHITE); } }
                                else if(n%2==0){ //if n is even
                                if (count % 2 == 1) r.setFill(Color.WHITE);
                                else if (count%2==0) {
                                    r.setFill(Color.BLACK); } }

                                checkerboardPane.add(r, j, i); //add components to checkerboard
                                count++;
                        }}
                    scene2 = new Scene(checkerboardPane); //Create scene 2 - checkerboard
                    primaryStage.setScene(scene2); //calls checkerboard to the scene
                   }catch (RuntimeException a) { //catch any exceptions

                    if (n_input.getText().equals(""))   JOptionPane.showMessageDialog(null, "You did not enter a value.",
                            "Error",JOptionPane.ERROR_MESSAGE);

                    else JOptionPane.showMessageDialog(null, "Error! You've entered an invalid value.",
                                "Error",JOptionPane.ERROR_MESSAGE);
                    }}});

        optionsPane.getChildren().addAll(n_input, label, createButton); //add components
        scene1 = new Scene(optionsPane, 600,100); //create scene 1 for optionsPane

            primaryStage.setScene(scene1); // Place in scene in the stage, first scene is for the option pane
            primaryStage.show(); // Display the stage;
        }
    public static void main(String[] args) throws Exception{
        launch(args); }}
