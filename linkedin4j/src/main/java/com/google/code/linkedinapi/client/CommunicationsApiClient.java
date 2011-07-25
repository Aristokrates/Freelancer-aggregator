/*
 * Copyright 2010-2011 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */
package com.google.code.linkedinapi.client;

import java.util.List;

import com.google.code.linkedinapi.client.constant.ApplicationConstants;
import com.google.code.linkedinapi.schema.ApiStandardProfileRequest;
import com.google.code.linkedinapi.schema.Person;

/**
 * The Interface CommunicationsApiClient.
 */
public interface CommunicationsApiClient extends LinkedInAuthenticationClient {

    // Messaging API

    /**
     * Send message.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1044">http://developer.linkedin.com/docs/DOC-1044</a>
     * 
     * @param recepientIds the recepient ids
     * @param subject the subject
     * @param message the message
     */
    public void sendMessage(List<String> recepientIds, String subject, String message);

    // Invitation API

    /**
     * Send invite.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1012">http://developer.linkedin.com/docs/DOC-1012</a>
     * 
     * @param email the email
     * @param firstName the first name
     * @param lastName the last name
     * @param subject the subject
     * @param message the message
     */
    public void sendInviteByEmail(String email, String firstName, String lastName, String subject, String message);

    /**
     * Send invite.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1012">http://developer.linkedin.com/docs/DOC-1012</a>
     * <p>
     * To call this method one needs an auth header parameter. This can be obtained by getting {@link ApiStandardProfileRequest#getHeaders()} from {@link Person#getApiStandardProfileRequest()}
     * and then getting the value of header with name {@link ApplicationConstants#AUTH_HEADER_NAME}. 
     * </p> 
     * 
     * @param recepientId the recepient id
     * @param subject the subject
     * @param message the message
     * @param authHeader the auth header
     */
    public void sendInviteById(String recepientId, String subject, String message, String authHeader);
    
    /**
     * Send invite.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1012">http://developer.linkedin.com/docs/DOC-1012</a>
     * <p>
     * To call this method one needs an auth header parameter. This can be obtained by getting {@link ApiStandardProfileRequest#getHeaders()} from {@link Person#getApiStandardProfileRequest()}
     * and then getting the value of header with name {@link ApplicationConstants#AUTH_HEADER_NAME}. 
     * </p> 
     * 
     * @param recepient the recepient
     * @param subject the subject
     * @param message the message
     */
    public void sendInviteToPerson(Person recepient, String subject, String message);
}
