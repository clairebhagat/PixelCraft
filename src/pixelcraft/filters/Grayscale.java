import java.awt.image.BufferedImage;
package pixelcraft.filters;


public class Grayscale extends Converter {

    /**
     * Converts the image to grayscale.
     *
     * Each pixel is turned into a shade of gray by averaging its RGB values.
     */

    @Override
    protected BufferedImage processImage(BufferedImage originalImage) {

        // get height and width in pixels of image
        int w = originalImage.getWidth();
        int h = originalImage.getHeight();

        // create copy of image 
        BufferedImage newImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);


        // loop through each pixel
        for (int x = 0; x < w; x++) { 
            for (int y = 0; y < h; y++) {
                int pixel = originalImage.getRGB(x, y); // extract pixel colour from OG image
                ARGB pixelColour = new ARGB(pixel); // cast colour to ARGB type 

                int gray = computeGray(pixelColour); // change colour to grayscale val.

                ARGB grayPixel = new ARGB(pixelColour.alpha, gray, gray, gray); // create new pixel with that shade of gray 
                newImage.setRGB(x, y, grayPixel.toInt()); // set pixel colour val to that shade of gray on new image
            }
        }

        return newImage;
    }

    private int computeGray(ARGB c) {
        int sum = (c.red + c.green + c.blue) / 3; // the avg of the RGB values of a pixel returns a shade of gray
        return sum;
    }  
}