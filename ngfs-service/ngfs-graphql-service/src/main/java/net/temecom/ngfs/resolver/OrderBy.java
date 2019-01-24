package net.temecom.ngfs.resolver;
import org.springframework.stereotype.Component;
@Component
public class OrderBy {
	private String field; 
	private String direction;
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
}
