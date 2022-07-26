public class LinkedListOperations {

    public LinkedListNode head;

    public LinkedListOperations() {
        head = null;
    }

    public LinkedListNode getHead() {
        return head;
    }

    public void add(Points point) {//sona ekledim
        LinkedListNode newNode = new LinkedListNode(point);

        if (comparison(point)) {
            if (head == null) {
                head = newNode;
                head.setNext(null);
            } else {
                LinkedListNode walk = head;

                while (walk.getNext() != null) {
                    walk = walk.getNext();
                }

                walk.setNext(newNode);
                newNode.setNext(null);
            }
        }
    }

    private boolean comparison(Points point) {

        LinkedListNode walk = head;
        boolean control = true;

        while (walk != null) {

            if (walk.getPoint().getX() == point.getX() && walk.getPoint().getY() == point.getY()) {
                control = false;
            }

            walk = walk.getNext();
        }
        return control;
    }

    public void delete() {
        LinkedListNode temp;

        if (head != null) {

            temp = head;
            head = head.getNext();
            temp.setNext(null);
        }
    }
}