//package assignment;

public class Address 
{
	private String addressLocal;
	private String city;
	private String state;
	private int zip;
		
	public String getAddressLocal() 
	{
		return addressLocal;
	}
	public void setAddressLocal(String addressLocal) 
	{
		this.addressLocal = addressLocal;
	}
	public String getCity() 
	{
		return city;
	}
	public void setCity(String city) 
	{
		this.city = city;
	}
	public String getState() 
	{
		return state;
	}
	public void setState(String state) 
	{
		this.state = state;
	}
	public int getZip() 
	{
		return zip;
	}
	public void setZip(int zip) 
	{
		this.zip = zip;
	}
	
	@Override
	public String toString() 
	{
		return "local address is " + addressLocal + ", city is " + city + ", state is " + state + ", zip is " + zip ;
	}
}
