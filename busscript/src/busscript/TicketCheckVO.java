package busscript;

public class TicketCheckVO {
	String ticket_id;
	String departure_date;
	String departure_point;
	String destination;
	String bus_info;
	String platform_info;
	String seat_num;
	int price;
	public String getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(String ticket_id) {
		this.ticket_id = ticket_id;
	}
	public String getDeparture_date() {
		return departure_date;
	}
	public void setDeparture_date(String departure_date) {
		this.departure_date = departure_date;
	}
	public String getDeparture_point() {
		return departure_point;
	}
	public void setDeparture_point(String departure_point) {
		this.departure_point = departure_point;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getBus_info() {
		return bus_info;
	}
	public void setBus_info(String bus_info) {
		this.bus_info = bus_info;
	}
	public String getPlatform_info() {
		return platform_info;
	}
	public void setPlatform_info(String platform_info) {
		this.platform_info = platform_info;
	}
	public String getSeat_num() {
		return seat_num;
	}
	public void setSeat_num(String seat_num) {
		this.seat_num = seat_num;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
