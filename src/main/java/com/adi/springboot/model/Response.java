package com.adi.springboot.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Response {

    private boolean status = false;

    private Integer responseCode = 500;

    private String responseMessage = "Internal server error";
   
    private String responseMsgCode;

//    @JsonIgnore
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    /* @JsonIgnore */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String authKey;

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return the responseCode
     */
    public Integer getResponseCode() {
        return responseCode;
    }

    /**
     * @param responseCode the responseCode to set
     */
    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    /**
     * @return the responseMessage
     */
    public String getResponseMessage() {
        return responseMessage;
    }

    /**
     * @param responseMessage the responseMessage to set
     */
    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    /**
     * @return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * @return the authKey
     */
    public String getAuthKey() {
        return authKey;
    }

    /**
     * @param authKey the authKey to set
     */
    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }

	public String getResponseMsgCode() {
		return responseMsgCode;
	}

	public void setResponseMsgCode(String responseMsgCode) {
		this.responseMsgCode = responseMsgCode;
	}

	@Override
	public String toString() {
		return "Response [status=" + status + ", responseCode=" + responseCode + ", responseMessage=" + responseMessage
				+ ", responseMsgCode=" + responseMsgCode + ", data=" + data + ", authKey=" + authKey + "]";
	}

	

	


}
