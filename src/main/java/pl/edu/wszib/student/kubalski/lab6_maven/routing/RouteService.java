package pl.edu.wszib.student.kubalski.lab6_maven.routing;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.net.URL;

@Service
@RequiredArgsConstructor
public class RouteService {
    @Setter
    private Stage primaryStage;

    private final ApplicationContext applicationContext;

    // todo: change params to be more generic
    @Getter
    private Long params;

    public void switchScene(Route route) {
        switchScene(route, null);
    }

    public void switchScene(Route route, Long params) {
        if (params != null) {
            this.params = params;
        }
        try {
            URL sceneLocation = getClass().getResource("/fxml/" + route.getViewName());
            FXMLLoader loader = new FXMLLoader(sceneLocation);
            loader.setControllerFactory(applicationContext::getBean);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setTitle(route.getTitle());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception ignored) {
            System.err.println("Scene not found: " + route.name());
        }
    }
}
