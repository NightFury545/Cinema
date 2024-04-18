package org.nightfury.presentation.GUIstarter;

import atlantafx.base.theme.PrimerDark;
import java.sql.SQLException;
import java.util.List;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.nightfury.business_logic.service.serviceImpl.MovieServiceImpl;
import org.nightfury.persistence.entity.entityImpl.Movie;

public class AppGUI extends Application {

    @Override
    public void start(Stage stage) {
        Application.setUserAgentStylesheet(new PrimerDark().getUserAgentStylesheet());
        FlowPane flowPane = new FlowPane();
        Scene scene = new Scene(flowPane, 500, 500);
        stage.setTitle("JavaFXMavenCRUD");
        stage.setScene(scene);
        stage.show();
        new Thread(() -> {
            MovieServiceImpl movieService = null;
            try {
                movieService = new MovieServiceImpl();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            List<Movie> movies = movieService.findAll();

            for (var movie : movies) {
                Button button = new Button();
                button.setStyle("-fx-min-height: 50px; -fx-min-width: 100px");
                button.setText(movie.getName());
                Platform.runLater(() -> flowPane.getChildren().add(button));
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    public void launchGUI() {
        launch();
    }
}
