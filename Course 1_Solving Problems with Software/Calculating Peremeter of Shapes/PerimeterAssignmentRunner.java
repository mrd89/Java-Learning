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

    public int getNumPoints (Shape s) {
        // Put code here
        int pts = 0;
        
        for (Point p: s.getPoints()){
            pts ++;
        }
        return pts;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        int npoints = getNumPoints(s);
        double perimeter = getPerimeter(s);
        return perimeter / npoints;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        Point prevPt = s.getLastPoint();
        double distMax = 0.0;
        
        for (Point p : s.getPoints()){
            double dist = prevPt.distance(p);

            if (dist > distMax) {distMax = dist;}
        }
        return distMax;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double xMax = 0.0;
        
        for (Point P : s.getPoints()){
            double currX = P.getX();
            if (currX > xMax) {xMax = currX;}
        }
        return xMax;
    }

    public double getLargestPerimeterMultipleFiles() {
        // get selected files
        DirectoryResource dr = new DirectoryResource();
        double maxPerimeter =  0.0;
        
        // loop through all files
        for (File f : dr.selectedFiles()) {
            
            // create file resource
            FileResource fr = new FileResource(f);
            
            // create shape from file
            Shape s = new Shape(fr);
            
            // find perimeter
            double currPerimeter = getPerimeter(s);
            
            if (currPerimeter>maxPerimeter){ 
                maxPerimeter = currPerimeter;
            }
            
            
        }
        
        return maxPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        // get selected files
        DirectoryResource dr = new DirectoryResource();
        double maxPerimeter =  0.0;
        File max = null;
        
        // loop through all files
        for (File f : dr.selectedFiles()) {
            
            // create file resource
            FileResource fr = new FileResource(f);
            
            // create shape from file
            Shape s = new Shape(fr);
            
            // find perimeter
            double currPerimeter = getPerimeter(s);
            
            if (currPerimeter>maxPerimeter){ 
                maxPerimeter = currPerimeter;
                max = f;
            }
            
            
        }
        

        return max.getName();
    }

    public void testPerimeter () {
        // Gets file and creates shape
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        
        // get and output perimeter
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        
        // get and output number of points
        int npoints = getNumPoints(s);
        System.out.println("There are " + npoints + " points");
        
        // get and output average side length
        double aveLength = getAverageLength(s);
        System.out.println("Average side length = " + aveLength);
        
        // get and output max side length
        double maxSideLength = getLargestSide(s);
        System.out.println("The longest side length = " + maxSideLength);
        
        // get and output largest x point
        double xMax = getLargestX(s);
        System.out.println("Largest x coordinate is: " + xMax);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double maxPerim = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter of selected files: " + maxPerim);
        
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        System.out.println("File with largest perimeter: "+getFileWithLargestPerimeter());
        
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
