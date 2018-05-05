package edu.toronto.csc301;

public class BasicRobot implements IBasicRobot {
	double x,y;
	int rotation;
	//constructor as per SetupTest.java
	public BasicRobot(double X, double Y, int rot) throws IllegalArgumentException {
		if(rot >= 360 || rot < 0){
			throw new IllegalArgumentException();
		}
	    this.x = X;
		this.y = Y;
		this.rotation = rot;
	}
	public double getXCoordinate(){
		return this.x;
	}
	public double getYCoordinate(){
		return this.y;
	}
	public int getRotation(){
		return this.rotation;
	}
	public void rotateRight(int degrees){
		//modulus because we want to keep it within 360 degrees
	     this.rotation = (this.rotation + degrees)%360;
	     if(this.rotation < 0){
	    	 this.rotation = this.rotation + 360;
	     }
	}
	public void rotateLeft(int degrees){
		//similar logic except we subtract(opposite direction)
		  this.rotation = (this.rotation - degrees)%360;
	      if(this.rotation < 0){
	    	 this.rotation = this.rotation + 360;
	      }
	}
	public void moveForward(int millimeters){
		this.x = this.x + Math.sin(Math.toRadians(this.rotation)) * millimeters;
		this.y = this.y + Math.cos(Math.toRadians(this.rotation)) * millimeters;
			
	}
}
