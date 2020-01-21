//Author Name: Antonela Beca
//Date: 1/18/2020
//Program Name: Beca_Drone
//Program Name: Smith_Drone
//Purpose: Simulation using button, drone movement in x, y,z location
import java.util.Scanner;
public class Beca_Drone {
    // declaring the coordinate variables
    private int x, y, z;
    private int dir; // orientation by number - 0 is North, 1 is East, 2 is South, 3 is West; clockwise
	String s; //assigning the name of the orientation number 
	private static Scanner ui;

   // constructor initializing a drone in point 0, direction North
   public Beca_Drone() {
        x = 0;
        y = 0;
        z = 0;
        dir = 0; 
      }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;     
    }        
    
    public String getS() {
            return s;
    }

    public void setS(String s) {
            this.s = s;
    }

    // method for move up; orientation does not matter
    public void Up() {
    	z ++;
    }

    // method for move down; orientation does not matter
    public void Down() {
        z --;
    }

    // method to move forward
    public void Forward() {       
    	if (dir == 0) {    
             y ++;  // moving north means moving up on the Y axis
        } else if (dir == 1) {
             x ++; // moving east means moving up on the X axis
        } else if (dir == 2) {
             y --; // moving south means moving down on the Y axis
        } else {
             x --; // moving west means moving down on the X axis
        }
    }

    // method for move backward
    public void Backward() {
        if (dir == 0) {
            y --; // when direction is North, backwards means South
        } else if (dir == 1) {
            x --; // when direction is East, backwards means West
        } else if (dir == 2) {
        	y ++;  // when direction is South, backwards means North
        } else {
            x ++;  // when direction is West, backwards means East
        }
    }

    // method to turn the drone to the right; add one then the remainder when divided by 4 will be between 0 and 3 which will maintain the range of our directions
    public void turnRight() {
        dir = (dir + 1) % 4;
    }

    // method to turn drone to the left; if it becomes negative, that means the value can be replaced with 3
    public void turnLeft() {
        dir--;
        if (dir < 0) {
             dir = 3;
       }
    }

    //assigning the correct names to the values in the direction range 
    public String or() 
    {
    	if (dir % 4 == 0)
    	s = "North";
    	else if (dir % 4 == 1)
    	s = "East";
    	else if (dir % 4 == 2)
    	s= "South";
    	else if (dir % 4 == 3)
    	s = "West";
   return s;
    }

    // method for returning drone's position
    public String toString() {
        return "Student_Drone [x_pos=" + x + ", y_pos=" + y + ", z_pos=" + z + ", direction = " + or() + "]";
    }

    public static void main(String[] args) {
        // creating a Drone
        Beca_Drone drone = new Beca_Drone();
        //setting up a scanner
        ui = new Scanner(System.in);
        String in = "";
        //until the user inputs the selection 8 - Exit Navigation the program will prompt the user to make a selection and displaying the menu
        while (!in.equalsIgnoreCase("8")) {
             // display the menu
          System.out.println("Which direction would you like to move your drone? \n1 - Move Up\n2 - Move Down\n3 - Move Forward\n4 - Move Backward\n5 - Turn Left\n6 - Turn Right\n7 - Display Position\n8 - Exit Navigation");
             // user input choice
          in = ui.nextLine();
          if (in.equalsIgnoreCase("1")) {
                 drone.Up();
                 System.out.println("You moved up.");
             } else if (in.equalsIgnoreCase("2")) {
                 drone.Down();
                 System.out.println("You moved down.");
             } else if (in.equalsIgnoreCase("3")) {
                 drone.Forward();
                 System.out.println("You moved forward.");
             } else if (in.equalsIgnoreCase("4")) {
                 drone.Backward();
                 System.out.println("You moved backward.");
             } else if (in.equalsIgnoreCase("5")) {
                drone.turnLeft();
                System.out.println("You turned left.");
             } else if (in.equalsIgnoreCase("6")) {
                 drone.turnRight();
                 System.out.println("You turned right.");
             }else if (in.equalsIgnoreCase("7")) {
            	 System.out.println(drone);
             }
        }
    }
}
