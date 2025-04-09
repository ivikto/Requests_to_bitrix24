import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.example.Deal;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitrixDealResponse {
    @JsonProperty("result")
    private ResultContainer result;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ResultContainer {
        @JsonProperty("item")
        private Deal deal;
    }
}