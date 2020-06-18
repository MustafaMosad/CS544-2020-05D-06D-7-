package com.cs544.group7.reservationService.producer;


public class Email {
		
		private String emailAddress;
	    private String subject;
	    private String messageBody;

	    public Email() {
	    }

	    public Email(String emailAddress, String subject, String messageBody) {
	        this.emailAddress = emailAddress;
	    	this.subject = subject;
	        this.messageBody = messageBody;
	    }

	    
		public String getEmailAddress() {
			return emailAddress;
		}

		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
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
	    
}
	    


