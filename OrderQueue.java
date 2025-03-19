import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class OrderQueue {
    Queue<String> regularOrders = new LinkedList<>();
    Queue<String> priorityOrders = new LinkedList<>();

    /**
     * Add to regular order
     * @param order order
     */
    public void addOrderToRegularQueue(String order) {
        regularOrders.add(order);
    }

    /**
     * Add to priority order
     * @param order order
     */
    public void addOrderToPriorityQueue(String order) {
        priorityOrders.add(order);
    }

    /**
     * Prints out the next order while removing it.
     * @return the next order (while removing it)
     */
    public String nextOrder() {
        if ((priorityOrders.peek() == null) && (regularOrders.peek() == null)) {
            return "No order in any queues.";
        } else if (priorityOrders.peek() == null) {
            return regularOrders.remove();
        }
        return priorityOrders.remove();
    }

    /**
     * Remove order if order is found.
     * @param order an order.
     * @return boolean; true if successful, otherwise, false.
     */
    public boolean removeOrder(String order) {
        boolean found = false;
        Iterator priorityIterator = priorityOrders.iterator();
        Iterator regularIterator = regularOrders.iterator();
        while (priorityIterator.hasNext()) {
            String nextOrder = priorityIterator.next() + "";
            if (order.equals(nextOrder)) {
                priorityIterator.remove();
                found = true;
            }
        }
        while (regularIterator.hasNext()) {
            String nextOrder = regularIterator.next() + "";
            if (order.equals(nextOrder)) {
                regularIterator.remove();
                found = true;
            }
        }
        return found;
    }

    /**
     * Display orders.
     */
    public void displayOrder() {
        Iterator priorityIterator = priorityOrders.iterator();
        Iterator regularIterator = regularOrders.iterator();
        int p = 1;
        int r = 1;
        System.out.println("Priority orders: ");
        while (priorityIterator.hasNext()) {
            System.out.println(p + ") " + priorityIterator.next());
            p++;
        }
        System.out.println("Regular orders: ");
        while (regularIterator.hasNext()) {
            System.out.println(r + ") " + regularIterator.next());
            r++;
        }
    }

    // Uses recursion to check if an order exists in either queue.
    // Returns a boolean depending on whether the order is found or not.
    /**
     * Check if an order exists in any queues.
     * @param order order you want to check.
     * @return true if found, else false.
     */
    public boolean checkOrder(String order) {
        return checkInQueue(priorityOrders, order, 0) || checkInQueue(regularOrders, order, 0);
    }

    // Helper function using recursion
    private boolean checkInQueue(Queue<String> queue, String order, int index) {
        if (queue.isEmpty() || index >= queue.size()) {
            return false;
        }
        String[] ordersArray = queue.toArray(new String[0]);
        if (ordersArray[index].equals(order)) {
            return true;
        }
        return checkInQueue(queue, order, index + 1);
    }

}
