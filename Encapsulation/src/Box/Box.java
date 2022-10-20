package Box;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        checkForIllegalArgument(length, "Length");
        this.length = length;
    }

    private void setWidth(double width) {
       checkForIllegalArgument(width, "Width");
        this.width = width;
    }

    private void setHeight(double height) {
        checkForIllegalArgument(height, "Height");
        this.height = height;
    }

    public double calculateSurfaceArea() {
        return 2*width*height + 2*length*height + 2*width*length;
    }

    public double calculateLateralSurfaceArea() {
        return 2*width*height + 2*length*height;
    }

    public double calculateVolume() {
        return width*height*length;
    }

    private void checkForIllegalArgument (double argument, String argumentType) {
        if (argument <= 0) {
            throw new IllegalArgumentException(String.format("%s cannot be zero or negative.", argumentType));
        }
    }
}
