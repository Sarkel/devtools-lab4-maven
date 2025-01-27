package pl.edu.wszib.student.kubalski.lab6_maven;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.edu.wszib.student.kubalski.lab6_maven.routing.Route;
import pl.edu.wszib.student.kubalski.lab6_maven.routing.RouteService;
import pl.edu.wszib.student.kubalski.lab6_maven.services.config.AppPropertiesService;


public class SchoolHelperApplication extends Application {
    private ConfigurableApplicationContext springContext;

    private RouteService routeService;

    private AppPropertiesService appPropertiesService;

    @Override
    public void init() {
        springContext = SpringApplication.run(SpringBootConfig.class);
        routeService = springContext.getBean(RouteService.class);
        appPropertiesService = springContext.getBean(AppPropertiesService.class);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World");
        primaryStage.setResizable(true);
        primaryStage.setWidth(appPropertiesService.getWidth());
        primaryStage.setHeight(appPropertiesService.getHeight());

        routeService.setPrimaryStage(primaryStage);
        routeService.switchScene(Route.SCHOOL_CLASS_LIST);
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
