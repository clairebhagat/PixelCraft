package pixelcraft;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

 

public abstract class Converter {

    /**
     * Base class for all image converters.
     *
     * Handles loading the image from a file and saving the result.
     * Each subclass just needs to define how the image is modified.
    */

    public void convert(String input, String output) throws IOException{
        File inputFile = new File(input);
        BufferedImage originalImage = ImageIO.read(inputFile);
        BufferedImage processedImage = processImage(originalImage);

        File outputFile = new File(output);
        ImageIO.write(processedImage, "PNG", outputFile);
    }

    protected abstract BufferedImage processImage(BufferedImage originalImage);

}