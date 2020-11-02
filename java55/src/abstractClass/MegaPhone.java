package abstractClass;

public interface MegaPhone extends Phone, Gps {
	final String COMPANY = "mega";
	void siri();
	void internet();
}
