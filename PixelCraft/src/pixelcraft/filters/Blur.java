import java.awt.image.BufferedImage;

public class Blur extends Converter {

    /**
     * Blurs the image.
     *
     * Each pixel is replaced with the average of nearby pixels, which smooths
     * out details and makes the image look softer.
     */

    @Override
    protected BufferedImage processImage(BufferedImage originalImage) {
        int w = originalImage.getWidth();
        int h = originalImage.getHeight();

        BufferedImage newImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {

                int sumR = 0, sumG = 0, sumB = 0, count = 0; // keep track of colour sums

                // loop through neighboring pixels 10x10
                for (int x2 = -5; x2 <= 4; x2++){
                    for (int y2 = -5; y2 <= 4; y2++){
                        int new_y = y+y2;
                        int new_x = x+x2;
                        

                        // make sure neighbouring pixels are not out of bounds
                        if (new_x >= 0 && new_x < w && new_y >= 0 && new_y < h) {
                            ARGB c = new ARGB(originalImage.getRGB(new_x, new_y));

                            // add colours to accumulating pixel sum. 
                            sumR += c.red;
                            sumB += c.blue;
                            sumG += c.green;
                            
                            count++;
                        }
                    }
                }

                // average RGB values
                int avgR = sumR / count;
                int avgG = sumG / count;
                int avgB = sumB / count;

                ARGB blurred = new ARGB(255, avgR, avgG, avgB); // set new colour val to a combo of those colour vals. (blurred)
                newImage.setRGB(x, y, blurred.toInt());
            }
        }

        return newImage;
    }
}