package client;

import utils.Response;
import utils.Step;

import java.io.InvalidObjectException;

public class ClientProtocol {
    public Step getStep(Response response) throws InvalidObjectException {
        if (response.getStep() == null) {
            throw new InvalidObjectException("Received response is invalid");
        }
        return response.getStep();
    }
}
