package response;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Result {
    public String largest_city;
    public String id;
    public String area;
    public String name;
    public String abbr;
    public String capital;
    public String country;
}
