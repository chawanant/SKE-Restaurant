
public class meal {
private String menu;
private double prices;
public meal(String name,double price) {
	this.menu=name;
	this.prices=price;
}
public String getname() {
	return menu;
}
public double getprice() {
	return prices;
}
public void setname(String menu) {
	this.menu = menu;
}
public void setprice(double prices) {
	this.prices = prices;
}

}
