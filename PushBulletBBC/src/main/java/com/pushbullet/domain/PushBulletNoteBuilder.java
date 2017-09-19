package com.pushbullet.domain;

/* The PushBulletNoteBuilder class allows conversion of a note request to a note class.
 * We require this so that notification request information, such as username is not seen by the lower level PushBulletAPI which is
 * only concerned with the external Pushbullet API
 */
public class PushBulletNoteBuilder {

	PushBulletNote pushBulletNote;
	
	public PushBulletNoteBuilder(PushBulletNotificationRequest pushBulletNotificationRequest) {
		pushBulletNote = new PushBulletNote(pushBulletNotificationRequest.getTitle(),
				                            pushBulletNotificationRequest.getBody());
	}
	
	public PushBulletNote getPushBulletNote() {
		return pushBulletNote;
	}
}
