module com.assignment.tictactoe.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.assignment.tictactoe.tictactoe.controller to javafx.fxml;
    exports com.assignment.tictactoe.tictactoe;
}