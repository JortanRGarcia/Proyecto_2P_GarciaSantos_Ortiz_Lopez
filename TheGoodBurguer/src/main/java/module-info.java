module com.pooespol.thegoodburguer {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.pooespol.thegoodburguer to javafx.fxml;
    exports com.pooespol.thegoodburguer;
}