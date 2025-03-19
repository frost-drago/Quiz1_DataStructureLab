public class Main {
    public static void main(String[] args) {

        OrderQueue orderQueue = new OrderQueue();
        orderQueue.addOrderToPriorityQueue("Veggies?");
        orderQueue.addOrderToPriorityQueue("Tauge");
        orderQueue.addOrderToRegularQueue("Bakmi");

        orderQueue.displayOrder();
        System.out.println(orderQueue.nextOrder());
        System.out.println(orderQueue.checkOrder("Bakmi")); // Should return true
        System.out.println(orderQueue.removeOrder("Bakmi")); // Should return true
        System.out.println(orderQueue.checkOrder("Bakmi")); // Should return false
    }
}