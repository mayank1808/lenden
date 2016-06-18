package com.vedaan.lenden.catalog.constants;

public class Constants {

	public static class EmailConstants {
		public static final String MAIL_CLIENT_SOCKET = "MAIL.CLIENT.SOCKET.ADDRESS";
		public static final String FROM_EMAIL = "EMAIL_FROM";
		public static final String FROM_NAME = "FROM_NAME";
		public static final String REPLY_TO = "REPLY_TO";
		public static final String TRIGGER_ID = "EMAIL_TRIGGER_ID";
		public static final String TEMPLATE_NAME = "EMAIL_TEMPLATE_NAME";
		public static final String SUBJECT = "SUBJECT";
	}

	public static class SmsConstants {
		public static final String MAIL_CLIENT_SOCKET = "SMS.CLIENT.SOCKET.ADDRESS";

		public static final String TRIGGER_ID = "SMS_TRIGGER_ID";
		public static final String TEMPLATE_NAME = "SMS_TEMPLATE_NAME";
	}
	
	  // //////////////////////////RESPONSE CODES///////////////////////////////////////////////////////////////////////////////
    public static final int SUCCESSFULL_OPERATION = 2000;
    
    public static final int GATE_WAY_REST_EXCEPTION = 4001;

    public static final int MESSAGE_NOT_READABLE_EXCEPTION = 4002;

    public static final int MISSING_SERVLET_EXCEPTION = 4003;

    public static final int MEDIA_NOT_SUPPORTED_EXCEPTION = 4004;

    public static final int TYPE_MISMATCH_EXCEPTION = 4005;

    public static final int GENERAL_EXCEPTION = 4006;

    public static final int INVALID_PARAMETER_EXCEPTION = 4007;
    
    public static final int SQL_UNIQUE_EXCEPTION = 4101;
    
    public static final int PROXY_AUTHORIZATION_REQUIRED = 407;

}
