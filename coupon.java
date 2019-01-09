
public class coupon {
	protected String Couponprovider, Name_of_product, Status_of_Coupon;
	protected double price, discount_rate, discounted_price, expiration_period, Coupon_ID;
	protected String Customer_name;
	
	public String getCustomer_name() {
		return Customer_name;
	}
	public void setCustomer_name(String customer_name) {
		Customer_name = customer_name;
	}
	public double getDiscounted_price() {
		return discounted_price;
	}
	public void setDiscounted_price(double discounted_price) {
		this.discounted_price = discounted_price;
	}

	protected coupon link;
	
	public double getCoupon_ID() {
		return Coupon_ID;
	}
	public coupon getLink() {
		return link;
	}
	public void setLink(coupon link) {
		this.link = link;
	}
	public void setCoupon_ID(double coupon_ID) {
		Coupon_ID = coupon_ID;
	}
	public String getCouponprovider() {
		return Couponprovider;
	}
	public void setCouponprovider(String couponprovider) {
		Couponprovider = couponprovider;
	}
	public String getName_of_product() {
		return Name_of_product;
	}
	public void setName_of_product(String name_of_product) {
		Name_of_product = name_of_product;
	}
	public String getStatus_of_Coupon() {
		return Status_of_Coupon;
	}
	public void setStatus_of_Coupon(String status_of_Coupon) {
		Status_of_Coupon = status_of_Coupon;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount_rate() {
		return discount_rate;
	}
	public void setDiscount_rate(double discount_rate) {
		this.discount_rate = discount_rate;
	}
	public double getExpiration_period() {
		return expiration_period;
	}
	public void setExpiration_period(double expiration_period) {
		this.expiration_period = expiration_period;
	}
	public coupon(String couponprovider, String name_of_product, String status_of_Coupon, double price,
			double discount_rate, double expiration_period, double Coupon_ID, double discounted_price, coupon n) {
		super();
		Couponprovider = couponprovider;
		Name_of_product = name_of_product;
		Status_of_Coupon = status_of_Coupon;
		//Customer_name = customer_Name;
		this.price = price;
		this.discount_rate = discount_rate;
		this.expiration_period = expiration_period;
		this.Coupon_ID = Coupon_ID;
		this.discounted_price= discounted_price;
	}
	
	public coupon() {
		super();
		Couponprovider = null;
		Name_of_product = null;
		Status_of_Coupon = null;
		price = 0;
		discount_rate = 0;
		expiration_period = 0;
		Coupon_ID = 0;
		//Customer_name = null;
		
	}
	
	
	

}
