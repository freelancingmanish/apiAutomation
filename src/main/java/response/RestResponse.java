package response;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class RestResponse {
    public List<Result> result;
    public List<String> messages;
}
