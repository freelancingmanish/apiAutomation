import actions.AllActions;
import response.CustomResponse;
import response.Result;

import java.util.List;


public class Execution extends AllActions {

    public static void main(String[] args) {
        CustomResponse customResponse = getApiResponse();
        if (customResponse == null) {
            System.exit(-1);
        }
        List<Result> allResult = customResponse.getRestResponse().getResult();
        System.out.println("Starting Execution ! Type Stop To Terminate Program !");
        interactAndProvideResult(allResult);
    }
}
