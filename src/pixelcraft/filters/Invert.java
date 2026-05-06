import java.awt.image.BufferedImage;
package pixelcraft.filters;



public class Invert extends Converter {

    /**
     * Inverts the colors of the image.
     *
     * Each color value is flipped (255 - value), creating a negative effect.
     */

    @Override
    protected BufferedImage processImage(BufferedImage originalImage) {
        
        int w = originalImage.getWidth();
        int h = originalImage.getHeight();

        BufferedImage newImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        // loop through each pixel
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {

                ARGB colour = new ARGB(originalImage.getRGB(x, y)); 

                // get inverted values of colour filters
                int newRed = 255 - colour.red; 
                int newGreen = 255 - colour.green;
                int newBlue = 255 - colour.blue;


                ARGB inverted = new ARGB(colour.alpha, newRed, newGreen, newBlue); // apply new values here
                newImage.setRGB(x, y, inverted.toInt()); // set values to new image
            }
        }

        return newImage;
    }
}