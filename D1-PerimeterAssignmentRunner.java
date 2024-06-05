import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

   
        // Put code here:- this method should return the number of type double that is the calculated average of all the sides’ lengths in the Shape S.
public int getNumPoints(Shape s) {
    int points = 0;
    for (Point p : s.getPoints()) {
        points=points+1;
    }
    return points;
    }
    

    public double getAverageLength(Shape s) {
        // Put code here:-This method should return the average length of the shape.
        double totalPerim = getPerimeter(s);
        int numPoints = getNumPoints(s);
        return (double)totalPerim / numPoints;
    }

    public double getLargestSide(Shape s) {
        // Put code here:- This method should return the largest side of the shape
        double largestSide=0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
        double currDist = prevPt.distance(currPt);
        if (currDist > largestSide) {
            largestSide = currDist;
        }
        prevPt = currPt;
    }
    return largestSide;
    }

    

    public double getLargestX(Shape s) {
        // Put code here:- This method should return the x coordinate of the point with the largest x coordinate
        double largestX = 0;
        for (Point p : s.getPoints()) {
            double currX = p.getX();
            if (currX > largestX) {
                largestX = currX;
            }
        }
        return largestX;   
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here:- This method should return the largest perimeter of any shape in the file
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0.0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPerim = getPerimeter(s);
            if (currPerim > largestPerim) {
                largestPerim = currPerim;
            }
        }
        return largestPerim;
    }


    public String getFileWithLargestPerimeter() {
        // Put code here
    DirectoryResource dr = new DirectoryResource();
        File largestFile = null;
        double largestPerim = 0.0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPerim = getPerimeter(s);
            if (currPerim > largestPerim) {
                largestPerim = currPerim;
                largestFile = f;
            }
        }
        return largestFile.getName();
    }
    

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        //add code here to call getNumPoints and to print the result.
        int num = getNumPoints(s);
        System.out.println("The number of points of the shape are = " + num);
        //add code here to call the method getAverageLength and to print out the result. 
        double average_length=getAverageLength(s);
        System.out.println("The average length of the shape is = " + average_length);
        //add code here to call the method getLargestSide and to print out the result.
        double largest_side=getLargestSide(s);
        System.out.println("The largest side of the shape is = " + largest_side);
        //add code here to call the method getLargestX and to print out the result.
        double largest_x=getLargestX(s);
        System.out.println("The largest x coordinate of the shape is = " + largest_x);
        //add code here to call the method getLargestPerimeterMultipleFiles and to print out the result.
        double largest_perimeter=getLargestPerimeterMultipleFiles();
        System.out.println("The largest perimeter of any shape in the file is = " + largest_perimeter);
        //add code here to call the method getFileWithLargestPerimeter and to print out the result.
        String largest_file=getFileWithLargestPerimeter();
        System.out.println("The file with the largest perimeter is = " + largest_file);



    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
