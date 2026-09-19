class Solution {
    public boolean checkOverlap(int radius, int xC, int yC, int x1, int y1, int x2, int y2) {
        int closestX = 0 , closestY = 0;
        if(xC < x1){
            closestX = x1;
        } else if(xC > x2){
            closestX = x2;
        } else{
            closestX = xC;
        }

        if(yC < y1){
            closestY = y1;
        } else if(yC > y2){
            closestY = y2;
        } else{
            closestY = yC;
        }

        int dx = xC - closestX;
        int dy = yC - closestY;

        return (dx * dx) + (dy * dy) <= radius * radius;
    }
}