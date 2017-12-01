package com.helmo.NatAdmin.reception;

import com.helmo.NatAdmin.models.Comment;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class RComment extends IdentifiedModel
		implements ReceptionObject<Comment> {
	
	private String commentary;
	
	private Timestamp date;
	
	private RUser rUser;
	
	private RObservation rObservation;
	
	public RComment() {
	}
	
	@Override
	public Comment getModel() {
		Comment rtn = new Comment();
		rtn.setCommentary(this.commentary);
		rtn.setDate(this.date);
		rtn.setUser(this.rUser.getModel());
		rtn.setObservation(this.rObservation.getModel());
		return rtn;
	}
}