package com.example.comp1011st200496640lab8;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class NetflixTableController implements Initializable {

    @FXML
    private TableColumn<Netflix, String> castColumn;

    @FXML
    private TableColumn<Netflix, String> directorColumn;

    @FXML
    private CheckBox movieCheckBox;

    @FXML
    private Label numLabel;

    @FXML
    private ComboBox<String> selectRatingComboBox;

    @FXML
    private TableColumn<Netflix, Integer> showIdColumn;

    @FXML
    private TableColumn<Netflix, String> titleColumn;

    @FXML
    private TableColumn<Netflix, String> ratingColumn;

    @FXML
    private CheckBox tvShowCheckBox;

    @FXML
    private TableColumn<Netflix, String> typeColumn;
    @FXML
    private TableView<Netflix> tableView;
    private ArrayList<Netflix> allShows;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        castColumn.setCellValueFactory(new PropertyValueFactory<>("cast"));
        directorColumn.setCellValueFactory(new PropertyValueFactory<>("director"));
        showIdColumn.setCellValueFactory(new PropertyValueFactory<>("showId"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));

        tableView.getItems().addAll(DBUtility.getShowsFromDB());

        selectRatingComboBox.getItems().addAll(DBUtility.getRatingFromDB());
        movieCheckBox.setSelected(true);
        tvShowCheckBox.setSelected(true);


        allShows = DBUtility.getShowsFromDB();

//        selectRatingComboBox.valueProperty().addListener((obs, oldValue, ratingSelected) -> {
//            tableView.getItems().clear();
//            for (Netflix show : allShows) {
//                if (show.getRating().equals(ratingSelected)) {
//                    tableView.getItems().add(show);
//
//                }
//            }
//            numLabel.setText("The number of shows is: " + tableView.getItems().size());
//        });
        numLabel.setText("The number of shows is: " + tableView.getItems().size());
    }

    @FXML
    private void filter() {

        tableView.getItems().clear();
        for (Netflix show : allShows) {

            if (movieCheckBox.isSelected() && show.getType().equals(movieCheckBox.getText())) {
                if( show.getRating().equals(selectRatingComboBox.getValue())){
                    tableView.getItems().add(show);
                    numLabel.setText("Number of shows: " + tableView.getItems().size());
                }
                else{
                    tableView.getItems().add(show);
                }
//                tableView.getItems().add(show);
//                numLabel.setText("Number of shows: " + tableView.getItems().size());
            }
            if (tvShowCheckBox.isSelected() && show.getType().equals(tvShowCheckBox.getText())) {

                if( show.getRating().equals(selectRatingComboBox.getValue())){
                    tableView.getItems().add(show);
                    numLabel.setText("Number of shows: " + tableView.getItems().size());
                }
                else{
                    tableView.getItems().add(show);
                }
//                tableView.getItems().add(show);
//                numLabel.setText("Number of shows: " + tableView.getItems().size());
            } else {
                numLabel.setText("Number of shows: " + tableView.getItems().size());
            }
        }
    }
}

