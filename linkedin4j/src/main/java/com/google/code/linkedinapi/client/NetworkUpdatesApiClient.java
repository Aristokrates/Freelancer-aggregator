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

import java.util.Date;
import java.util.Set;

import com.google.code.linkedinapi.client.enumeration.NetworkUpdateType;
import com.google.code.linkedinapi.schema.Likes;
import com.google.code.linkedinapi.schema.Network;
import com.google.code.linkedinapi.schema.UpdateComments;
import com.google.code.linkedinapi.schema.VisibilityType;

/**
 * The Interface NetworkUpdatesApiClient.
 */
public interface NetworkUpdatesApiClient extends LinkedInAuthenticationClient {

    // Network Updates API. Return Network Update bean

    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     * 
     * @return the network updates
     */
    public Network getNetworkUpdates();

    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     * 
     * @param start the start
     * @param count the count
     * 
     * @return the network updates
     */
    public Network getNetworkUpdates(int start, int count);

    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     * 
     * @param startDate the start date
     * @param endDate the end date
     * 
     * @return the network updates
     */
    public Network getNetworkUpdates(Date startDate, Date endDate);

    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     * 
     * @param updateTypes the update types
     * 
     * @return the network updates
     */
    public Network getNetworkUpdates(Set<NetworkUpdateType> updateTypes);

    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     * 
     * @param updateTypes the update types
     * @param start the start
     * @param count the count
     * 
     * @return the network updates
     */
    public Network getNetworkUpdates(Set<NetworkUpdateType> updateTypes, int start, int count);

    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     * 
     * @param updateTypes the update types
     * @param startDate the start date
     * @param endDate the end date
     * 
     * @return the network updates
     */
    public Network getNetworkUpdates(Set<NetworkUpdateType> updateTypes, Date startDate, Date endDate);

    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     * 
     * @param updateTypes the update types
     * @param start the start
     * @param count the count
     * @param startDate the start date
     * @param endDate the end date
     * @return the network updates
     */
    public Network getNetworkUpdates(Set<NetworkUpdateType> updateTypes, int start, int count, Date startDate,
                                     Date endDate);


    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     * 
     * @param updateTypes the update types
     * @param start the start
     * @param count the count
     * @param startDate the start date
     * @param endDate the end date
     * @return the network updates
     */
    public Network getNetworkUpdates(Set<NetworkUpdateType> updateTypes, int start, int count, Date startDate,
                                     Date endDate, boolean showHiddenMembers);
    

    // Self Updates
    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     * 
     * @return the network updates
     */
    public Network getUserUpdates();

    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     * 
     * @param start the start
     * @param count the count
     * 
     * @return the network updates
     */
    public Network getUserUpdates(int start, int count);

    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     * 
     * @param startDate the start date
     * @param endDate the end date
     * 
     * @return the network updates
     */
    public Network getUserUpdates(Date startDate, Date endDate);

    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     * 
     * @param updateTypes the update types
     * 
     * @return the network updates
     */
    public Network getUserUpdates(Set<NetworkUpdateType> updateTypes);

    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     * 
     * @param updateTypes the update types
     * @param start the start
     * @param count the count
     * 
     * @return the network updates
     */
    public Network getUserUpdates(Set<NetworkUpdateType> updateTypes, int start, int count);

    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     * 
     * @param updateTypes the update types
     * @param startDate the start date
     * @param endDate the end date
     * 
     * @return the network updates
     */
    public Network getUserUpdates(Set<NetworkUpdateType> updateTypes, Date startDate, Date endDate);

    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     * 
     * @param updateTypes the update types
     * @param start the start
     * @param count the count
     * @param startDate the start date
     * @param endDate the end date
     * @return the network updates
     */
    public Network getUserUpdates(Set<NetworkUpdateType> updateTypes, int start, int count, Date startDate,
                                     Date endDate);
    
    
    // other user updates
    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     * 
     * @return the network updates
     */
    public Network getUserUpdates(String id);

    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     * 
     * @param start the start
     * @param count the count
     * 
     * @return the network updates
     */
    public Network getUserUpdates(String id, int start, int count);

    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     * 
     * @param startDate the start date
     * @param endDate the end date
     * 
     * @return the network updates
     */
    public Network getUserUpdates(String id, Date startDate, Date endDate);

    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     * 
     * @param updateTypes the update types
     * 
     * @return the network updates
     */
    public Network getUserUpdates(String id, Set<NetworkUpdateType> updateTypes);

    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     * 
     * @param updateTypes the update types
     * @param start the start
     * @param count the count
     * 
     * @return the network updates
     */
    public Network getUserUpdates(String id, Set<NetworkUpdateType> updateTypes, int start, int count);

    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     * 
     * @param updateTypes the update types
     * @param startDate the start date
     * @param endDate the end date
     * 
     * @return the network updates
     */
    public Network getUserUpdates(String id, Set<NetworkUpdateType> updateTypes, Date startDate, Date endDate);

    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     * 
     * @param updateTypes the update types
     * @param start the start
     * @param count the count
     * @param startDate the start date
     * @param endDate the end date
     * @return the network updates
     */
    public Network getUserUpdates(String id, Set<NetworkUpdateType> updateTypes, int start, int count, Date startDate,
                                     Date endDate);
    
