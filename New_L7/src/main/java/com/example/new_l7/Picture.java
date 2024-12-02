package com.example.new_l7;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Picture extends Application {
    private GraphicsContext gc;
    private double brushSize = 10.0;
    private double lastX = -1;  // Остання точка X
    private double lastY = -1;  // Остання точка Y

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(800, 500);
        gc = canvas.getGraphicsContext2D();
        drawInitialCanvas();

        // ScrollBar для зміни розміру пензля
        Label brushLabel = new Label("Розмір пензля:");
        ScrollBar brushSizeSelector = new ScrollBar();
        brushSizeSelector.setMin(5);
        brushSizeSelector.setMax(50);
        brushSizeSelector.setValue(brushSize);
        brushSizeSelector.setPrefWidth(200);
        brushSizeSelector.valueProperty().addListener((observable, oldValue, newValue) -> brushSize = newValue.doubleValue());

        // Створення бокової панелі
        VBox controlPanel = new VBox(10, brushLabel, brushSizeSelector);
        controlPanel.setPadding(new Insets(10));
        controlPanel.setStyle("-fx-background-color: #f0f0f0;");
        controlPanel.setPrefWidth(200);

        // Подія для малювання
        canvas.setOnMouseDragged(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                double currentX = e.getX();
                double currentY = e.getY();


                if (lastX != -1 && lastY != -1) {
                    gc.setFill(Color.BLACK);
                    double radius = brushSize / 2;
                    gc.fillOval(currentX - radius, currentY - radius, brushSize, brushSize);
                }

                // Оновлюємо останні координати
                lastX = currentX;
                lastY = currentY;
            }
        });

        // Повернення початкового стану при потрійному натисканні
        canvas.setOnMouseClicked(e -> {
            if (e.getClickCount() == 3) {
                drawInitialCanvas();
            }
        });

        BorderPane root = new BorderPane();
        root.setCenter(canvas);
        root.setLeft(controlPanel);

        Scene scene = new Scene(root, 1000, 600);
        stage.setTitle("L7");
        stage.setScene(scene);
        stage.show();
    }

    // Малюнок гриба
    private void drawInitialCanvas() {
        // Фон
        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(0, 0, 800, 600);

        // Шапка гриба
        gc.setFill(Color.BROWN);
        gc.fillArc(200, 200, 400, 200, 0, 180, javafx.scene.shape.ArcType.ROUND);

        // Стебло гриба
        gc.setFill(Color.PERU);
        gc.fillRoundRect(350, 300, 100, 200, 20, 20);

        // Плями на шапці гриба
        gc.setFill(Color.WHITE);
        gc.fillOval(300, 240, 30, 40);
        gc.fillOval(420, 235, 25, 30);
        gc.fillOval(370, 220, 15, 20);
        gc.fillOval(450, 230, 20, 20);

        // Скидаємо останні координати
        lastX = -1;
        lastY = -1;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
