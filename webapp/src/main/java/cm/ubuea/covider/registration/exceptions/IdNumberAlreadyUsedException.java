package cm.ubuea.covider.registration.exceptions;

public class IdNumberAlreadyUsedException extends BadRequestAlertException {

    private static final long serialVersionUID = 1L;

    public IdNumberAlreadyUsedException() {
        super(ErrorConstants.ID_NUMBER_ALREADY_USED_TYPE, "Login name already used!", "userManagement", "userexists");
    }
}
