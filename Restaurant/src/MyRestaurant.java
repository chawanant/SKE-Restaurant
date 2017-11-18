import java.util.Scanner;
/**
 * Main class for SKE Restaurarnt order taking application.
 * It displays a menu and accepts items to order.
 * When done, it prints a receipt including the order total.
 *
 * @author Chawanant Kerdchuen
 */
public class MyRestaurant {

	private static Scanner console = new Scanner(System.in);
	static RestaurantManager manager = new RestaurantManager();
	public static String[] menuitem = RestaurantManager.getMenuItems();
	static double [] price ;
	static int[] order;

	public static void setPrice() {
		price=RestaurantManager.getPrice();
	}

	public static void setOrder() {
	order=new int[menuitem.length];
	}

	public static int getIntReply(String prompt) {
		System.out.print(prompt);
		int c = console.nextInt();
		return c;
	}

	public static String getStringReply(String prompt) {
		System.out.print(prompt);
		String c = console.next();
		return c;
	}

	static void menu() {
		System.out.print("---------Welcome to SKE Restaurant---------\n");
		System.out.printf("  %s%42s\n", "Menu", "Price");
		for (int i = 0; i < menuitem.length; i++) {
			System.out.printf("[%d] %-20s%20.2f %s Baht.\n", i + 1, menuitem[i], price[i]);
		}
		System.out.println();
		System.out.println("[e] Edit order");
		System.out.println("[p] Print order");
		System.out.println("[c] Review order and Checkout");
		System.out.println("[x] Cancel order");
		
	}

	static int Total() {
		int sum = 0;
		for (int i = 0; i < menuitem.length; i++) {
			sum += price[i] * order[i];
		}
		return sum;
	}

	public static void PrintOrder() {
		System.out.print("+--------------------------------+\n");
		System.out.print("+\tMenu\t|Quantity| Price +\n");
		System.out.print("+--------------------------------+\n");
		for (int i = 0; i < menuitem.length; i++) {
			if (price[i] * order[i] > 0)
				System.out.printf("|\t%-8s|  %d\t |  %d\t |\n", menuitem[i], order[i], order[i] * price[i]);
		}
		System.out.print("+--------------------------------+\n");
		System.out.printf("|\tTotal\t\t    %d  |\n", Total());
		System.out.print("+--------------------------------+\n");
	}

	public static void choice() {

		while (true) {
			System.out.println();
			String choice = getStringReply("Input Choice: ");
			if (choice.equals("e")) {
				editOrder();
			} else if (choice.equals("p")) {
				PrintOrder();
			} else if (choice.equals("c")) {
				ReviewOrder();
				break;
			} else if (choice.equals("x")) {
				cancelOrder();
			}

			if (choice.charAt(0) > 48 && choice.charAt(0) < 57) {
				int cnum = Integer.parseInt(choice);
				int quan = getIntReply("Enter Quantity: ");
				 order[cnum - 1] += quan;}

			}
		}
	

	public static void editOrder() {
		int enumber = getIntReply("Num Change: ");
		int quantity = getIntReply("Quantity Change:");
		order[enumber - 1] = quantity;
	}
	public static void cancelOrder() {
		int cnumber = getIntReply("Cancel Num: ");
		order[cnumber - 1] = 0;
	}
	

	// Print Receipt
	public static void ReviewOrder() {
		System.out.println("SKE RESTAURANT");
		System.out.println();
		System.out.printf("Time:", System.currentTimeMillis());
		System.out.printf("Menu","","Price");
		for (int i = 0; i < menuitem.length; i++) {
			if(order[i]<0) {
				System.out.printf(" %d%-3s%-28s%12.2f%-5s\n", order[i], "", menuitem[i], order[i] * price[i], "");
				
			}
		}
		System.out.printf("Total Price ",Total());
	}
	public static void main(String[] args) {
	RestaurantManager.init();
	setOrder();
	setPrice();
	menu();
	choice();
	}
	}
