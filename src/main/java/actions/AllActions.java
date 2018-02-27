package actions;
import com.jayway.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import response.CustomResponse;
import response.Result;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static com.jayway.restassured.RestAssured.given;


public class AllActions {

    protected static void interactAndProvideResult(List<Result> allResult) {
        do{
            Scanner scanner = new Scanner(System.in);
            System.out.println("=============== Enter Name Of State ===============");
            String userInput = scanner.nextLine();
            Result result = findDetailsUsingNameOrAbbr(userInput, allResult);
            if (result == null) {
                System.out.println("Entered State Not Available In List !");
                continue;
            }
            System.out.println("The Largest City In State " + userInput + " Is ======== :  " + result.getLargest_city());
            System.out.println("The Capital Of State " + userInput + " Is ======== : " + result.getCapital());
        }while(true);
    }

    protected static CustomResponse getApiResponse() {
        Response response = callTekTaskApi();
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(response.asString(), CustomResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Result findDetailsUsingNameOrAbbr(String value, List<Result> result) {
        if(value.equalsIgnoreCase("stop")){
            System.out.println("Exit Instruction Obtained! Terminating Execution! ");
            System.exit(0);
        }
        for (Result res : result) {
            if (res.abbr.equalsIgnoreCase(value) || res.name.equalsIgnoreCase(value)) {
                return res;
            }
        }
        return null;
    }

    private static Response callTekTaskApi() {
        String url = "http://services.groupkt.com/state/get/USA/all";
        return given().request().with().when().get(url);
    }
}
