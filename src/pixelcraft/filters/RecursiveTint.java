import java.awt.image.BufferedImage;
package pixelcraft.filters;


public class RecursiveTint extends Converter {

    /**
     * Applies a color tint using recursion.
     *
     * Pixels are processed one at a time, increasing red and slightly reducing
     * blue to give the image a tinted look.
     */

    @Override
    protected BufferedImage processImage(BufferedImage inputImage) {

        int w = inputImage.getWidth();
        int h = inputImage.getHeight();

        // create output image to store result
        BufferedImage outputImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        // start from top left corner
        tintPixel(inputImage, outputImage, 0, 0);

        return outputImage;
    }

    private void tintPixel(BufferedImage inputImage, BufferedImage outputImage, int x, int y) {

        int w = inputImage.getWidth();
        int h = inputImage.getHeight();

        // stop when we've processed all rows
        if (y >= h) {
            return;
        }

        // get current pixel color
        ARGB pixelColor = new ARGB(inputImage.getRGB(x, y));

        //  increase red slightly reduce blue
        int r = Math.min(255, pixelColor.red + 35);
        int g = pixelColor.green;
        int b = Math.max(0, pixelColor.blue - 15);

        // create new tinted pixel 
        ARGB tintedPixel = new ARGB(pixelColor.alpha, r, g, b);

        // write pixel to output image
        outputImage.setRGB(x, y, tintedPixel.toInt());

        // move to next pixel 
        if (x + 1 < w) {
            tintPixel(inputImage, outputImage, x + 1, y);
        } 
        
        else {
            tintPixel(inputImage, outputImage, 0, y + 1);
        }
    }
}