import java.io.FileWriter;
import java.io.IOException;

public class Mojix {
    public static void main(String[] args) {
        int width = 512; // Image width
        int height = 512; // Image height
        int redColor = 255; // Value for the red component in RGB color

        try {
            // Open an output file to write the image in PPM format
            FileWriter writer = new FileWriter("mojix.ppm");

            // Write the PPM file header
            writer.write("P3\n"); // PPM file type
            writer.write(width + " " + height + "\n"); // Image width and height
            writer.write(255 + "\n"); // Maximum color component value

            int squareSize = width / 3; // Size of squares dividing the image
            double circleRadius = squareSize * 0.37; // Radius of the circle

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int partX = x / squareSize; // Number of the horizontal part the point is in
                    int partY = y / squareSize; // Number of the vertical part the point is in

                    boolean isEvenPosition = (partX + partY) % 2 == 0; // Check if the position is even or odd

                    int centerX = (partX * squareSize) + (squareSize / 2); // X coordinate of the center of the current circle
                    int centerY = (partY * squareSize) + (squareSize / 2); // Y coordinate of the center of the current circle
                    double distance = Math.sqrt((x - centerX) * (x - centerX) + (y - centerY) * (y - centerY)); // Distance from the point to the center

                    if (!isEvenPosition) { // If the position is odd
                        if (distance <= circleRadius) {
                            writer.write(redColor + " " + 170 + " " + 170 + " "); // Red color for the circle
                        } else {
                            writer.write(255 + " " + 255 + " " + 255 + " "); // White background
                        }
                    } else { // If the position is even
                        if (distance <= circleRadius) {
                            writer.write(255 + " " + 0 + " " + 0 + " "); // Red color for the circle
                        } else {
                            writer.write(255 + " " + 255 + " " + 255 + " "); // White background
                        }
                    }
                }
                writer.write("\n"); 
            }

            writer.close();
            System.out.println("Image Mojix generated successfully."); 
        } catch (IOException e) {
            System.out.println("An error occurred."); 
            e.printStackTrace(); 
        }
    }
}
