package Museum;


import java.util.ArrayList;

public class OpenPosition extends Position {
    
    public int dist = -2;
    private ArrayList<Position> neigthbours = new ArrayList<>();
    public Position mLeft = null, mRigrt = null, mTop = null, mDown = null;
    
    public OpenPosition(int x, int y) {
        super(x, y);
//      this.dist = getDist();
    }
    
    @Override
    public void evaluate(Position[][] museum) {
        // set List of neigthbours
        setNeigthbours(museum);
        
        int mindist = Integer.MAX_VALUE;
        for (Position p: neigthbours) {
            if (p instanceof Guard) {
            	mindist = 0;
            }
            
            if (p instanceof OpenPosition) {
            	int tmpDist = ((OpenPosition) p).dist;
            	if (tmpDist == -2) {
            		continue;
            	}
            	if (tmpDist < mindist) {
            		mindist = tmpDist;
            	}
            }
        }
        this.dist = mindist+1;
    }
    
    private void setNeigthbours(Position[][] museum) {
    	if (this.x  > 0) {
            neigthbours.add(museum[x-1][y]);
        }
        if (this.x < museum.length-2) {
            neigthbours.add(museum[x+1][y]);
        }
        if (this.y  > 0) {
            neigthbours.add(museum[x][y-1]);
        }
        if (this.y < museum.length-2) {
            neigthbours.add(museum[x][y+1]);
        }
    }
    
// 	public void checkNeigth(Position[][] museum) {
//		for (Position p: neigthbours) {
//			if (p instanceof OpenPosition) {
//				int tmpDist = ((OpenPosition) p).dist;
//				if ( tmpDist > 0 && (this.dist - tmpDist) >1) {
//					System.out.println("ddd");
//					this.dist = tmpDist+1;
//				}
//			}
//		}
//	}
    
}