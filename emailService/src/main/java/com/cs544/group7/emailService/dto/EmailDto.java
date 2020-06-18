package com.cs544.group7.emailService.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "All details about requested email ")
public class EmailDto {
	
	    private String to;
	    private String subject;
	    private String messageBody;

	    public EmailDto() {
	    }

	    public EmailDto(String to, String subject, String messageBody) {
	        this.to = to;
	        this.subject = subject;
	        this.messageBody = messageBody;
	    }

	    
		public String getTo() {
			return to;
		}

		public void setTo(String to) {
			this.to = to;
		}

		public String getSubject() {
			return subject;
		}

		public void setSubject(String subject) {
			this.subject = subject;
		}

		public String getMessageBody() {
			return messageBody;
		}

		public void setMessageBody(String messageBody) {
			this.messageBody = messageBody;
		}    
		
		 @Override
		    public String toString() {
		        return "{" +
		                "\"to\":\"" + to + "\"" +
		                ", \"subject\":\"" + subject + "\"" +
		                ", \"messageBody\":\"" + messageBody + "\"" +
		                "}";
		    }
	}

