package io.kodlama.hrms.core.utilities.results;

public class ErrorResult extends Result{

    public ErrorResult(String message) {
        super(true, message);
    }

    public ErrorResult() {
        super(true);
    }
}
