module com.tictactoe.tictactoecontroller {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tictactoe.tictactoecontroller to javafx.fxml;
    exports com.tictactoe.tictactoecontroller;
}