import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantManager {
private static	ArrayList<String> MenuItems = new ArrayList<>();
private	static ArrayList<Double> Price = new ArrayList<>();
public static void init(){
	String filename ="src/data/Menu.txt";
	ClassLoader loader = RestaurantManager.class.getClassLoader();
	InputStream in = loader.getResourceAsStream(filename);
	if (in == null) {
		System.out.println("Could not access file"+filename);
		return;
	}
	Scanner reader = new Scanner(in);
	while(reader.hasNextLine()) {
		String line = reader.nextLine().trim();
	 if (line.startsWith("#")) {
		 continue;
	 }
	 String []array = line.split(";");
       MenuItems.add(array[0]);
	 Price.add(Double.parseDouble(array[1]));
	}
reader.close();
}
public static String[] getMenuItems() {
	String[] menu = MenuItems.toArray(new String[MenuItems.size()]);
	return menu;
}
public static double[] getPrice() {
	double[] priceMenu = new double[Price.size()];
for(int x = 0 ; x < priceMenu.length ; x++) {
	priceMenu [x] = Price.get(x);
}
return priceMenu;
}




}
