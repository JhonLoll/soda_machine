module com.soda.soda_machine {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.soda.soda_machine to javafx.fxml;
    exports com.soda.soda_machine;
}
