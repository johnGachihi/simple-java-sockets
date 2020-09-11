package client;

import utils.Response;
import utils.Step;

public class ClientProtocol {
    public Step getStep(Response response) {
        return response.getStep();
    }
}
