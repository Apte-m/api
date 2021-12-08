package image;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response{

	@JsonProperty("data")
	private Data data;

	@JsonProperty("success")
	private boolean success;

	@JsonProperty("status")
	private int status;

}