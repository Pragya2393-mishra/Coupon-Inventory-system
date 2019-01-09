
public interface LinkedListInterface {

	boolean isEmpty();
	// Returns true if the linkedlist is empty, else returns False
	
	int getSize();
	//Returns the size of the linkedlist. return type is an integer
	
	void insert(String couponprovider, String name_of_product, String status_of_Coupon, double price,
			double discount_rate, double expiration_period, double Coupon_ID, double Discounted_price);
    // Adds a new object to the linkedlist, an object that has parameters like couponprovider, name_of_product, status_of_coupon, price,
	//dicount rate, expiration_period, Coupon_ID, Discounted_price
	
	void delete(double pos);
	// Deletes a node at a given position
	
	void display();
	// Displays the entire linkedlist
	
	boolean Linearsearch(double Coupon_ID);
	// Searches the given Coupon-ID in a list using Linear search and returns true if found, else returns false
	
	void lowtohigh();
	// Sorts and displays the entire data on the basis of ascending order of discount_rate
	
	void lowtohigh_price();
	// Sorts and displays the entire data on the basis of ascending order of price
	
	void lowtohigh_Discounted_price();
	//Sorts and displays the entire data on the basis of ascending order of discounted price
	
	void lowtohigh_expiration();
	// Sorts and displays the entire data on the basis of ascending order of expiration period
	
	void lowtohigh_couponID();
	// Sorts and displays the entire data on the basis of ascending order of coupon ID
	
	void filter_discount_rate(double dr, int gl);
	// Filters the entire data on the basis of given discount rate
	
	void filter_price(double dr, int gl);
	// Filters the entire data on the basis of given price
	
	void filter_discounted_price(double dr, int gl);
	// Filters the entire data on the basis of given discounted price
	
	void filter_expiration(double dr, int gl);
	// Filters the entire data on the basis of given expiration period
	
	void filter_couponID(double dr, int gl);
	// Filters the entire data on the basis of given coupon ID
	
	void filter_Coupon_Provider(String val);
	// Filters the entire data on the basis of given Coupon Provider
	
	void filter_Product_name(String val);
	// Filters the entire data on the basis of given Product name
	
	int BinarySearch(double ID);
	// Extracts Coupon ID from Linkedlist into an array and provides the data to searchalgo
	
	int searchalgo(double arr[], int l, int h, double x);
	// Searches the given Coupon-ID in a list using Binary search and returns true if found, else returns false
}




