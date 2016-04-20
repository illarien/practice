package Quizes.Arrays;

public class GoogleServiceMachine {

}


static class ServiceArm {
    // Size of the grid.
    //final int width, height;
    // The current position.
    int posX, posY;
    // Returns true if the arm actually moved and posX/posY is updated.
    // No need to implement.
    boolean moveUp() {return true;};
    boolean moveDown() {return true;};
    boolean moveRight() {return true;}; 
    bolean moveLeft();
    
    // Service the machine at the current position. No need to implement.
    void serviceMachine();

    // This is the method to be implemented. Need to implement.
    void serviceGrid() {
        int r=0,d=0;
        int vLow=0, vHigh-0, hLow=0, hHigh=0;
while (true) {        
serviceMachine();
            while (moveRight() ) {
                serviceMachine();
r++;                
            }
while (moveDown()) {
                serviceMachine();
                d++;
            }
while (moveLeft()) {
                serviceMachine();
                r--;
            }
while (moveUp()) {
                serviceMachine();
                d--;
            }
        
        }
    }
}


ServiceArm serviceArm = new ServiceArm();
serviceArm.serviceGrid();


void serviceGrid(int width, int height) {
    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
            serviceMachine();
            moveRight();
        }
        moveDown();
        moveToStartAndService(width);
    }
}

void moveToStartAndService(width) {
    for(int i = width; i>=0; i--) {
serviceMachine();
        moveLeft();
}
}

/*
X(0,0)
X 
1
2
5
4
3
6
7
8
11
10
9

Imagine there is a grid of X by Y machines and a robotic arm that moves on the grid one cell at a time. Implement the a service method that goes through every machine and services them. The initial position of the arm is 0,0.

The arm has the following API:
public class ServiceArm {
    // Size of the grid.
    final int width, height;

    // The current position.
    int posX, posY;

    // Returns true if the arm actually moved and posX/posY is updated.
    // No need to implement.
    boolean moveUp();
    boolean moveDown();
    boolean moveRight(); 
boolean moveLeft();

    // Service the machine at the current position. No need to implement.
    void serviceMachine();

    // This is the method to be implemented. Need to implement.
    void serviceGrid() {
        int r=0,d=0;
        int vLow=0, vHigh-0, hLow=0, hHigh=0;
while (true) {        
serviceMachine();
            while (moveRight() ) {
                serviceMachine();
r++;                
            }
while (moveDown()) {
                serviceMachine();
                d++;
            }
while (moveLeft()) {
                serviceMachine();
                r--;
            }
while (moveUp()) {
                serviceMachine();
                d--;
            }
        
        }
    }
}


ServiceArm serviceArm = new ServiceArm();
serviceArm.serviceGrid();


void serviceGrid(int width, int height) {
    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
            serviceMachine();
            moveRight();
        }
        moveDown();
        moveToStartAndService(width);
    }
}

void moveToStartAndService(width) {
    for(int i = width; i>=0; i--) {
serviceMachine();
        moveLeft();
}
}
*/
