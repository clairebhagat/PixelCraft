import java.awt.image.BufferedImage;

public class Sepia extends Converter {
    /**
     * Applies a sepia (vintage) effect to the image.
     *
     * The colors are adjusted to give a warm, brownish tone similar to old photos.
     */

    @Override
    protected BufferedImage processImage(BufferedImage originalImage) {
        int w = originalImage.getWidth();
        int h = originalImage.getHeight();

        BufferedImage newImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        // loop thru each pixel
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                ARGB colour = new ARGB(originalImage.getRGB(x, y));

                // sepia leans more on the red and blue side. Multiply by heavier weights to make red and blue more prominent
                int newRed   = (int) (0.4 * colour.red + 0.75 * colour.green + 0.2 * colour.blue);
                int newGreen = (int) (0.35 *colour.red+ 0.65 *colour.green+ 0.15 * colour.blue);
                int newBlue  = (int) (0.25 * colour.red+ 0.5 *colour.green+ 0.1 * colour.blue);

                // stop values from going a colour above 255
                int r = Math.min(255, newRed);
                int g  = Math.min(255, newGreen);
                int b = Math.min(255, newBlue);


                ARGB sepia = new ARGB(colour.alpha, r, g, b); // set new colour vals
                newImage.setRGB(x, y, sepia.toInt());
            }
        }

        return newImage;
    }
}