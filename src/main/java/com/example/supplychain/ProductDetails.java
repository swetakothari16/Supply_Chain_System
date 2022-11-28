package com.example.supplychain;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class ProductDetails {

    public TableView<Product> productTable;// = new TableView<>();

   // Product product = new Product();
    public Pane getAllProduct(){
        TableColumn id = new TableColumn("Id");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn name = new TableColumn("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn price = new TableColumn("Price");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        final ObservableList<Product> data = FXCollections.observableArrayList();
        data.add(new Product(1,"Lenlov",88874));
        data.add(new Product(2,"mac",67895));


        ObservableList<Product> Items = Product.getAllProducts();

        productTable = new TableView<>();
        productTable.setItems(Items);
        productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        productTable.getColumns().addAll(id,name,price);
         productTable.setMinSize(SupplyChain.width,SupplyChain.height);

        Pane tablePane = new Pane();
        tablePane.setMinSize(SupplyChain.width, SupplyChain.height);
        tablePane.getChildren().add(productTable);
        return tablePane;



    }

    public Product getSelectedProduct(){
        if(productTable == null){
            System.out.println("Table object not found");
            return null;
        }
        if(productTable.getSelectionModel().getSelectedIndex()!=-1){
            Product selectedProduct = productTable.getSelectionModel().getSelectedItem();
            System.out.println(selectedProduct.getId() + " " +
                    selectedProduct.getName() + " " +
                    selectedProduct.getPrice()
            );
            return selectedProduct;
        }
        else{
            System.out.println("Nothing selected");
            return null;
        }
    }

    public Pane getProductsByName(String searchName){

        TableColumn id = new TableColumn("Id");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn name = new TableColumn("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn price = new TableColumn("Price");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));




        ObservableList<Product> Items = Product.getProductsByName(searchName);

        productTable = new TableView<>();
        productTable.setItems(Items);
        productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        productTable.getColumns().addAll(id,name,price);
       // productTable.setMinSize(SupplyChain.width,SupplyChain.height);

        Pane tablePane = new Pane();
        //tablePane.setMinSize(SupplyChain.width, SupplyChain.height);
        tablePane.getChildren().add(productTable);
        return tablePane;
    }

}