    /**
     * Gets the network update comments.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1043">http://developer.linkedin.com/docs/DOC-1043</a>
     * 
     * @param networkUpdateId the network update id
     * 
     * @return the network update comments
     */
    public UpdateComments getNetworkUpdateComments(String networkUpdateId);

    /**
     * Gets the network update likes.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1043">http://developer.linkedin.com/docs/DOC-1043</a>
     * 
     * @param networkUpdateId the network update id
     * 
     * @return the network update likes
     */
    public Likes getNetworkUpdateLikes(String networkUpdateId);

    // Post Network Update API
    /**
     * Post network update.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1009">http://developer.linkedin.com/docs/DOC-1009</a>
     * 
     * @param updateText the update text
     */
    public void postNetworkUpdate(String updateText);

    // Post Comment API

    /**
     * Post comment.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1043">http://developer.linkedin.com/docs/DOC-1043</a>
     * 
     * @param networkUpdateId the network update id
     * @param commentText the comment text
     */
    public void postComment(String networkUpdateId, String commentText);

    /**
     * Like post.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1043">http://developer.linkedin.com/docs/DOC-1043</a>
     * 
     * @param networkUpdateId the network update id
     */
    public void likePost(String networkUpdateId);
    
    /**
     * Unlike post.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1043">http://developer.linkedin.com/docs/DOC-1043</a>
     * 
     * @param networkUpdateId the network update id
     */
    public void unlikePost(String networkUpdateId);
    
    // Status Update API

    /**
     * Update current status.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1007">http://developer.linkedin.com/docs/DOC-1007</a>
     * 
     * @param status the status
     */
    public void updateCurrentStatus(String status);

    /**
     * Update current status.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1007">http://developer.linkedin.com/docs/DOC-1007</a>
     * 
     * @param status the status
     */
    public void updateCurrentStatus(String status, boolean postToTwitter);
    
    /**
     * Delete current status.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1007">http://developer.linkedin.com/docs/DOC-1007</a>
     */
    public void deleteCurrentStatus();

    // Share API.
    /**
     * Post share.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1212">http://developer.linkedin.com/docs/DOC-1212</a>
     * 
     * @param commentText the comment text
     * @param title the title
     * @param url the url
     * @param imageUrl the image url
     * @param visibility the visibility
     */
    public void postShare(String commentText, String title, String url, String imageUrl, VisibilityType visibility);
    
    /**
     * Post share.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1212">http://developer.linkedin.com/docs/DOC-1212</a>
     * 
     * @param commentText the comment text
     * @param title the title
     * @param url the url
     * @param imageUrl the image url
     * @param visibility the visibility
     */
    public void postShare(String commentText, String title, String url, String imageUrl, VisibilityType visibility, boolean postToTwitter);
    
    /**
     * Post share.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1212">http://developer.linkedin.com/docs/DOC-1212</a>
     * 
     * @param commentText the comment text
     * @param title the title
     * @param description the description
     * @param url the url
     * @param imageUrl the image url
     * @param visibility the visibility
     */
    public void postShare(String commentText, String title, String description, String url, String imageUrl, VisibilityType visibility);
    
    /**
     * Post share.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1212">http://developer.linkedin.com/docs/DOC-1212</a>
     * 
     * @param commentText the comment text
     * @param title the title
     * @param url the url
     * @param imageUrl the image url
     * @param visibility the visibility
     */
    public void postShare(String commentText, String title, String description, String url, String imageUrl, VisibilityType visibility, boolean postToTwitter);
    
    /**
     * Re-share.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1212">http://developer.linkedin.com/docs/DOC-1212</a>
     * 
     * @param shareId the share id
     * @param visibility the visibility
     */
    public void reShare(String shareId, String commentText, VisibilityType visibility);
}
