import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class LinkedList implements LinkedListInterface {
	protected coupon start;
	//linkedList l = new linkedList();
	double[] finalprice= new double[50];
	int k = 0, counnt =0;
	public int size;

	public LinkedList() {
		start = null;
		size = 0;
	}

	/* Function to check if list is empty */
	public boolean isEmpty() {
		return start == null;
	}

	/* Function to check size of list */
	public int getSize() {
		return size;
	}

	/* Function to insert an element */
	public void insert(String couponprovider, String name_of_product, String status_of_Coupon, double price,
			double discount_rate, double expiration_period, double Coupon_ID, double Discounted_price) {
		coupon nptr, ptr, tmp = null;
		nptr = new coupon(couponprovider, name_of_product, status_of_Coupon, price, discount_rate, expiration_period, Coupon_ID, Discounted_price, null);
		boolean ins = false;
		if (start == null)
			start = nptr;
		else if (Coupon_ID <= start.getCoupon_ID()) {
			nptr.setLink(start);
			start = nptr;
		} 
		else {
			tmp = start;
			ptr = start.getLink();
			while (ptr != null) {
				if (Coupon_ID >= tmp.getCoupon_ID() && Coupon_ID <= ptr.getCoupon_ID()) {
					tmp.setLink(nptr);
					nptr.setLink(ptr);
					ins = true;
					break;
				} else {
					tmp = ptr;
					ptr = ptr.getLink();
				}
			}
			if (ins == false) {
				tmp.setLink(nptr);
			}
		}
		size++;
	}

	/* Function to delete an element at position */
	public void delete(double pos)
	{
		int ct=0;
		coupon ptr1=start;
		while (ptr1!= null)
		{
			    
				ct++;
				if(ptr1.getCoupon_ID()== pos)
				{
					break;
				}
				;
				
			    
				ptr1= ptr1.getLink();
		}

		if (ct == 1) 
		{
			start = start.getLink();
			size--;
			return;
		}
		if (ct == size)
		{
			coupon ptr = start;
			for (int i = 1; i < size - 1; i++)
				ptr = ptr.getLink();
			ptr.setLink(null);
			size--;
			return;
		}
		coupon ptr = start;
		ct = ct - 1;
		for (int i = 1; i < size - 1; i++)
		{
			if (i == ct)
			{
				coupon tmp = ptr.getLink();
				tmp = tmp.getLink();
				ptr.setLink(tmp);
				break;
			}
			ptr = ptr.getLink();
		}
		size--;
	}

	/* Function to display elements */
	public void display()
	{
		
		if (size == 0) {
			System.out.print("empty\n");
			return;
		}
		coupon ptr = start;
		while (ptr.getLink() != null) {
			System.out.print(ptr.getCoupon_ID() + "\t" + ptr.getCouponprovider() + "\t" + ptr.getName_of_product() + "\t"
					+ ptr.getStatus_of_Coupon() + "\t" + ptr.getPrice() + "\t" + ptr.getDiscount_rate() + "\t"
					+ ptr.getExpiration_period() +"\t" + ptr.getDiscounted_price() + "\t"  +"\n");
			ptr = ptr.getLink();
		}

		System.out.print(ptr.getCoupon_ID() + "\t" + ptr.getCouponprovider() + "\t" + ptr.getName_of_product() + "\t"
				+ ptr.getStatus_of_Coupon() + "\t" + ptr.getPrice() + "\t" + ptr.getDiscount_rate() + "\t"
				+ ptr.getExpiration_period() +"\t" + ptr.getDiscounted_price() + "\t"  +"\n");
	}

	public boolean Linearsearch(double Coupon_ID) {
		int count = 0;
		if (size == 0)
		{
			System.out.print("empty\n");
			count++;
			System.out.print("Total count for the search in linear is :- " + count + "\n");
			return false;
		}
		coupon ptr = start;
		
		do
		{
            count++;
			if (ptr.Coupon_ID == Coupon_ID) {
				System.out.println(ptr.getCoupon_ID() + "\t" + ptr.getCouponprovider() + "\t" + ptr.getName_of_product()
						+ "\t" + ptr.getStatus_of_Coupon() + "\t" + ptr.getPrice() + "\t" + ptr.getDiscount_rate()
						+ "\t" + ptr.getExpiration_period() + "\t" + ptr.getDiscount_rate());
				System.out.println("Total count by using linear search:- " + count );
				return true;
			}
			ptr = ptr.getLink();
		}while (ptr != null);
		
		
	return false;

	}
	
	public void lowtohigh()
	{
		double arr[]= new double[30];
		int i=0;
		coupon ptr=new coupon();
		ptr.setLink(this.start);
		while (ptr!= null)
			{
				arr[i]= ptr.getDiscount_rate();
				ptr= ptr.getLink();
				i++;
	
				
			}
		double temp;

			for (int z = 1; z<i; z++) {
	            for (int j = 1; j < (i-z); j++) {
	            
	                if (arr[j] > arr[j+1])
	                {
	                	temp = arr[j];
	                	arr[j] = arr[j+1];
	                	arr[j+1] = temp;
	                	
	                }
	            }
	            
	            
	          }
			System.out.println();
			
			coupon ptr1=new coupon();
			
			int j=1;
			System.out.println("Coupon details sorted in accordance to Discount rate:");
			System.out.println();
			do
			{
			ptr1=start;
			while (ptr1!= null)
			{
				    
	
					if(arr[j]==ptr1.getDiscount_rate())
					{
						System.out.println(ptr1.getCouponprovider()+ "\t" + ptr1.getName_of_product() + "\t" + ptr1.getPrice() + "\t" + ptr1.getDiscount_rate()+ "\t" + ptr1.getExpiration_period()+ "\t" + ptr1.getStatus_of_Coupon()+ "\t" + ptr1.getCoupon_ID() + "\t"+ ptr1.getDiscounted_price());
						break;
					}
					
					
				    
					ptr1= ptr1.getLink();
			}
			++j;
			}while(j<11);
			

				
	}
	
	
	public void lowtohigh_price()
	{
		double arr[]= new double[30];
		int i=0;
		coupon ptr=new coupon();
		ptr.setLink(this.start);
		while (ptr!= null)
			{
				arr[i]= ptr.getPrice();
				ptr= ptr.getLink();
				i++;
	
				
			}
		double temp;

			for (int z = 1; z<i; z++) {
	            for (int j = 1; j < (i-z); j++) {
	            
	                if (arr[j] > arr[j+1])
	                {
	                	temp = arr[j];
	                	arr[j] = arr[j+1];
	                	arr[j+1] = temp;
	                	
	                }
	            }
	            
	            
	          }
			System.out.println();
			
			coupon ptr1=new coupon();
			
			int j=1;
			System.out.println("Coupon details sorted in accordance to Price:");
			System.out.println();
			do
			{
			ptr1=start;
			while (ptr1!= null)
			{
				    
	
					if(arr[j]==ptr1.getPrice())
					{
						System.out.println(ptr1.getCouponprovider()+ "\t" + ptr1.getName_of_product() + "\t" + ptr1.getPrice() + "\t" + ptr1.getDiscount_rate()+ "\t" + ptr1.getExpiration_period()+ "\t" + ptr1.getStatus_of_Coupon()+ "\t" + ptr1.getCoupon_ID() + "\t"+ ptr1.getDiscounted_price());
						break;
					}
					
					
				    
					ptr1= ptr1.getLink();
			}
			++j;
			}while(j<11);
			

				
	}

	public void lowtohigh_Discounted_price()
	{
		double arr[]= new double[30];
		int i=0;
		coupon ptr=new coupon();
		ptr.setLink(this.start);
		while (ptr!= null)
			{
				arr[i]= ptr.getDiscounted_price();
				ptr= ptr.getLink();
				i++;
	
				
			}
		double temp;

			for (int z = 1; z<i; z++) {
	            for (int j = 1; j < (i-z); j++) {
	            
	                if (arr[j] > arr[j+1])
	                {
	                	temp = arr[j];
	                	arr[j] = arr[j+1];
	                	arr[j+1] = temp;
	                	
	                }
	            }
	            
	            
	          }
			System.out.println();
			
			coupon ptr1=new coupon();
			
			int j=1;
			System.out.println("Coupon details sorted in accordance to Discounted Price:");
			System.out.println();
			do
			{
			ptr1=start;
			while (ptr1!= null)
			{
				    
	
					if(arr[j]==ptr1.getDiscounted_price())
					{
						System.out.println(ptr1.getCouponprovider()+ "\t" + ptr1.getName_of_product() + "\t" + ptr1.getPrice() + "\t" + ptr1.getDiscount_rate()+ "\t" + ptr1.getExpiration_period()+ "\t" + ptr1.getStatus_of_Coupon()+ "\t" + ptr1.getCoupon_ID() + "\t"+ ptr1.getDiscounted_price());
						break;
					}
					
					
				    
					ptr1= ptr1.getLink();
			}
			++j;
			}while(j<11);
			

				
	}

	public void lowtohigh_expiration()
	{
		double arr[]= new double[30];
		int i=0;
		coupon ptr=new coupon();
		ptr.setLink(this.start);
		while (ptr!= null)
			{
				arr[i]= ptr.getExpiration_period();
				ptr= ptr.getLink();
				i++;
	
				
			}
		double temp;

			for (int z = 1; z<i; z++) {
	            for (int j = 1; j < (i-z); j++) {
	            
	                if (arr[j] > arr[j+1])
	                {
	                	temp = arr[j];
	                	arr[j] = arr[j+1];
	                	arr[j+1] = temp;
	                	
	                }
	            }
	            
	            
	          }
			System.out.println();
			
			coupon ptr1=new coupon();
			
			int j=1;
			System.out.println("Coupon details sorted in accordance to Expiration Period:");
			System.out.println();
			do
			{
			ptr1=start;
			while (ptr1!= null)
			{
				    
	
					if(arr[j]==ptr1.getExpiration_period())
					{
						System.out.println(ptr1.getCouponprovider()+ "\t" + ptr1.getName_of_product() + "\t" + ptr1.getPrice() + "\t" + ptr1.getDiscount_rate()+ "\t" + ptr1.getExpiration_period()+ "\t" + ptr1.getStatus_of_Coupon()+ "\t" + ptr1.getCoupon_ID()+ "\t"+ ptr1.getDiscounted_price());
						break;
					}
					
					
				    
					ptr1= ptr1.getLink();
			}
			++j;
			}while(j<11);
			

				
	}

	public void lowtohigh_couponID()
	{
		double arr[]= new double[30];
		int i=0;
		coupon ptr=new coupon();
		ptr.setLink(this.start);
		while (ptr!= null)
			{
				arr[i]= ptr.getCoupon_ID();
				ptr= ptr.getLink();
				i++;
	
				
			}
		double temp;

			for (int z = 1; z<i; z++) {
	            for (int j = 1; j < (i-z); j++) {
	            
	                if (arr[j] > arr[j+1])
	                {
	                	temp = arr[j];
	                	arr[j] = arr[j+1];
	                	arr[j+1] = temp;
	                	
	                }
	            }
	            
	            
	          }
			System.out.println();
			
			coupon ptr1=new coupon();
			
			int j=1;
			System.out.println("Coupon details sorted in accordance to Coupon ID:");
			System.out.println();
			do
			{
			ptr1=start;
			while (ptr1!= null)
			{
				    
	
					if(arr[j]==ptr1.getCoupon_ID())
					{
						System.out.println(ptr1.getCouponprovider()+ "\t" + ptr1.getName_of_product() + "\t" + ptr1.getPrice() + "\t" + ptr1.getDiscount_rate()+ "\t" + ptr1.getExpiration_period()+ "\t" + ptr1.getStatus_of_Coupon()+ "\t" + ptr1.getCoupon_ID()+ "\t"+ ptr1.getDiscounted_price());
						break;
					}
					
					
				    
					ptr1= ptr1.getLink();
			}
			++j;
			}while(j<11);
			

				
	}

	
	public void filter_discount_rate(double dr, int gl)
	{
		    coupon ptr1=new coupon();
			
			int j=1;
			if(gl==1)
			System.out.println("Coupon details with discount rate greater than or equal to "+ dr + ":");
			else
			System.out.println("Coupon details with discount rate less than "+ dr + ":");
			System.out.println();
			
			ptr1=start;
			while (ptr1!= null)
			{
				    
	                if(gl==1)
	                {
					if(dr<=ptr1.getDiscount_rate())
					{
						System.out.println(ptr1.getCouponprovider()+ "\t" + ptr1.getName_of_product() + "\t" + ptr1.getPrice() + "\t" + ptr1.getDiscount_rate()+ "\t" + ptr1.getExpiration_period()+ "\t" + ptr1.getStatus_of_Coupon()+ "\t" + ptr1.getCoupon_ID()+ "\t"+ ptr1.getDiscounted_price());
						
					}
					}
	                else
	                {
	                	if(dr>ptr1.getDiscount_rate())
						{
							System.out.println(ptr1.getCouponprovider()+ "\t" + ptr1.getName_of_product() + "\t" + ptr1.getPrice() + "\t" + ptr1.getDiscount_rate()+ "\t" + ptr1.getExpiration_period()+ "\t" + ptr1.getStatus_of_Coupon()+ "\t" + ptr1.getCoupon_ID()+ "\t"+ ptr1.getDiscounted_price());
							
						}
	                }
					
				    
					ptr1= ptr1.getLink();
			}
			
			


	}
	
	public void filter_price(double dr, int gl)
	{
		    coupon ptr1=new coupon();
			
			int j=1;
			if(gl==1)
			System.out.println("Coupon details with Price greater than or equal to "+ dr + ":");
			else
			System.out.println("Coupon details with Price rate less than "+ dr + ":");
			System.out.println();
			
			ptr1=start;
			while (ptr1!= null)
			{
				    
	                if(gl==1)
	                {
					if(dr<=ptr1.getPrice())
					{
						System.out.println(ptr1.getCouponprovider()+ "\t" + ptr1.getName_of_product() + "\t" + ptr1.getPrice() + "\t" + ptr1.getDiscount_rate()+ "\t" + ptr1.getExpiration_period()+ "\t" + ptr1.getStatus_of_Coupon()+ "\t" + ptr1.getCoupon_ID()+ "\t"+ ptr1.getDiscounted_price());
						
					}
					}
	                else
	                {
	                	if(dr>ptr1.getPrice())
						{
							System.out.println(ptr1.getCouponprovider()+ "\t" + ptr1.getName_of_product() + "\t" + ptr1.getPrice() + "\t" + ptr1.getDiscount_rate()+ "\t" + ptr1.getExpiration_period()+ "\t" + ptr1.getStatus_of_Coupon()+ "\t" + ptr1.getCoupon_ID()+ "\t"+ ptr1.getDiscounted_price());
							
						}
	                }
					
				    
					ptr1= ptr1.getLink();
			}
			
			


	}

	public void filter_discounted_price(double dr, int gl)
	{
		    coupon ptr1=new coupon();
			
			int j=1;
			if(gl==1)
			System.out.println("Coupon details with discounted price greater than or equal to "+ dr + ":");
			else
			System.out.println("Coupon details with discounted price less than "+ dr + ":");
			System.out.println();
			
			ptr1=start;
			while (ptr1!= null)
			{
				    
	                if(gl==1)
	                {
					if(dr<=ptr1.getDiscounted_price())
					{
						System.out.println(ptr1.getCouponprovider()+ "\t" + ptr1.getName_of_product() + "\t" + ptr1.getPrice() + "\t" + ptr1.getDiscount_rate()+ "\t" + ptr1.getExpiration_period()+ "\t" + ptr1.getStatus_of_Coupon()+ "\t" + ptr1.getCoupon_ID()+ "\t"+ ptr1.getDiscounted_price());
						
					}
					}
	                else
	                {
	                	if(dr>ptr1.getDiscounted_price())
						{
							System.out.println(ptr1.getCouponprovider()+ "\t" + ptr1.getName_of_product() + "\t" + ptr1.getPrice() + "\t" + ptr1.getDiscount_rate()+ "\t" + ptr1.getExpiration_period()+ "\t" + ptr1.getStatus_of_Coupon()+ "\t" + ptr1.getCoupon_ID()+ "\t"+ ptr1.getDiscounted_price());
							
						}
	                }
					
				    
					ptr1= ptr1.getLink();
			}
			
			


	}
	
	public void filter_expiration(double dr, int gl)
	{
		    coupon ptr1=new coupon();
			
			int j=1;
			if(gl==1)
			System.out.println("Coupon details with expiration period greater than or equal to "+ dr + ":");
			else
			System.out.println("Coupon details with expiration period less than "+ dr + ":");
			System.out.println();
			
			ptr1=start;
			while (ptr1!= null)
			{
				    
	                if(gl==1)
	                {
					if(dr<=ptr1.getExpiration_period())
					{
						System.out.println(ptr1.getCouponprovider()+ "\t" + ptr1.getName_of_product() + "\t" + ptr1.getPrice() + "\t" + ptr1.getDiscount_rate()+ "\t" + ptr1.getExpiration_period()+ "\t" + ptr1.getStatus_of_Coupon()+ "\t" + ptr1.getCoupon_ID()+ "\t"+ ptr1.getDiscounted_price());
						
					}
					}
	                else
	                {
	                	if(dr>ptr1.getExpiration_period())
						{
							System.out.println(ptr1.getCouponprovider()+ "\t" + ptr1.getName_of_product() + "\t" + ptr1.getPrice() + "\t" + ptr1.getDiscount_rate()+ "\t" + ptr1.getExpiration_period()+ "\t" + ptr1.getStatus_of_Coupon()+ "\t" + ptr1.getCoupon_ID()+ "\t"+ ptr1.getDiscounted_price());
							
						}
	                }
					
				    
					ptr1= ptr1.getLink();
			}
			
			


	}

	public void filter_couponID(double dr, int gl)
	{
		    coupon ptr1=new coupon();
			
			int j=1;
			if(gl==1)
			System.out.println("Coupon details with Coupon ID greater than or equal to "+ dr + ":");
			else
			System.out.println("Coupon details with Coupon ID rate less than "+ dr + ":");
			System.out.println();
			
			ptr1=start;
			while (ptr1!= null)
			{
				    
	                if(gl==1)
	                {
					if(dr<=ptr1.getCoupon_ID())
					{
						System.out.println(ptr1.getCouponprovider()+ "\t" + ptr1.getName_of_product() + "\t" + ptr1.getPrice() + "\t" + ptr1.getDiscount_rate()+ "\t" + ptr1.getExpiration_period()+ "\t" + ptr1.getStatus_of_Coupon()+ "\t" + ptr1.getCoupon_ID()+ "\t"+ ptr1.getDiscounted_price());
						
					}
					}
	                else
	                {
	                	if(dr>ptr1.getCoupon_ID())
						{
							System.out.println(ptr1.getCouponprovider()+ "\t" + ptr1.getName_of_product() + "\t" + ptr1.getPrice() + "\t" + ptr1.getDiscount_rate()+ "\t" + ptr1.getExpiration_period()+ "\t" + ptr1.getStatus_of_Coupon()+ "\t" + ptr1.getCoupon_ID()+ "\t"+ ptr1.getDiscounted_price());
							
						}
	                }
					
				    
					ptr1= ptr1.getLink();
			}
			
			


	}

	
	public void filter_Coupon_Provider(String val)
	{
		    coupon ptr1=new coupon();
			
			int j=1;
			System.out.println("Coupon details with Coupon Provider "+ val + ":");
			System.out.println();
			//int x=0;
			ptr1=start;
			while (ptr1!= null)
			{
				    
	                
					int z= String.CASE_INSENSITIVE_ORDER.compare(val, ptr1.getCouponprovider());
					//System.out.println("Comparison result : " + z);
					if(z==0)
					{
						System.out.println(ptr1.getCouponprovider()+ "\t" + ptr1.getName_of_product() + "\t" + ptr1.getPrice() + "\t" + ptr1.getDiscount_rate()+ "\t" + ptr1.getExpiration_period()+ "\t" + ptr1.getStatus_of_Coupon()+ "\t" + ptr1.getCoupon_ID()+ "\t"+ ptr1.getDiscounted_price());
						
					}
					
	                				    
					ptr1= ptr1.getLink();
			}
	}
			
		public void filter_Product_name(String val)
			{
				    coupon ptr1=new coupon();
					
					int j=1;
					System.out.println("Coupon details with Product Name "+ val + ":");
					System.out.println();
					//int x=0;
					ptr1=start;
					while (ptr1!= null)
					{
						    
			                
							int z= String.CASE_INSENSITIVE_ORDER.compare(val, ptr1.getName_of_product());
							//System.out.println("Comparison result : " + z);
							if(z==0)
							{
								System.out.println(ptr1.getCouponprovider()+ "\t" + ptr1.getName_of_product() + "\t" + ptr1.getPrice() + "\t" + ptr1.getDiscount_rate()+ "\t" + ptr1.getExpiration_period()+ "\t" + ptr1.getStatus_of_Coupon()+ "\t" + ptr1.getCoupon_ID()+ "\t"+ ptr1.getDiscounted_price());
								
							}
							
			                				    
							ptr1= ptr1.getLink();
					}

			


	}


	
	
	
	public int BinarySearch(double ID)
	{
		
		double arr[]= new double[50];
		int i = 0;
		while (start!= null)
		{
			arr[i]= start.getCoupon_ID();
			//System.out.println(arr[i]);
			start= start.getLink();
			i++;
		
			
		}
		//finalID[k]=start.getCoupon_ID();
		//int n = finalID.length;
		//System.out.println(i-1);
		int y =searchalgo(arr,0,i-1, ID);
		if(y!=-1) {
			System.out.println("Number of counts after which the element was found:- " + counnt);
		}
		
		return y;
		
		
	}
	
	 public int searchalgo(double arr[], int l, int h, double x)
	    {
		 	//System.out.println("I am in searchalgo");
	        
	            int mid = (h+ l)/2;
	            //System.out.println(mid);
	            if(l>h)
	            {
	            	return -1;
	            }
	            
	            else
	            {
	            	if(x==arr[mid])
	            	{
	            		counnt++;
	            		return mid;
	            	}
	 
	            	
	            	if (x < arr[mid])
	            	{
	            		counnt++;
	            		return searchalgo(arr, l, mid-1, x);
	            	}
	            	else
	            	{
	            		counnt++;
	            		return searchalgo(arr, mid+1, h, x);
	            	}
	            }
	        
	    }

}



