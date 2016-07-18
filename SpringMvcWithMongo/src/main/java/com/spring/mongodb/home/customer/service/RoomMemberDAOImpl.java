package com.spring.mongodb.home.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.spring.mongodb.home.customer.model.RoomMember;

@Repository
public class RoomMemberDAOImpl implements RoomMemberDAO {

	@Autowired
	private MongoTemplate template;

	private static String ROOM_MEMBER_COLLECTION_NAME = "RoomMember";
	public static final String ID = "_id";

	@Override
	public void registerAmountSpentDetails(RoomMember roomMember) {
		roomMember.setId(null);
		template.save(roomMember, ROOM_MEMBER_COLLECTION_NAME);
	}

	@Override
	public List<RoomMember> listOfMembers() {
		List<RoomMember> list = template.findAll(RoomMember.class,
				ROOM_MEMBER_COLLECTION_NAME);
		return list;
	}

	@Override
	public void deleteMember(final String id) {
		template.remove(new Query(Criteria.where(ID).is(id)), RoomMember.class);
	}

	@Override
	public void updateMember(RoomMember member) {
		Query query = new Query();
		query.addCriteria(Criteria.where(ID).is(member.getId()));
		RoomMember member2 = template.findOne(query, RoomMember.class);
		member2.setMailId(member.getMailId());
		member2.setName(member.getName());
		member2.setSpentOn(member.getSpentOn());
		member2.setSpentVia(member.getSpentVia());
		member2.setAmount(member.getAmount());
		template.save(member2);
	}

	@Override
	public RoomMember editMember(final String id) {
		return template.findOne(new Query(Criteria.where(ID).is(id)),
				RoomMember.class);
	}

}
