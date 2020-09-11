package server;

import utils.Request;
import utils.Response;
import utils.Step;

public class ServerProtocol {
    private Step step = Step.ZERO;

    public Response processRequest(Request request) {
        String message = "";
        switch (step) {
            case ZERO:
                System.out.println("Request toy code and name.");
                step = Step.ONE;
                break;
            case ONE:
                String[] inputs = request.getMessage().split(",");
                if (inputs.length == 2)
                    step = Step.TWO;
                System.out.println("Request toy description, price, date of manufacture and batch number.");
                break;
            case TWO:
                inputs = request.getMessage().split(",");
                if (inputs.length == 4)
                    step = Step.THREE;
                System.out.println("Request toy company name, street address, zip-code and country.");
                break;
            case THREE:
                inputs = request.getMessage().split(",");
                if (inputs.length == 4)
                    step = Step.FOUR;
                System.out.println("Request unique thank you message.");
                break;
            case FOUR:
                String input = request.getMessage();
                if (! input.isBlank())
                    message = "Success";
                break;
        }

        return new Response(this.step, message);
    }
}
