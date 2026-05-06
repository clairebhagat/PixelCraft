import java.awt.image.BufferedImage;

public class Rotate extends Converter {

    /**
     * Rotates the image 90 degrees clockwise.
     *
     * Pixels are moved to new positions so the image turns while keeping
     * the same colors.
     */

    @Override
    protected BufferedImage processImage(BufferedImage originalImage) {

        int w = originalImage.getWidth();
        int h = originalImage.getHeight();

        BufferedImage newImage = new BufferedImage(h, w, BufferedImage.TYPE_INT_ARGB); // swap height and width vals.

        // loop through each pixel
        for (int x = 0; x < w; x++) { 
            for (int y = 0; y < h; y++) {
                int pixel = originalImage.getRGB(x, y); // get original colour value

                // flip y-axis and swap coordinates to rotate image clockwise.
                int newX = h - 1 - y; 
                int newY = x;

                newImage.setRGB(newX, newY, pixel); // set new x and y cors on new image
            }
        }

        return newImage;
    }
}