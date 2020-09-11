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
                step = Step.ONE;
                break;
            case ONE:
                String[] inputs = request.getMessage().split(",");
                if (inputs.length == 2)
                    step = Step.TWO;
                break;
            case TWO:
                inputs = request.getMessage().split(",");
                if (inputs.length == 4) {
                    step = Step.THREE;
                }
                break;
            case THREE:
                inputs = request.getMessage().split(",");
                if (inputs.length == 4) {
                    step = Step.THREE;
                }
                break;
        }

        return new Response(this.step, message);
    }
}
