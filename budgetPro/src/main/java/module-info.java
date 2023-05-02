module budgetpro.test1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens budgetpro.test1 to javafx.fxml;
    exports budgetpro.test1;
}