# PixelCraft

A Java command-line Image processing application that applies different visual effects to PNG images. Built this for my OOP class. The project focuses on manipulating individual pixels using Java’s `BufferedImage` class and OOP concepts.

## How It Works

The application is run from the terminal using the converter name and the input image file. PixelCraft then creates an output image automatically named using the original filename plus the converter name.

Example:

```bash
java -cp "out/production/Project1" PixelCraft Grayscale toronto.png
```

This produces:

```bash
toronto_Grayscale.png
```

## Project Structure

```text
PixelCraft/
├── PixelCraft.java
├── Converter.java
├── ARGB.java
├── Grayscale.java
├── Rotate.java
├── Blur.java
└── images/
```

## Main Components

### `PixelCraft.java`

This is the entry point of the program. It reads command-line arguments, determines which converter class to use, and calls the selected converter on the input image.


### `Converter.java`

The abstract base class for all image converters. It defines the common structure used by every converter, such as reading the input image, processing it, and saving the output image.

### `ARGB.java`

A helper class used to separate a pixel’s color into its alpha, red, green, and blue values. It also converts those values back into a single integer pixel value.

### Converter Classes

Each converter extends the `Converter` class and implements its own image processing logic.

Examples:

- Grayscale 
- Rotate 
- Blur 
- Invert 
- Mirror 
- Sepia 
- Threshold 
- RecursiveTint 
- RecursivePosterize 


## Concepts Used

This project demonstrates:

- OOP in Java
- Recursion
- Image processing
- Working with `BufferedImage`