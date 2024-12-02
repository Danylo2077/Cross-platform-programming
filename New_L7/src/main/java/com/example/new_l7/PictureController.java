package com.example.new_l7;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollBar;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseButton;

public class PictureController {

    @FXML
    private Canvas canvas;

    @FXML
    private ScrollBar brushSizeSelector;

    private GraphicsContext gc;
    private double brushSize = 10.0;
    private double lastX = -1;  // Остання точка X
    private double lastY = -1;  // Остання точка Y

    @FXML
    public void initialize() {
        // Ініціалізація GraphicsContext для малювання на Canvas
        gc = canvas.getGraphicsContext2D();
        drawInitialCanvas();

        // Налаштування ScrollBar для зміни розміру пензля
        brushSizeSelector.setMin(5);
        brushSizeSelector.setMax(50);
        brushSizeSelector.setValue(brushSize);
        brushSizeSelector.setPrefWidth(200);
        brushSizeSelector.valueProperty().addListener((observable, oldValue, newValue) -> brushSize = newValue.doubleValue());

        // Обробник події для малювання
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
    }

    // Малюнок гриба
    private void drawInitialCanvas() {
        // Фон
        clearCanvas();
        // Шапка гриба
        drawMushroomCap();
        // Стебло гриба
        drawMushroomStem();
        // Плями на шапці гриба
        drawMushroomSpots();
    }


    private void clearCanvas() {
        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(0, 0, 800, 600);
    }

    // Шапку гриба
    private void drawMushroomCap() {
        gc.setFill(Color.BROWN);
        gc.fillArc(200, 200, 400, 200, 0, 180, javafx.scene.shape.ArcType.ROUND);
    }

    // Стебло гриба
    private void drawMushroomStem() {
        gc.setFill(Color.PERU);
        gc.fillRoundRect(350, 300, 100, 200, 20, 20);
    }

    // Плями на шапці гриба
    private void drawMushroomSpots() {
        gc.setFill(Color.WHITE);
        gc.fillOval(300, 240, 30, 40);
        gc.fillOval(420, 235, 25, 30);
        gc.fillOval(370, 220, 15, 20);
        gc.fillOval(450, 230, 20, 20);
    }
}
