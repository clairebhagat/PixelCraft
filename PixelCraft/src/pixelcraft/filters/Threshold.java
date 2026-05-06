import java.awt.image.BufferedImage;

public class Threshold extends Converter {

    /**
     * Converts the image to black and white.
     *
     * Each pixel becomes either black or white depending on how bright it is.
     */


    @Override
    protected BufferedImage processImage(BufferedImage originalImage) {
        int w = originalImage.getWidth();
        int h = originalImage.getHeight();

        BufferedImage newImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);


        // loop through each pixel
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                int val = 0;
                ARGB colour = new ARGB(originalImage.getRGB(x, y)); // get og colour vals

                int avg = (colour.red + colour.green + colour.blue) / 3; // get the avg colour of each pixel

                if (avg >= 128) { // if combined colour is lighter, convert to white, otherwise keep pixel black. 
                    val = 255;
                } 

                ARGB blackOrWhite = new ARGB(colour.alpha, val, val, val); // set either black or white pixel colour. 
                newImage.setRGB(x, y, blackOrWhite.toInt()); 
            }
        }

        return newImage;
    }
}