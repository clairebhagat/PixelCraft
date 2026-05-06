import java.awt.image.BufferedImage;

public class RecursivePosterize extends Converter {

    /**
 * Posterizes the image using recursion.
 *
 * The number of colors is reduced by grouping values into ranges,
 * giving the image a more stylized look.
 */

    @Override
    protected BufferedImage processImage(BufferedImage inputImage) {

        int w = inputImage.getWidth();
        int h = inputImage.getHeight();

        // output image to store result
        BufferedImage outputImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        // process pixels recursively using a 1D index
        processPixels(inputImage, outputImage, 0,w* h);

        return outputImage;
    }

    private void processPixels(BufferedImage inputImage, BufferedImage outputImage, int start, int end) {

        // nothing left to process
        if (start >= end) {
            return;
        }

        // if we're down to one pixel, process it
        if (end - start == 1) {

            int w= inputImage.getWidth();

            // convert 1D index to 2D coordinates
            int x = start % w;
            int y = start / w;

            ARGB pixel = new ARGB(inputImage.getRGB(x, y));

            // reduce each color channel
            int r = reduceColor(pixel.red);
            int g = reduceColor(pixel.green);
            int b = reduceColor(pixel.blue);

            // write new pixel
            ARGB result = new ARGB(pixel.alpha, r, g, b);
            outputImage.setRGB(x, y, result.toInt());

            return;
        }

        // split the range into two halves
        int mid = (start + end) / 2;

        processPixels(inputImage, outputImage, start, mid);
        processPixels(inputImage, outputImage, mid, end);
    }

    private int reduceColor(int value) {
        // map value into one of a few fixed levels
        if (value < 70) {
            return 40;
        } 
        
        else if (value < 140) {
            return 110;
        } 
        
        else if (value < 200) {
            return 180;
        } 
        
        else {
            return 240;
        }
    }
}