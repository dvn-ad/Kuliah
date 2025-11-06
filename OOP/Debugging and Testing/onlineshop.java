public class onlineshop {
    public static void main(String[] args) {
        SalesItem item1 = new SalesItem("Laptop Asus", 15000000);
        item1.addComment("Fajar", "Produk bagus!", 5);
        item1.addComment("Miko", "Produk biasa saja", 3);
        item1.addComment("Fajar", "Produk sangat memuaskan!", 4); // Duplicate author
        item1.addComment("Davin", "Produk jelek banget", -100); // Invalid rating
        
        item1.showInfo();
        
        Comment best = item1.findMostHelpfulComment();
        if (best != null) {
            System.out.println("Most helpful comment:");
            best.print();
        } else {
            System.out.println("No comments yet.");
        }
    }
}
