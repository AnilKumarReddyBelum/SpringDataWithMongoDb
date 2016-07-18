package com.spring.mongodb.home.customer.service;

import java.util.List;

import com.spring.mongodb.home.customer.exception.BackEndException;
import com.spring.mongodb.home.customer.exception.RoomMemberException;
import com.spring.mongodb.home.customer.model.RoomMember;

public interface RoomMemberDAO {

	void registerAmountSpentDetails(RoomMember roomMember);

	List<RoomMember> listOfMembers() throws BackEndException;

	void deleteMember(final String id) throws RoomMemberException;

	void updateMember(RoomMember member) throws RoomMemberException;
	
	RoomMember editMember(final String id) throws RoomMemberException;
}
