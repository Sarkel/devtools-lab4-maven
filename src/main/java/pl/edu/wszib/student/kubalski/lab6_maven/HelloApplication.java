package pl.edu.wszib.student.kubalski.lab6_maven;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

public class HelloApplication extends Application {
    private ConfigurableApplicationContext springContext;

    @Override
    public void init() {
        springContext = SpringApplication.run(SpringBootConfig.class);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        fxmlLoader.setControllerFactory(springContext::getBean);
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        springContext.close();
        Platform.exit();
    }

    public static void main(String[] args) {
        launch();
    }
}
