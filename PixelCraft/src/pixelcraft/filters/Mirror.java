import java.awt.image.BufferedImage;

public class Mirror extends Converter {

    /**
     * Mirrors the image horizontally.
     *
     * The image is flipped left to right like a reflection.
     */

    @Override
    protected BufferedImage processImage(BufferedImage originalImage) {
        
        int w = originalImage.getWidth();
        int h = originalImage.getHeight();

        BufferedImage newImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        // loop through each pixel
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int pixel_val = originalImage.getRGB(x, y); 
                int new_X = w - 1 - x; // mirror the width pixel 
                newImage.setRGB(new_X, y, pixel_val); // set new X value on new image
            }
        }

        return newImage;
    }
}