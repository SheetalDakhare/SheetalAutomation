import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class TextToImage {

    public static void main(String[] args) {
        String text = "Hello, World!";
        String outputFilePath = "text-image.png";

        // Set image size and font
        int width = 400;
        int height = 100;
        Font font = new Font("Arial", Font.PLAIN, 24);

        // Create a BufferedImage
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        // Enable anti-aliasing for better text quality
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Set background color and clear the image
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        // Set text color and font
        g2d.setColor(Color.BLACK);
        g2d.setFont(font);

        // Calculate position to center the text
        FontMetrics fm = g2d.getFontMetrics();
        int x = (width - fm.stringWidth(text)) / 2;
        int y = ((height - fm.getHeight()) / 2) + fm.getAscent();

        // Draw the text
        g2d.drawString(text, x, y);

        // Clean up
        g2d.dispose();

        // Write the image to a file
        try {
            ImageIO.write(image, "png", new File(outputFilePath));
            System.out.println("Image saved to: " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
