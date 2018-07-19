package com.cognizant.sharecar.api.resource;

public class DeleteTaskResponse {

    private boolean successfullyDeleted;
    private int id;

    public boolean isSuccessfullyDeleted() {
        return successfullyDeleted;
    }

    public void setSuccessfullyDeleted(boolean successfullyDeleted) {
        this.successfullyDeleted = successfullyDeleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
