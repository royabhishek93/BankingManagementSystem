package com.abhishek.response;

import java.util.Date;

public class ApiResponse<T> {

	private Status status;
	private T payload;
	private Object errors;
	private Object metadata;

	
	public ApiResponse() {
	}

	
	public ApiResponse(Status status, T payload, Object errors, Object metadata) {
		super();
		this.status = status;
		this.payload = payload;
		this.errors = errors;
		this.metadata = metadata;
	}


	public static <T> ApiResponse<T> badRequest() {
		ApiResponse<T> response = new ApiResponse<>();
		response.setStatus(Status.BAD_REQUEST);
		return response;
	}

	public static <T> ApiResponse<T> ok() {
		ApiResponse<T> response = new ApiResponse<>();
		response.setStatus(Status.OK);
		return response;
	}

	public static <T> ApiResponse<T> unauthorized() {
		ApiResponse<T> response = new ApiResponse<>();
		response.setStatus(Status.UNAUTHORIZED);
		return response;
	}

	public static <T> ApiResponse<T> validationException() {
		ApiResponse<T> response = new ApiResponse<>();
		response.setStatus(Status.VALIDATION_EXCEPTION);
		return response;
	}

	public static <T> ApiResponse<T> wrongCredentials() {
		ApiResponse<T> response = new ApiResponse<>();
		response.setStatus(Status.WRONG_CREDENTIALS);
		return response;
	}

	public static <T> ApiResponse<T> accessDenied() {
		ApiResponse<T> response = new ApiResponse<>();
		response.setStatus(Status.ACCESS_DENIED);
		return response;
	}

	public static <T> ApiResponse<T> exception() {
		ApiResponse<T> response = new ApiResponse<>();
		response.setStatus(Status.EXCEPTION);
		return response;
	}

	public static <T> ApiResponse<T> notFound() {
		ApiResponse<T> response = new ApiResponse<>();
		response.setStatus(Status.NOT_FOUND);
		return response;
	}

	public static <T> ApiResponse<T> duplicateEntity() {
		ApiResponse<T> response = new ApiResponse<>();
		response.setStatus(Status.DUPLICATE_ENTITY);
		return response;
	}

	public void addErrorMsgToResponse(String errorMsg, Exception ex) {
		ApiResponseError error = new ApiResponseError();
		error.setDetails(errorMsg);
		error.setMessage(ex.getMessage());
		error.setTimestamp(new Date());
		setErrors(error);
	}

	public enum Status {
		OK, BAD_REQUEST, UNAUTHORIZED, VALIDATION_EXCEPTION, EXCEPTION, WRONG_CREDENTIALS, ACCESS_DENIED, NOT_FOUND,
		DUPLICATE_ENTITY
	}

	public static class PageMetadata {
		private int size;
		private long totalElements;
		private int totalPages;
		private int number;

		public PageMetadata(int size, long totalElements, int totalPages, int number) {
			this.size = size;
			this.totalElements = totalElements;
			this.totalPages = totalPages;
			this.number = number;
		}
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public T getPayload() {
		return payload;
	}

	public ApiResponse setPayload(T payload) {
		this.payload = payload;
		return this;
	}

	public Object getErrors() {
		return errors;
	}

	public void setErrors(Object errors) {
		this.errors = errors;
	}

	public Object getMetadata() {
		return metadata;
	}

	public void setMetadata(Object metadata) {
		this.metadata = metadata;
	}

}
