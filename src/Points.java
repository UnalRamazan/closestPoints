public class Points {

    private int x;
    private int y;
    private boolean candidatePoint;

    public Points(int cordX, int cordY) {
        this.setX(cordX);
        this.setY(cordY);
        this.candidatePoint = false;
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

    public boolean isCandidatePoint() {
        return candidatePoint;
    }

    public void setCandidatePoint(boolean candidatePoint) {
        this.candidatePoint = candidatePoint;
    }
}