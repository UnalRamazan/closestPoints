public class LinkedListNode {

    private Points point;
    private LinkedListNode next;

    public LinkedListNode(Points point) {
        this.setPoint(point);
        setNext(null);
    }

    public Points getPoint() {
        return point;
    }

    public void setPoint(Points point) {
        this.point = point;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }
}